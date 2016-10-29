package com.foodie.Controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodie.dao.CartDAO;
import com.foodie.dao.CategoryDAO;
import com.foodie.dao.ItemDAO;
import com.foodie.model.Cart;
import com.foodie.model.Category;
import com.foodie.model.Item;
import com.foodie.model.User;


@Controller
public class AdminController {
	Logger log=LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private Item item;
	
	@Autowired
	private Category category;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ItemDAO itemDAO;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private User user;
	
	@RequestMapping("/AddCategory")
	public ModelAndView categories(){
		log.debug("manage categories method starts");
		ModelAndView mv=new ModelAndView("/AddCategory");
		mv.addObject("category",category);
		mv.addObject("isAdminClickedCategory","true");
		mv.addObject("categoryList",categoryDAO.list());
		log.debug("manage categories method ends");
		return mv;
	}
	@RequestMapping("/AddItems")
	public ModelAndView items(){
		log.debug("manage item method starts");
		ModelAndView mv=new ModelAndView("/AddItems");
		mv.addObject("item",item);
		mv.addObject("isAdminClickedItems","true");
		
		mv.addObject("itemList",itemDAO.list());
		log.debug("manage item method ends");
		return mv;
	}
    //added "/Cart" to top of controller

}
