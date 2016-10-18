package com.foodie.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import com.foodie.model.Item;

@Repository("ItemDAO")
public class ItemDAOImpl implements ItemDAO{
	
	@Autowired
	private Item item;
	
	@Autowired
	private SessionFactory sessionFactory;
	public ItemDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean save(Item item){
		try
		{
			sessionFactory.getCurrentSession().save(item);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Transactional
	public boolean update(Item item){
		try
		{
			sessionFactory.getCurrentSession().update(item);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Transactional
	public boolean delete(String ItemId){
		try
		{
			sessionFactory.getCurrentSession().delete(get(ItemId));
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean saveOrUpdate(Item item) {
		sessionFactory.getCurrentSession().saveOrUpdate(item);
		return true;
	}
	
		
	public Item get(String ItemId){
		//select * from Category where ItemId='ItemId'
		String hql="from Item1 where ItemId='"+ItemId+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Item> list=query.list();
		if(list==null||list.isEmpty())
			{
			return null;
			}
		return list.get(0);
	}
	
	@Transactional
	public List<Item> list() {
		@SuppressWarnings("unchecked")
		List<Item> listProduct = (List<Item>) sessionFactory.getCurrentSession()
				.createCriteria(Item.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listProduct;
	}
	
}