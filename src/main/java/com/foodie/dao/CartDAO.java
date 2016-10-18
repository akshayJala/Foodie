package com.foodie.dao;

import java.util.List;

import com.foodie.model.Cart;
import com.foodie.model.User;

public interface CartDAO {
	public List<Cart> list();
	public List<Cart> list(String loggedInUserid);
	public Cart get(String CartId);
	public boolean save(Cart cart);
	public boolean update(Cart cart);
	public boolean saveorUpdate(Cart cart);
	public boolean delete(String CartId);
	public int TotalAmount(String loggedInUserid);
}
