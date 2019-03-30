package com.zwt.service;

import com.zwt.modle.User;

public interface UserService {
	public boolean addUser(User user);
	public User findUserByMailName(String mMailName);
	public boolean replaceUser(User user);
	
	
	public boolean checkLogin(String userName,String password);
	public boolean checkUserByMailName(String mailName);
}
