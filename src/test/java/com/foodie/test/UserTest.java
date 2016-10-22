package com.foodie.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.foodie.dao.UserDAO;
import com.foodie.model.User;

public class UserTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.foodie");
		context.refresh();
		UserDAO userDAO=(UserDAO) context.getBean("userDAO");
		User user=(User) context.getBean("user");
		user.setUserId("akshay");
		user.setUserName("Akshay");
		user.setEmail("akki.2244@gmail.com");
		user.setPwd("12345");
		user.setMobile("9999999999");
		user.setRole("ROLE_ADMIN");
		userDAO.saveorUpdate(user);
		System.out.println("Admin is created");
		

	}

}
