package com.pec.connect.services.impl;

import com.pec.connect.entity.*;
import com.pec.connect.exceptions.ResourceNotFoundException;
import com.pec.connect.repo.*;
import com.pec.connect.services.AuthAdminService;
import com.pec.connect.services.IdentityService;
import com.pec.connect.services.PermissionService;
import com.pec.connect.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthAdminServiceImpl implements AuthAdminService {

    @Autowired UserRoleMappingRepository userRoleMappingRepository;

    @Autowired RolePermissionMappingRepository rolePermissionMappingRepository;

    @Autowired IdentityService identityService;

    @Autowired RoleService roleService;

    @Autowired PermissionService permissionService;

    @Override
    public UserRoleMapping createRoleMapping(UserRoleMapping userRoleMapping) throws ResourceNotFoundException {
        Identity identity = identityService.getUserById(userRoleMapping.getUid());
        Role role = roleService.getRoleById(userRoleMapping.getRoleId());

        if(identity == null || role == null){
            throw new ResourceNotFoundException("Invalid user id or role id");
        }
        try {
            userRoleMappingRepository.save(userRoleMapping);
        }catch (Exception e){}
        return userRoleMappingRepository.findById(userRoleMapping.getId()).orElse(null);

    }

    @Override
    public List<UserRoleMapping> getUserRoleMapping() {
        return userRoleMappingRepository.findAll();
    }

    @Override
    public List<RolePermissionMapping> getRolePermission() {
        return rolePermissionMappingRepository.findAll();
    }

    @Override
    public RolePermissionMapping createRolePermissionMapping(RolePermissionMapping rolePermissionMapping) throws
            ResourceNotFoundException {
        Permission permission = permissionService.getPermissionById(rolePermissionMapping.getPermissionId());
        Role role = roleService.getRoleById(rolePermissionMapping.getRoleId());

        if(permission == null || role == null){
            throw new ResourceNotFoundException("Invalid permission id or role id");
        }
        try {
            rolePermissionMappingRepository.save(rolePermissionMapping);
        }catch (Exception e){}
        return rolePermissionMappingRepository.findById(rolePermissionMapping.getId()).orElse(null);
    }
}
