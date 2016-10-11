package com.foodie.Controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodie.dao.CategoryDAO;
import com.foodie.dao.ItemDAO;
import com.foodie.dao.SupplierDAO;
import com.foodie.dao.UserDAO;
import com.foodie.model.Category;
import com.foodie.model.Item;
import com.foodie.model.Supplier;
import com.foodie.model.User;

@Controller
public class HomeController {
	Logger log=LoggerFactory.getLogger(HomeController.class);
	@Autowired
	User user;
	@Autowired
	UserDAO userDAO;
	@Autowired
	Category category;
    @Autowired
    CategoryDAO categoryDAO;
	@Autowired
	Item item;
	@Autowired
	ItemDAO itemDAO;
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/")
	public ModelAndView onLoad(HttpSession session){
		log.debug("onLoad method starts");
		ModelAndView mv=new ModelAndView("/Home");
		session.setAttribute("category", category);
		session.setAttribute("item", item);
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("supplier", supplier);
		session.setAttribute("supplierList", supplierDAO.list());
		log.debug("onLoad method ends");
		return mv;
	}
	@RequestMapping(value="User/Register",method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute User user){
		ModelAndView mv=new ModelAndView("Home");
		if(userDAO.get(user.getId())== null){
			userDAO.saveorUpdate(user);
		}else{
			mv.addObject("msg", "User exists");
			
		}
			mv.addObject("successMessage", "successfully registered");
			return mv;
		}

		
		
		

	
	
	
	
	
	
	
	}

	



