package com.example.usersroles.service.auth;

import com.example.usersroles.entity.UserEntity;
import com.example.usersroles.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("Action.log.loadUserByUsername.start");
        var userEntity = userRepository.findByUserName(username);
        if(userEntity == null) throw new RuntimeException("USER_NOT_FOUND");

        log.info("Action.log.loadUserByUsername.end");
        return new CustomUserDetails(userEntity);

    }
}
