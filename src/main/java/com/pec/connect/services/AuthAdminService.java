package com.pec.connect.services;

import com.pec.connect.entity.RolePermissionMapping;
import com.pec.connect.entity.UserRoleMapping;
import com.pec.connect.exceptions.ResourceNotFoundException;

import java.util.List;

public interface AuthAdminService {

    UserRoleMapping createRoleMapping(UserRoleMapping userRoleMapping) throws ResourceNotFoundException;

    List<UserRoleMapping> getUserRoleMapping();

    List<RolePermissionMapping> getRolePermission();

    RolePermissionMapping createRolePermissionMapping(RolePermissionMapping rolePermissionMapping) throws ResourceNotFoundException;
}
