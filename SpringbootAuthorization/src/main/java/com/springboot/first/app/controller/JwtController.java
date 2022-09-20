package com.springboot.first.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.app.config.jwt.JwtTokenProvider;
import com.springboot.first.app.entity.UserTbl;
import com.springboot.first.app.service.Impl.UserServiceImpl;
import com.springboot.first.app.service.security.UserDetailsImpl;

@RestController
public class JwtController {
	@Autowired
	JwtTokenProvider tokenProvider;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserTbl userTbl) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userTbl.getUserName(), userTbl.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Not found", e);
		}
		final String jwtToken = tokenProvider.generateToken(new UserDetailsImpl(userTbl));
		return ResponseEntity.ok(jwtToken);
	}
}
