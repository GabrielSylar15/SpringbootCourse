package com.springboot.first.app.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.first.app.entity.UserTbl;
import com.springboot.first.app.repository.UserRepository;
import com.springboot.first.app.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<UserTbl> getUserByUserName(String userName) {
		return userRepository.findUserTblByUserName(userName);
	}

}
