package com.springboot.first.app.service.security;

import org.springframework.stereotype.Service;

import com.springboot.first.app.entity.Post;
import com.springboot.first.app.entity.Role;
import com.springboot.first.app.entity.UserTbl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class UserDetailsImpl implements UserDetails {
	private UserTbl userTbl;
	private Post post;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		System.out.println(userTbl.getUserName());
		for (Role r : userTbl.getRoles()) {
			System.out.print(r.getRoleName());
		}
		List<SimpleGrantedAuthority> list = userTbl.getRoles().stream()
				.map(t -> new SimpleGrantedAuthority(t.getRoleName())).collect(Collectors.toList());
		for (SimpleGrantedAuthority s : list) {
			System.out.print(s.getAuthority());
		}
		return list;
	}

	@Override
	public String getPassword() {
		return userTbl.getPassword();
	}

	public UserDetailsImpl() {
	}

	public UserDetailsImpl(UserTbl userTbl) {
		super();
		this.userTbl = userTbl;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userTbl.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public UserTbl getUserTbl() {
		return userTbl;
	}

	public void setUserTbl(UserTbl userTbl) {
		this.userTbl = userTbl;
	}
}
