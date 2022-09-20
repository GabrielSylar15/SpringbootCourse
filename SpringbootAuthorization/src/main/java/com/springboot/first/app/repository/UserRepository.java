package com.springboot.first.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.first.app.entity.UserTbl;
@Repository
public interface UserRepository extends JpaRepository<UserTbl, Integer>{
	Optional<UserTbl> findUserTblByUserName(String username);
}
