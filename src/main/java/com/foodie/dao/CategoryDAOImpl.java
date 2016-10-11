package com.foodie.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodie.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private Category category;
	
	@Autowired
	private SessionFactory sessionFactory;
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean save(Category category){
		try
		{
			sessionFactory.getCurrentSession().save(category);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Category category){
		try
		{
			sessionFactory.getCurrentSession().update(category);
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
	public boolean saveOrUpdate(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}
	
	@Transactional	
	public Category get(String id){
		//select * from Category where id='id'
		String hql="from Category where id='"+id+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list = (List<Category>) query.list();
		if(list==null||list.isEmpty())
			{
			return null;
			}
		return list.get(0);//return the domain object//not true or false
	}
	@Transactional
	public List<Category> list() {
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession()
				.createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listCategory;
	}

	
}