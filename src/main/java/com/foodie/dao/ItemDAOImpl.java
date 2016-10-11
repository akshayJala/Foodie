package com.foodie.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
	public boolean delete(String id){
		try
		{
			sessionFactory.getCurrentSession().delete(get(id));
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
	
		
	public Item get(String id){
		//select * from Category where id='id'
		String hql="from Item1 where id='"+id+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Item> list=query.list();
		if(list==null||list.isEmpty())
			{
			return null;
			}
		return list.get(0);
	}
	
	public List<Item>list(){
		return null;
	}

	
}