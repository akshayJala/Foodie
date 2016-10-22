package com.foodie.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodie.model.Cart;

@Repository("cartDAO")
public class CartDAOImpl implements CartDAO{
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private SessionFactory sessionFactory;
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean save(Cart cart){
		try
		{
			sessionFactory.getCurrentSession().save(cart);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Transactional
	public boolean update(Cart cart){
		try
		{
			sessionFactory.getCurrentSession().update(cart);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Transactional
	public boolean delete(String CartId){
		try
		{
			sessionFactory.getCurrentSession().delete(get(CartId));
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Transactional
	public boolean saveorUpdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}
	
	
	@Transactional
	public Cart get(String CartId){
		//select * from Cart where id='id'
		String hql="from Cart where id='"+CartId+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> list=query.list();
		if(list==null||list.isEmpty())
			{
			return null;
			}
		return list.get(0);//return the domain object//not true or false
	}
	
	@Transactional
	public List<Cart> list() {
	List<Cart> listCategory = (List<Cart>)sessionFactory.getCurrentSession()
					.createCriteria(Cart.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

			return listCategory;
		}
	@Transactional
	public List<Cart> list(String loggedInUserid) {
		String hql = "from"+" Cart"+" where userId="+loggedInUserid+"and status='C'";
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Cart> list = (List<Cart>)query.list();
		return list;
	}
@Transactional
	public int TotalAmount(String CartId){
		try{
			String hql = "from Cart where user_id=" + "'" + CartId + "'";
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> all = query.list();
			//tx.commit();
			int k=0;
			for (Cart temp : all) {
				k = k + temp.getTotal_price();
			}		
			return k;	
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
				}

@Transactional
public Long getCount(String username) {
	String hql ="select count(*) from Cart where UserName = '" + username + "'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	Long count = (Long) query.uniqueResult();
	return count;
}

}
