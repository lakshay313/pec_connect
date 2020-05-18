package com.pec.connect.controlllers.admin;

import com.pec.connect.entity.Permission;
import com.pec.connect.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PermissionController {

    @Autowired PermissionService permissionService;

    @PostMapping("/permission")
    public Permission createRole(@RequestBody Permission permission){
        return permissionService.createRole(permission);
    }

    @GetMapping("/permission")
    public List<Permission> getRoles(@RequestParam(value = "name", required = false) String name){
        if(name != null){
            return permissionService.getRolesByName(name);
        }else{
            return permissionService.getRoles();
        }
    }
}
