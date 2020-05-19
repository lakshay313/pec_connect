package com.pec.connect.controlllers.admin;

import com.pec.connect.entity.RolePermissionMapping;
import com.pec.connect.entity.UserRoleMapping;
import com.pec.connect.exceptions.ResourceNotFoundException;
import com.pec.connect.services.AuthAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthAdmin {

    @Autowired AuthAdminService authAdminService;

    @PostMapping("/role-mapping")
    public UserRoleMapping createRoleMapping(@RequestBody UserRoleMapping userRoleMapping) throws ResourceNotFoundException {
        return authAdminService.createRoleMapping(userRoleMapping);
    }

    @GetMapping("/role-mapping")
    public List<UserRoleMapping> getRoleMapping() {
        return authAdminService.getUserRoleMapping();
    }

    @PostMapping("/permission-mapping")
    public RolePermissionMapping createPermissionMapping(@RequestBody RolePermissionMapping rolePermissionMapping)
            throws ResourceNotFoundException {
        return authAdminService.createRolePermissionMapping(rolePermissionMapping);
    }

    @GetMapping("/permission-mapping")
    public List<RolePermissionMapping> getPermissionMapping() {
        return authAdminService.getRolePermission();
    }

}
