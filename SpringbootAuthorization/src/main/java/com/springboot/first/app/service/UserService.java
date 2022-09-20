package com.springboot.first.app.service;

import java.util.Optional;

import com.springboot.first.app.entity.UserTbl;

public interface UserService {
	public Optional<UserTbl> getUserByUserName(String userName);
}
