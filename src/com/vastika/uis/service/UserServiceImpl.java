package com.vastika.uis.service;

import java.util.List;

import com.vastika.uis.dao.UserDao;
import com.vastika.uis.dao.UserDaoImpl;
import com.vastika.uis.model.User;

public class UserServiceImpl implements UserService{
	
	UserDao userDao = new UserDaoImpl();

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}
	
	@Override
	public void resetPassword(User user) {
	userDao.resetPassword(user);	
		
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

	@Override
	public User getUserInfoById(int id) {
		userDao.getUserInfoById(id);
		return userDao.getUserInfoById(id);
	}

	@Override
	public List<User> getAllUserInfo() {
		userDao.getAllUserInfo();
		return userDao.getAllUserInfo();
	}

	@Override
	public User getUserByUsernameAndPassword(String user_name, String password) {
		userDao.getUserByUsernameAndPassword(user_name, password);
		
		return userDao.getUserByUsernameAndPassword(user_name, password);
	}

	@Override
	public User GetUserByUsernameAndEmail(String user_name, String email) {
		userDao.getUserByUsernameAndEmail(user_name, email);
		
		return userDao.getUserByUsernameAndEmail(user_name, email);
	}

}
