package com.foodie.test;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.foodie.dao.ItemDAO;
import com.foodie.model.Item;

public class ItemTest {


public static void main(String[] args){
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	//we have to specify in which package the classes are there
	context.scan("com.foodie");
	context.refresh();
	ItemDAO itemDAO=(ItemDAO) context.getBean("itemDAO");
	Item item=(Item) context.getBean("item");
	
	item.setItemId("f01d4a");
	item.setItemName("foo14b5");
	item.setPrice(120);
	item.setDescription("This is Veg");
	item.setSupplier_id("1002");
	item.setCategory_id("f0001");
	
	itemDAO.saveOrUpdate(item);
	System.out.println("objects are created successfully");
}
}


