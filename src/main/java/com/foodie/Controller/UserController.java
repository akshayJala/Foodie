package com.foodie.Controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.foodie.dao.CartDAO;
import com.foodie.dao.CategoryDAO;
import com.foodie.dao.ItemDAO;

import com.foodie.dao.UserDAO;
import com.foodie.model.Cart;
import com.foodie.model.Category;
import com.foodie.model.Item;

import com.foodie.model.User;

@Controller
public class UserController {
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
	
	Cart cart;
	@Autowired
	CartDAO cartDAO;
	
	HttpSession session;
	@RequestMapping(value="/SignUp", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute User user){
		
		//log.debug("register method starts");
		user.setRole("ROLE_USER");
		ModelAndView mv=new ModelAndView("/UserHome");
		userDAO.saveorUpdate(user);
		
		//log.debug("register method ends");
		return mv;
	}
	@RequestMapping(value="/Login", method=RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute User u){
		ModelAndView mv=new ModelAndView("/Order");
		user=userDAO.verifyUser(u);
		if(user!=null){
			System.out.println("User");
			log.debug("valid");
			if(user.getRole().equals("ROLE_ADMIN")){
				System.out.println("admin");
				log.debug("admin login");
			mv=new ModelAndView("/AdminHome");
		}else {
			System.out.println("home");
			log.debug("user login");
			mv=new ModelAndView("/UserHome");
			
	}
	
		}
		return mv;
	}
		//log.debug("login method starts");
		
	//	user=userDAO.isValidUser(UserId,pwd);
		
	
		//	if(user.getRole().equals("ROLE_ADMIN")){
			//	ModelAndView mv=new ModelAndView("/AdminHome");
				//model.addAttribute("admin", true);
//				session.setAttribute("supplier", supplier);
	//			session.setAttribute("supplierList", supplierDAO.list());
		//		session.setAttribute("category", category);
			//	session.setAttribute("categoryList", categoryDAO.list());
				//session.setAttribute("item", item);
//				session.setAttribute("itemList", itemDAO.list());
	//			return "/AdminHome";
		//	}else if(user.getRole().equals("ROLE_USER")){
			//	ModelAndView mv=new ModelAndView("/UserHome");
				//model.addAttribute("user", true);
//				session.setAttribute("UserName", user.getUserName());
	//			session.setAttribute("UserID", user.getUserId());
		//		return "/UserHome";
//		}else{
	//	model.addAttribute("errorMessage","invalid details");
		//log.debug("login method ends");
		//return "/Order";
	//}}
	
	@RequestMapping("/Logout")
	public ModelAndView logout(HttpServletRequest request,HttpSession session)
	{
		log.debug("logout method starts");
		ModelAndView mv=new ModelAndView("/Order");
		session.invalidate();
		session=request.getSession(true);
		session.setAttribute("category",category);
		session.setAttribute("categoryList",categoryDAO.list());
		
		mv.addObject("logoutMessage","loggedOut successfully");
		mv.addObject("loggedOut","true");
		log.debug("logout method ends");
		return mv;
	}
	@RequestMapping(value="/loginError",method=RequestMethod.GET)
	public String loginError(Model model){
		log.debug("loginError method starts");
		
		model.addAttribute("errorMessage","Login Error");
		log.debug("loginError method ends");
		return "Home";
	}
	@RequestMapping(value="/accessDenied",method=RequestMethod.GET)
	public String accessDenied(Model model){
		log.debug("accessDenied method starts");
		model.addAttribute("errorMessage","Unauthorized entry");
log.debug("accessDenied method ends");
		return "Home";
		
	}
	
}

