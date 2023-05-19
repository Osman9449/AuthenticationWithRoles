package com.example.usersroles.service;

import com.example.usersroles.mapper.UserMapper;
import com.example.usersroles.dto.UserDto;
import com.example.usersroles.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    public final UserRepository userRepository ;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserDto getUser(Long id){
        log.info("Action.log.getUser.start");
        return UserMapper.INSTANCE.userEntityToUserDto(userRepository.findById(id).orElseThrow());
    }
    public List<UserDto> getUsers(){
        log.info("Action.log.getUsers.start");
        return UserMapper.INSTANCE.userEntitiesToUserDtoList(userRepository.findAll());
    }
    public void addUser(UserDto userDto){
        log.info("Action.log.addUser.start");
        userRepository.save(
                UserMapper.INSTANCE.userDtoToUserEntity(userDto)
        );
    }

}
