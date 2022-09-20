package com.springboot.first.app.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.first.app.Config.CustomUser;
import com.springboot.first.app.Entity.TblUser;
import com.springboot.first.app.Repository.UserRepository;
import com.springboot.first.app.Service.UserService;

@Service
public class UserServiceImp implements UserService, UserDetailsService{
	@Autowired
	UserRepository userRepository;

	@Override
	public TblUser getUserByUserName(String username) {
		TblUser user = userRepository.findTblUserByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not present"));
		return user;
	}

	@Override
	public void createNewUser(TblUser u) {
		userRepository.save(u);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TblUser user = userRepository.findTblUserByUsername(username).get();
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUser(user);
	}

	@Override
	public TblUser getUserById(Integer id) {
		return userRepository.findById(id).get();
	}

}
