package com.foodie.dao;

import java.util.List;

import com.foodie.model.User;

public interface UserDAO {
	public List<User> list();
	public User get(String UserId);
	public boolean saveorUpdate(User user);
	public boolean delete(String UserId);
	public String getRole();
	public User isValidUser(String UserId, String pwd);

}
