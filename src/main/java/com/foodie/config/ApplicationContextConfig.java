package com.foodie.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.foodie.dao.CartDAO;
import com.foodie.dao.CartDAOImpl;
import com.foodie.dao.CategoryDAO;
import com.foodie.dao.CategoryDAOImpl;
import com.foodie.dao.ItemDAO;
import com.foodie.dao.ItemDAOImpl;
import com.foodie.dao.SupplierDAO;
import com.foodie.dao.SupplierDAOImpl;
import com.foodie.dao.UserDAO;
import com.foodie.dao.UserDAOImpl;
import com.foodie.model.Cart;
import com.foodie.model.Category;
import com.foodie.model.Item;
import com.foodie.model.Supplier;
import com.foodie.model.User;
@Configuration
@ComponentScan("com.foodie")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;

	}
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show.sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");		
		return properties;

	}
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClasses(Item.class);
		sessionBuilder.addAnnotatedClasses(User.class);
		sessionBuilder.addAnnotatedClasses(Supplier.class);
		sessionBuilder.addAnnotatedClasses(Cart.class);		
		return sessionBuilder.buildSessionFactory();
		
	}
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "itemDAO")
	public ItemDAO getItemDao(SessionFactory sessionFactory) {
		return new ItemDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "supplierDAO")
	public SupplierDAO getSupplierDao(SessionFactory sessionFactory) {
		return new SupplierDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "cartDAO")
	public CartDAO getCartDao(SessionFactory sessionFactory) {
		return new CartDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDao(SessionFactory sessionFactory) {
		return new UserDAOImpl(sessionFactory);
	}

}
