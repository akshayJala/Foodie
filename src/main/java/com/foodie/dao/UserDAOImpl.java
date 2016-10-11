package com.foodie.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodie.model.User;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{
	Logger log=LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private User user;
	
	@Autowired
	private SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory){
	try{
		log.info("Connection established");
		this.sessionFactory=sessionFactory;
	}catch(Exception e){
		log.error("Connection not established. check the application"
				+"context java");
		e.printStackTrace();
	}
}

	
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
	public boolean saveorUpdate(User user) {
		log.debug("method starts : saveOrUpdate");
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		log.debug("method ends : saveOrUpdate");
		return true;
		
	}

	
	
		
	public User get(String hql){
		//select * from User where id='id'
	
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list=query.list();
		if(list==null||list.isEmpty())
			{
			return list.get(0);//return the domain object//not true or false
			}
		return null;
	}
	
	@Transactional
	public List<User> list() {
		log.debug("method starts : list");
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
log.debug("method ends : list");
		return list;
	}

	
	public User isValidUser(String id, String password) {
		log.debug("method starts : isValidUser");
		log.info("The ID is:"+ id);
		String hql="from User where id='"+id+"'" + "and"+ "password="+"'"+password+"'" ;
		log.info("The given query is:"+ hql);
		return get(hql);
	}

	
	

	
}

