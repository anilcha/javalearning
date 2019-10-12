package com.vastika.uis.dao;

import java.util.List;

import com.vastika.uis.model.User;

public interface UserDao {
	
	void saveUser (User user);
	
	void updateUser (User user);
	
	void deleteUser (int id);
	
	User getUserInfoById (int id);
	
	List<User> getAllUserInfo();
	
}
