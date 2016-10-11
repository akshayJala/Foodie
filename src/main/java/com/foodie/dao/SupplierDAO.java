package com.foodie.dao;

import java.util.List;

import com.foodie.model.Supplier;

public interface SupplierDAO {
	public List<Supplier> list();

	public Supplier get(String id);
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean saveOrUpdate(Supplier supplier);

	public boolean delete(String id);

}
