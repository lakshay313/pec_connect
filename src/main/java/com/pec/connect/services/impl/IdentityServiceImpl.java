package com.pec.connect.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pec.connect.dto.LoginResponse;
import com.pec.connect.entity.Identity;
import com.pec.connect.entity.Role;
import com.pec.connect.entity.UserRoleMapping;
import com.pec.connect.enums.RoleType;
import com.pec.connect.exceptions.IdentityNotFoundException;
import com.pec.connect.repo.IdentityRepository;
import com.pec.connect.repo.RolePermissionMappingRepository;
import com.pec.connect.repo.UserRoleMappingRepository;
import com.pec.connect.services.IdentityService;
import com.pec.connect.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class IdentityServiceImpl implements IdentityService {

    @Autowired IdentityRepository identityRepository;

    @Autowired ObjectMapper objectMapper;

    @Autowired RoleService roleService;

    @Autowired UserRoleMappingRepository roleMappingRepository;

    @Value("${service.app-secret}")
    private String appSecret;

    @Override
    public LoginResponse login(String email, String password) throws IdentityNotFoundException {
        Optional<Identity> identityOptional = identityRepository.findByEmailAndPassword(email, password);
        if (!identityOptional.isPresent())
            throw new IdentityNotFoundException("Invalid Credentials");

        LoginResponse response = objectMapper.convertValue(identityOptional.get(), LoginResponse.class);
        String auth = Base64.getEncoder().encodeToString((appSecret + ":" + response.getId() + ":" +
                response.getEmail()).getBytes());
        response.setAccess_token(auth);
        return response;
    }

    private void saveRoleMapping(Long uid, Long role_id){
        UserRoleMapping userRoleMapping = new UserRoleMapping().toBuilder()
                .roleId(role_id)
                .uid(uid)
                .build();
        roleMappingRepository.save(userRoleMapping);
    }
    @Override
    public Identity createUser(Identity identityRequest) {
        try {
            identityRepository.save(identityRequest);
            Role role = roleService.getRolesByName(RoleType.USER.getName()).get(0);
            saveRoleMapping(identityRequest.getId(),role.getId());

        }catch (Exception e){ }
        return identityRepository.findById(identityRequest.getId()).orElse(null);
    }

    @Override
    public Object getAccess(String token) {
        //todo
        return null;
    }

    @Override
    public boolean verifyUser(Long id, String email) {
        return identityRepository.findByIdAndEmail(id, email).isPresent();
    }

    @Override
    public Identity getUserById(Long uid) {
        return identityRepository.findById(uid).orElse(null);
    }

}
