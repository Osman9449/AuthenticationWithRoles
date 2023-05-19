package com.example.usersroles.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("permissionService")
public class PermissionService {

    public boolean hasPermission (List<String> permissionKeys){
        var roles =
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        System.out.println(roles);

        var rolesInText = roles
                .stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority()).toList();

        return rolesInText.stream().anyMatch(o -> permissionKeys.contains(o));
    }
}
