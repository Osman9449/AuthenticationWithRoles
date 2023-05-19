package com.example.usersroles.repository;

import com.example.usersroles.dto.RoleDto;
import com.example.usersroles.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

}
