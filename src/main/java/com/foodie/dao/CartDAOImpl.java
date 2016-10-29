package com.foodie.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.foodie.model.Cart;

@SuppressWarnings("deprecation")
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CartDAOImpl(SessionFactory sessionFactory){   //Constructor
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public void saveOrUpdate(Cart cart){            //save or update
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		System.out.println("connect to controller");
	}
	
	@Transactional
	public void delete(int id){
		Cart cartToDelete = new Cart();
		cartToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(cartToDelete);
	
	}
	
		/*cart.setUserID(id);
		try {
			sessionFactory.getCurrentSession().delete(cart);
			
		} catch (HibernateException e) {
			e.printStackTrace();
			return e.getMessage();
			// TODO: handle exception
		}*/
		
	
	
	@Transactional
	public Cart getCart(int id){
		String hql = "from Cart where userID=" + "'" + id + "'  and status = " + "N";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
	
	
		@SuppressWarnings("unchecked")
		List<Cart> listCart= (List<Cart>)query.getResultList();
		
		if(listCart!=null &&!(listCart.isEmpty()))
		{
			return listCart.get(0);
		}
		System.out.println("connect to controller");
		return null;
		
	}
	
	@Transactional
	public List<Cart> list() {
		
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) sessionFactory
				.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listCart;
	}
	
	@Transactional
	public int getTotalAmount(String id){
		String hql="select sum(price) from Cart where userID='"+id+"'";
		//Query query=sessionFactory.getCurrentSession().createQuery(hql);
		//int sum=query.uniqueResult();
		return 5677;
	}
	

	

}

