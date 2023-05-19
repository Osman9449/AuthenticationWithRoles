package com.example.usersroles.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    String fullName;

    String userName;

    String password;

    List<RoleDto> roleDtos;

}
