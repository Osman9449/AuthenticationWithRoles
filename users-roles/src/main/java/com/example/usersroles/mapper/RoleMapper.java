package com.example.usersroles.mapper;

import com.example.usersroles.dto.RoleDto;
import com.example.usersroles.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class RoleMapper {

    public static final RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    public abstract RoleEntity roleDtoToRoleEntity(RoleDto roleDto);

    public abstract RoleDto roleEntityToRoleDto(RoleEntity roleEntity);

    public abstract List<RoleDto> roleEntitiesToRoleDtoList(List<RoleEntity> userEntities);
}
