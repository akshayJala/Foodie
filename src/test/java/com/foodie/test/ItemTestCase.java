package com.foodie.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.foodie.dao.ItemDAO;
import com.foodie.model.Item;

import junit.framework.Assert;

public class ItemTestCase {

	
	@Autowired
	static//auto generated
	ItemDAO itemDAO;
	@Autowired
	static//auto generated
	Item item;
	@Autowired
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		itemDAO=(ItemDAO) context.getBean("itemDAO");
		item=(Item) context.getBean("item");
		
		
	}
	@Test
public void createItem(){
	item.setItemId("Food113h");
	item.setItemName("FoodItem122");
	item.setPrice(160);
	item.setDescription("this is veg122");
	item.setSupplier_id("1002");
	item.setCategory_id("f0001");
	
	
	Assert.assertEquals("item create test case",true,itemDAO.saveOrUpdate(item));
	
}}
	//@Test
	//public void deleteItem(){
		//Assert.assertEquals("deleteCategory",true,itemDAO.delete("f0023"));
	//}	
	
//}
