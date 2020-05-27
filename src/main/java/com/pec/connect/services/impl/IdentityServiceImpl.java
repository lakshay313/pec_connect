package com.pec.connect.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pec.connect.dto.AuthorisationResponse;
import com.pec.connect.dto.LoginResponse;
import com.pec.connect.entity.*;
import com.pec.connect.enums.RoleType;
import com.pec.connect.exceptions.AuthenticationFailedException;
import com.pec.connect.exceptions.IdentityNotFoundException;
import com.pec.connect.repo.IdentityRepository;
import com.pec.connect.repo.RolePermissionMappingRepository;
import com.pec.connect.repo.UserRoleMappingRepository;
import com.pec.connect.services.IdentityService;
import com.pec.connect.services.PermissionService;
import com.pec.connect.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IdentityServiceImpl implements IdentityService {

    @Autowired
    IdentityRepository identityRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;

    @Autowired
    UserRoleMappingRepository roleMappingRepository;

    @Autowired
    RolePermissionMappingRepository rolePermissionMappingRepository;

    @Value("${service.app-secret}")
    private String appSecret;

    @Override
    public LoginResponse login(String email, String password) throws IdentityNotFoundException {
        Optional<Identity> identityOptional = identityRepository.findByEmailAndPassword(email, password);
        if (!identityOptional.isPresent())
            throw new IdentityNotFoundException("Invalid Credentials");

        LoginResponse response = mapper.convertValue(identityOptional.get(), LoginResponse.class);
        String auth = Base64.getEncoder().encodeToString((appSecret + ":" + response.getId() + ":" +
                response.getEmail()).getBytes());
        response.setAccess_token(auth);
        return response;
    }

    private void saveRoleMapping(Long uid, Long role_id) {
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
            saveRoleMapping(identityRequest.getId(), role.getId());

        } catch (Exception e) {
        }
        return identityRepository.findById(identityRequest.getId()).orElse(null);
    }


    @Override
    public AuthorisationResponse getAccess(String accessToken) throws AuthenticationFailedException {
        Long uid;
        try {
            uid = Long.parseLong(new String(Base64.getDecoder().decode(accessToken)).split(":")[1]);
        } catch (Exception e) {
            throw new AuthenticationFailedException("Invalid access token");
        }

        Identity identity = identityRepository.findById(uid).orElse(null);
        ;
        UserRoleMapping userRoleMapping = roleMappingRepository.findByUid(uid).orElse(null);
        if (identity == null || userRoleMapping == null) {
            throw new AuthenticationFailedException("Invalid access token");
        }
        Role role = roleService.getRoleById(userRoleMapping.getRoleId());
        if (role == null)
            throw new AuthenticationFailedException("Invalid access token");

        List<RolePermissionMapping> rolePermissionMappings = rolePermissionMappingRepository
                .findAllByRoleId(userRoleMapping.getRoleId());

        Map<String, Object> map = new HashMap<>();

        rolePermissionMappings.forEach(rolePermissionMapping -> {
            Permission permission = permissionService.getPermissionById(rolePermissionMapping.getPermissionId());
            map.put(permission.getResource(), permission.getAction());
        });

        AuthorisationResponse response = new AuthorisationResponse().toBuilder()
                .uid(identity.getId())
                .sid(identity.getSid())
                .firstName(identity.getFirstName())
                .lastName(identity.getLastName())
                .role(role.getName())
                .permissions(map)
                .build();

        return response;
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
