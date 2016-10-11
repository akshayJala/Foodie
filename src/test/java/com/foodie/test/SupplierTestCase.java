package com.foodie.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.foodie.dao.SupplierDAO;
import com.foodie.model.Supplier;

import junit.framework.Assert;

public class SupplierTestCase {

	@Autowired
	static//auto generated
	SupplierDAO supplierDAO;
	@Autowired
	static//auto generated
	Supplier supplier;
	@Autowired
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		supplier=(Supplier) context.getBean("supplier");
		
		
	}
	@Test
	public void createSupplier(){
		supplier.setId("1002");
		supplier.setName("vegetrn");
		supplier.setAddress("nagole");
		Assert.assertEquals("suplier testcase",true,supplierDAO.saveOrUpdate(supplier));
	}

}
