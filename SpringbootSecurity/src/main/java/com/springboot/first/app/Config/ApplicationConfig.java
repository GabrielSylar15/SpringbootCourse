package com.springboot.first.app.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springboot.first.app.Service.UserService;
import com.springboot.first.app.Service.Imp.UserServiceImp;

@EnableWebSecurity
public class ApplicationConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserServiceImp userService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}	
	
	@Autowired
	JwtAuthenticationEntryPoint authenticationEntryPoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}

	@Autowired
	JwtAuthenticationFilter filter;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//	      http 
//	      .authorizeRequests()
//	      	.antMatchers("/", "/home").permitAll()
//	      	.anyRequest().authenticated()
//	      	.and()
//	      .formLogin()
//	      	.defaultSuccessUrl("/hello")
//	      	.permitAll()
//	      	.and()
//	      .logout()
//	      	.permitAll();
////	      
	      http.csrf().disable()
	      .authorizeRequests().antMatchers("/login").permitAll()
	      .anyRequest().authenticated()
	      .and()
	      .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
	      .and()
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	      http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	  
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

	}
}
