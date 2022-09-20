package com.springboot.first.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.first.app.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
