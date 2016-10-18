package com.foodie.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodie.dao.CategoryDAO;
import com.foodie.model.Category;

@Controller
public class CategoryController {
	private static Logger log=LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	private Category category;
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value="/Category",method=RequestMethod.GET)
	public String listCategories(Model model){
		log.debug("category list method starts");
		model.addAttribute("category",category);
		model.addAttribute("categoryList",this.categoryDAO.list());
		log.debug("category list method ends");
		return "category";
	}
  @RequestMapping(value="/AddCategory",method=RequestMethod.POST)
  public String addCategory(@ModelAttribute("category")Category category){
	  ModelAndView mv=new ModelAndView("/AdminHome");
	log.debug("add category method starts");
	  categoryDAO.saveOrUpdate(category);
	log.debug("add category method ends");
	   return "category";
	   
   }
   @RequestMapping("category/remove/{id}")
   public ModelAndView deleteCategory(@PathVariable("id")String id)throws Exception{
	   boolean flag=categoryDAO.delete(id);
	   ModelAndView mv=new ModelAndView("category");
	   String msg="Operation Successful";
	   if(flag!=true)
	   {
		   msg="Operation Failed";
	   }
	   mv.addObject("msg",msg);
	   return mv;
   }
   @RequestMapping("category/edit/{id}")
   public String editCategory(@ModelAttribute("category")Category category){
	   log.debug("Edit Category method starts");
	   categoryDAO.saveOrUpdate(category);
	   log.debug("Edit Category  ends");
	   return "category";
	   
   }
}

