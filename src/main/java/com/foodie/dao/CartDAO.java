package com.foodie.dao;

import java.util.List;

import com.foodie.model.Cart;
import com.foodie.model.User;

public interface CartDAO {
	public List<Cart> list();
	public Cart get(String id);
	public boolean save(Cart cart);
	public boolean update(Cart cart);
	public boolean saveorUpdate(Cart cart);
	public boolean delete(String id);
}
