package com.foodie.test;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.foodie.dao.CategoryDAO;
import com.foodie.model.Category;

public class CategoryTest {


public static void main(String[] args){
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	//we have to specify in which package the classes are there
	context.scan("com.foodie");
	context.refresh();
	CategoryDAO categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	Category category=(Category) context.getBean("category");
	
	category.setCategoryId("f00045");
	category.setCategoryName("food43");
	category.setDescription("This is Veg");
	
	categoryDAO.saveOrUpdate(category);
	System.out.println("objects are created successfully");
	

	}
}


