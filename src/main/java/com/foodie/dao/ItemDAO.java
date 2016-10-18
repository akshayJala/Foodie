package com.foodie.dao;

import java.util.List;

import com.foodie.model.Item;
import com.foodie.model.User;

public interface ItemDAO {
	public List<Item> list();
	public Item get(String ItemId);
	public boolean save(Item item);
	public boolean update(Item item);
	public boolean saveOrUpdate(Item item);
	public boolean delete(String ItemId);
}
