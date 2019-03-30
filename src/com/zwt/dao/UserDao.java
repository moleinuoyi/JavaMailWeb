package com.zwt.dao;

import com.zwt.modle.User;

public interface UserDao {
	public boolean insertUser(User user);
	public User selectUserByMailName(String mailName);
	
	public boolean updateUser(User user);
}
