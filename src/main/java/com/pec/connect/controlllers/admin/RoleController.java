package com.pec.connect.controlllers.admin;

import com.pec.connect.entity.Role;
import com.pec.connect.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/role")
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @GetMapping("/role")
    public List<Role> getRoles(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            return roleService.getRolesByName(name);
        } else {
            return roleService.getRoles();
        }
    }

}
