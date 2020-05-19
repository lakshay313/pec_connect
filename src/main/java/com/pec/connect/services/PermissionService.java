package com.pec.connect.services;

import com.pec.connect.entity.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> getRolesByName(String name);

    List<Permission> getRoles();

    Permission createRole(Permission permission);

    Permission getPermissionById(Long permissionId);
}
