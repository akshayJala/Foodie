package com.foodie.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.foodie.model.ShippingAddress;
import com.foodie.model.User;
import com.foodie.model.UserRole;




@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{
	Logger log=LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired 
	private SessionFactory factory;
	
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

	@Transactional
	public boolean delete(String UserId){
		try
		{
			sessionFactory.getCurrentSession().delete(getUser(UserId));
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
	
	@Transactional
	public String getRole() {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(User.class);
		cr.add(Restrictions.eq("roleId",getUser()));
		UserRole ur=(UserRole)cr.uniqueResult();
		tx.commit();
		return ur.getRoleName();
	}
	
	
	private Object getUser() {
		
		return user;
	}

	@Transactional	
	public User getUser(String hql){
		//select * from User where UserId='UserId'
	
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list=query.list();
		if(list==null||list.isEmpty())
			{
			return list.get(0);//return the domain object//not true or false
			}
		return new User();
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

	@Transactional
	public User isValidUser(String UserId, String pwd) {
		log.debug("method starts : isValUserIdUser");
		log.info("The ID is:"+ UserId);
		String hql="";
		log.info("The given query is:"+ hql);
		return getUser(hql);
	}

	@Transactional
	public User verifyUser(User u) {
		
			Session session=factory.getCurrentSession();
			Criteria cr=session.createCriteria(User.class);
			cr.add(Restrictions.eq("UserId",u.getUserId()));
			cr.add(Restrictions.eq("pwd",u.getPwd()));
			User usr=(User)cr.uniqueResult();
			return usr;
	}
	
	@Transactional
	public boolean isAllReadyRegister(String email, boolean b) {
		
		String hql = "from User where emailid ='"+ email +"'";
				
					
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;

	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public ShippingAddress getShippingAddress() {
		Session session=factory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		Criteria cr=session.createCriteria(ShippingAddress.class);
		cr.add(Restrictions.eq("userId",user));
		cr.setFirstResult(1);
		ShippingAddress shippingAddress=(ShippingAddress)cr.uniqueResult();
		tx.commit();
		return shippingAddress;
	}
	
	

	
}

