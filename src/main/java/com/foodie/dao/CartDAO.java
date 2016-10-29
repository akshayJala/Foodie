package com.foodie.dao;

import java.util.List;

import com.foodie.model.Cart;
import com.foodie.model.User;

public interface CartDAO {
	
	public Cart getCart(int id);
	public void saveOrUpdate(Cart cart);
	public void delete(int id);
	public List<Cart> list() ;
	//public int getTotalAmount(String id);

}
