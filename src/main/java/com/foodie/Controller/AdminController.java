package com.foodie.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.foodie.dao.CategoryDAO;
import com.foodie.dao.ItemDAO;
import com.foodie.dao.SupplierDAO;
import com.foodie.model.Category;
import com.foodie.model.Item;
import com.foodie.model.Supplier;

@Controller
public class AdminController {
	Logger log=LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private Item item;
	@Autowired
	private Supplier supplier;
	@Autowired
	private Category category;
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private ItemDAO itemDAO;

	
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
	@RequestMapping("/AddSupplier")
	public ModelAndView suppliers(){
		log.debug("manage supplier method starts");
		ModelAndView mv=new ModelAndView("/AddSupplier");
		mv.addObject("supplier",supplier);
		mv.addObject("isAdminClickedSuppliers","true");
		mv.addObject("supplierList",supplierDAO.list());
		log.debug("manage supplier method ends");
		return mv;
	}
}
