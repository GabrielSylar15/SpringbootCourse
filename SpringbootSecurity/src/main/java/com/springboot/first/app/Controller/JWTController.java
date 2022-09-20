package com.springboot.first.app.Controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.app.Config.CustomUser;
import com.springboot.first.app.Config.JWTTokenProvider;
import com.springboot.first.app.Entity.TblUser;
import com.springboot.first.app.Service.Imp.UserServiceImp;

@RestController
public class JWTController {
	@Autowired
	UserServiceImp userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTTokenProvider tokenProvider;
	
	
	@PostMapping("/login")
	public ResponseEntity<String> createToken(@RequestBody TblUser request) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Not found", e);
		}
		final CustomUser userDetails = new CustomUser(userService.getUserByUserName(request.getUsername()));
		final String jwtToken = tokenProvider.generateToken(userDetails);
		System.out.print(jwtToken);
		return ResponseEntity.ok(jwtToken);
	}

	@GetMapping("/hello1")
	public String helloo() {
		return "hello";
	}

	@GetMapping("/hello2")
	public String hii() {
		return "hii";
	}
}
