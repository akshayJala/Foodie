package com.foodie.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.foodie.dao.CategoryDAO;
import com.foodie.dao.ItemDAO;

import com.foodie.dao.UserDAO;

import com.foodie.dao.CartDAO;
import com.foodie.model.Cart;
import com.foodie.model.Category;
import com.foodie.model.Item;

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
	
	@RequestMapping("/Home")
	public ModelAndView Home(){
		
		ModelAndView mv=new ModelAndView("/Home");
		return mv;
	}
	@RequestMapping("/")
	public ModelAndView onLoad(HttpSession session){
		log.debug("onLoad method starts");
		ModelAndView mv=new ModelAndView("/Home");
		session.setAttribute("category", category);
		session.setAttribute("item", item);
		session.setAttribute("categoryList", categoryDAO.list());
		
		log.debug("onLoad method ends");
		return mv;
	}
	
	@RequestMapping("/About")
	public ModelAndView About(){
		
		ModelAndView mv=new ModelAndView("/About");
		return mv;
	}
	@RequestMapping("/Items")
	public ModelAndView Items(){
		
		ModelAndView mv=new ModelAndView("/Items");
		return mv;
	}
	
	@RequestMapping("/CategoryList")
	public ModelAndView Categories(){
		
		ModelAndView mv=new ModelAndView("/CategoryList");
		return mv;
	}
	@RequestMapping("/CartList")
	public ModelAndView CartList(){
		
		ModelAndView mv=new ModelAndView("/CartList");
		return mv;
	}
	@RequestMapping("/Order")
	public ModelAndView Order(){
		
		ModelAndView mv=new ModelAndView("/Order");
		return mv;
	}	
	
	
	
	

		
		//@RequestMapping(value="/registerHere")
		//public ModelAndView registerHere(){
			//ModelAndView mv=new ModelAndView("/Home");
			//mv.addObject("user", user);
			//mv.addObject("isUserClickedRegisterHere", "true");
			//return mv;
		//}
		

	
	
	
	
	
	
	@RequestMapping(value="/Login")
	public ModelAndView Login(){
		return new ModelAndView("/Login","command",new User());
	}
	
	@RequestMapping(value="/SignUp",method=RequestMethod.GET)
	public ModelAndView SignUp(){
		
		ModelAndView mv=new ModelAndView("/SignUp","command",new User());
		return mv;
	}
	@RequestMapping("/Contact")
	public ModelAndView Contact(){
		
		ModelAndView mv=new ModelAndView("/Contact");
		return mv;
	}
	@RequestMapping("/UserHome")
	public ModelAndView userhome(){
		
		ModelAndView mv=new ModelAndView("/UserHome");
		return mv;
	}
	@RequestMapping("/Details")
	public ModelAndView details(){
		
		ModelAndView mv=new ModelAndView("/Details");
		return mv;
	}
	@RequestMapping("/AdminHome")
	public ModelAndView AdminHome(){
		
		ModelAndView mv=new ModelAndView("/AdminHome");
		return mv;
	}
	@RequestMapping(value="/AddItems",method=RequestMethod.GET)
	public ModelAndView AddItems(){
		
		ModelAndView mv=new ModelAndView("/AddItems","command",new Item());
		return mv;
	}
	@RequestMapping(value="/AddCategory",method=RequestMethod.GET)
	public ModelAndView AddCategory(){
		
		ModelAndView mv=new ModelAndView("/AddCategory","command",new Category());
		return mv;
	}

	
	
	
	
}

	



