package com.example.usersroles.controller;

import com.example.usersroles.dto.UserDto;
import com.example.usersroles.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("{id}")
    @PreAuthorize("@permissionService.hasPermission({'ROLE_USER','ROLE_ADMIN'})")
    public UserDto getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }
    @GetMapping
    @PreAuthorize("@permissionService.hasPermission({'ROLE_ADMIN'})")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }
    @PostMapping
    @PreAuthorize("@permissionService.hasPermission({'ROLE_ADMIN'})")
    public void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }
}
