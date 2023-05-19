package com.example.usersroles.mapper;

import com.example.usersroles.dto.UserDto;
import com.example.usersroles.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source ="roleDtos", target = "roleEntities")
    public abstract UserEntity userDtoToUserEntity(UserDto userDto);

    @Mapping(source = "roleEntities", target = "roleDtos")
    @Mapping(target = "password", ignore = true)
    public abstract UserDto userEntityToUserDto (UserEntity userEntity);

    public abstract List<UserDto> userEntitiesToUserDtoList(List<UserEntity> userEntities);


}
