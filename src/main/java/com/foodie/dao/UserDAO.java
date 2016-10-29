package com.foodie.dao;

import java.util.List;

import com.foodie.model.ShippingAddress;
import com.foodie.model.User;

public interface UserDAO {
	public List<User> list();
	public User verifyUser(User user);
	public User getUser(String UserId);
	public boolean saveorUpdate(User user);
	public boolean delete(String UserId);
	public String getRole();
	public User isValidUser(String UserId, String pwd);
	public boolean isAllReadyRegister(String email, boolean b);
	public ShippingAddress getShippingAddress();
	public Object getUser();
}
