package com.foodie.dao;

import java.util.List;

import com.foodie.model.User;

public interface UserDAO {
	public List<User> list();
	public User get(String id);
	public boolean saveorUpdate(User user);
	public boolean delete(String id);
	public User isValidUser(String id, String password);

}
