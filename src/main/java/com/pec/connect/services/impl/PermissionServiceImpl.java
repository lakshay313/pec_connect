package com.pec.connect.services.impl;

import com.pec.connect.entity.Permission;
import com.pec.connect.repo.PermissionRepository;
import com.pec.connect.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public List<Permission> getRolesByName(String name) {
        return permissionRepository.findAllByName(name);
    }

    @Override
    public List<Permission> getRoles() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission createRole(Permission permission) {
        try {
            permissionRepository.save(permission);
        } catch (Exception e) {
        }
        return permissionRepository.findById(permission.getId()).orElse(null);
    }

    @Override
    public Permission getPermissionById(Long permissionId) {
        return permissionRepository.findById(permissionId).orElse(null);
    }

}
