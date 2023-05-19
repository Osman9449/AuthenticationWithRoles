package com.example.usersroles.service;

import com.example.usersroles.dto.RoleDto;
import com.example.usersroles.mapper.RoleMapper;
import com.example.usersroles.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoleService {
    public final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleDto getRole(Long id) {
        return RoleMapper.INSTANCE.roleEntityToRoleDto(roleRepository.findById(id).orElseThrow());
    }

    public List<RoleDto> getRoles() {
        return RoleMapper.INSTANCE.roleEntitiesToRoleDtoList(roleRepository.findAll());
    }

    public void addRole(RoleDto roleDto) {
        roleRepository.save(
                RoleMapper.INSTANCE.roleDtoToRoleEntity(roleDto)
        );
    }
}
