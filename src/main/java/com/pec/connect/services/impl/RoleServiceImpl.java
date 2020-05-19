package com.pec.connect.services.impl;

import com.pec.connect.entity.Role;
import com.pec.connect.repo.RoleRepository;
import com.pec.connect.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> getRolesByName(String name) {
        return roleRepository.findAllByName(name);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role createRole(Role role) {
        try {
            roleRepository.save(role);
        } catch (Exception e) {
        }
        return roleRepository.findById(role.getId()).orElse(null);
    }

    @Override
    public Role getRoleById(Long roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

}
