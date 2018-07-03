package com.ashutosh.socialhub.dao;

import com.ashutosh.socialhub.domain.UserDetail;

public interface UserDAO {
	
	public boolean registerUser(UserDetail userdetail);
	public boolean updatUser(UserDetail userdetail);
	public UserDetail getUser(String loginname);
	public UserDetail checkUser(UserDetail userdetail);//available or not
	
}
