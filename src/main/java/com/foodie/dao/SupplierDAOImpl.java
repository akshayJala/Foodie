package com.foodie.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.foodie.model.Category;
import com.foodie.model.Supplier;

@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO{
	
	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
@Transactional
	public boolean save(Supplier supplier){
		try
		{
			sessionFactory.getCurrentSession().save(supplier);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
@Transactional
	public boolean update(Supplier supplier){
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
@Transactional
	public boolean delete(String SupplierId){
		try
		{
			sessionFactory.getCurrentSession().delete(get(SupplierId));
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean saveOrUpdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
	}
	
	@Transactional
	public Supplier get(String SupplierId){
		//select * from Category where SupplierId='SupplierId'
		String hql="from Supplier where SupplierId='"+SupplierId+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list=query.list();
		if(list==null||list.isEmpty())
			{
			return null;
			}
		return list.get(0);
	}
	@Transactional
	public List<Supplier>list(){
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) sessionFactory.getCurrentSession()
				.createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listSupplier;
		
	}
	@Transactional
	public Supplier getByName(String SupplierName) {
		 String hql="from supplier where SupplierName="+ "'"+ SupplierName +"'";
		 Query query=sessionFactory.getCurrentSession().createQuery(hql);
		 @SuppressWarnings("unchecked")
			
		 List<Supplier> listCategory=(List<Supplier>)query.list();
			if(listCategory!=null&&!listCategory.isEmpty()){
				return listCategory.get(0);
			}
		return null;
	}

	
	
}
