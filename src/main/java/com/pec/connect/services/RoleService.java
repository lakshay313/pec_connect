package com.pec.connect.services;

import com.pec.connect.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRolesByName(String name);

    List<Role> getRoles();

    Role createRole(Role role);
}
