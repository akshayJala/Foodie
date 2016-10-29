package com.foodie.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.foodie.model.Category;
import com.foodie.model.Item;

@Repository("ItemDAO")
public class ItemDAOImpl implements ItemDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ItemDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		
	}
	@Transactional
	public void saveOrUpdate(Item item)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(item);
	
	}
	@Transactional
	public void delete(String id)
	{
		Item itemtodelete=new Item();
		itemtodelete.setId(id);
		sessionFactory.getCurrentSession().delete(itemtodelete);
		
	}
	@Transactional
	public Item getItem(String id) {
		String hql = "from Item where id=" + "'"+ id +"'";
		Query query= sessionFactory.getCurrentSession().createQuery(hql); 
		List<Item> listItem = (List<Item>)query.list();
		
		if (listItem != null && !listItem.isEmpty()) {
			return listItem.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Item> list() {
		@SuppressWarnings("unchecked")
		List<Item> listItem = (List<Item>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Item.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listItem;
	}
	
	@Transactional
	public Item getByName(String name) {
		String hql = "from Item where name=" + "'"+ name +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Item> listItem = (List<Item>) query.list();
		
		if (listItem != null && !listItem.isEmpty()) {
			return listItem.get(0);
		}
		
		return null;
	}
	
	
}
		