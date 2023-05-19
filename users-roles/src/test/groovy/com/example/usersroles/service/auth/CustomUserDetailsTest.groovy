package com.example.usersroles.service.auth

import com.example.usersroles.entity.UserEntity
import io.github.benas.randombeans.EnhancedRandomBuilder
import spock.lang.Specification

class CustomUserDetailsTest extends Specification {

    def random = EnhancedRandomBuilder.aNewEnhancedRandom()

    CustomUserDetails customUserDetails
    def entity = random.nextObject(UserEntity)

    void setup() {
        customUserDetails = new CustomUserDetails(entity)
    }

    def "getPassword success"() {
        when:
        def result = customUserDetails.getPassword()
        then:
        result == entity.getPassword()
    }

    def"getUsername success" (){
        when:
        def result = customUserDetails.getUsername()
        then:
        result == entity.getUserName();
    }
    def"isAccountNonExpired success"(){
        when:
        def status = customUserDetails.isAccountNonExpired()
        then:
        status
    }
}
