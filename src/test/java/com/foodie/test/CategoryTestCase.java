package com.foodie.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.foodie.dao.CategoryDAO;
import com.foodie.model.Category;

import junit.framework.Assert;

public class CategoryTestCase {

	
	@Autowired
	static//auto generated
	CategoryDAO categoryDAO;
	@Autowired
	static//auto generated
	Category category;
	@Autowired
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		category=(Category) context.getBean("category");
		
		
	}
	@Test
public void createCategory(){
	category.setId("Food13");
	category.setName("FoodIteme22");
	category.setDescription("this is vege122");
	
	Assert.assertEquals("createCategory",true,categoryDAO.saveOrUpdate(category));
	
}
	//@Test
	//public void deleteCategory(){
		//Assert.assertEquals("deleteCategory",true,categoryDAO.delete("Food13"));
		
//}
	//@SuppressWarnings("deprecation")
	//@Test
	//public void listCategory(){
	//	Assert.assertEquals("listCategory",20, categoryDAO.list().size());
		
	//}
}
