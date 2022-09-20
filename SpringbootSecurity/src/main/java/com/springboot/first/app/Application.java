package com.springboot.first.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.first.app.Entity.TblUser;
import com.springboot.first.app.Entity.TblUser;
import com.springboot.first.app.Repository.UserRepository;
import com.springboot.first.app.Service.UserService;

@SpringBootApplication
public class Application{
	 
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
 
	
}
