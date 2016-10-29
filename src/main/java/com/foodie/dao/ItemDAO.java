package com.foodie.dao;

import java.util.List;

import com.foodie.model.Item;
import com.foodie.model.User;

public interface ItemDAO {
	
		public List<Item> list();
		public Item getItem(String id);
		public void saveOrUpdate(Item item);
		public void delete(String id);
		public Item getByName(String name);


	}
