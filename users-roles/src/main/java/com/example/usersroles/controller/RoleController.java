package com.example.usersroles.controller;

import com.example.usersroles.dto.RoleDto;
import com.example.usersroles.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/roles")
public class RoleController {
    public final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping("{id}")
    public RoleDto getRole(@PathVariable("id") Long id){
        return roleService.getRole(id);
    }
    @GetMapping
    public List<RoleDto> getRoles(){
        return roleService.getRoles();
    }

    @PostMapping
    public void addRole(@RequestBody RoleDto roleDto){
        roleService.addRole(roleDto);
    }
}
