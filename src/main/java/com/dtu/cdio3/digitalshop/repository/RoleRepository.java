package com.dtu.cdio3.digitalshop.repository;

import java.util.Optional;

import com.dtu.cdio3.digitalshop.entity.Role;
import com.dtu.cdio3.digitalshop.entity.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}