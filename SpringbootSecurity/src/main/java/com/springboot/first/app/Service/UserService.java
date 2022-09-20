package com.springboot.first.app.Service;

import com.springboot.first.app.Entity.TblUser;

public interface UserService {
	public TblUser getUserByUserName(String username);
	public void createNewUser(TblUser u);
	public TblUser getUserById(Integer id);
}
