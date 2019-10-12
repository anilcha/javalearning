package com.vastika.uis.service;

import java.util.List;

import com.vastika.uis.model.User;

public interface UserService {
	
	void saveUser (User user); 
		
	void updateUser (User user) ;
	
	void deleteUser (int id); 
	
	User getUserInfoById(int id); 
	
	List<User> getAllUserInfo();

}
