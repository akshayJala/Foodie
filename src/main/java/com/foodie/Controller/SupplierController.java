package com.foodie.Controller;

import java.util.List;

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

import com.foodie.dao.SupplierDAO;
import com.foodie.model.Item;
import com.foodie.model.Supplier;

@Controller
public class SupplierController {
	private static Logger log=LoggerFactory.getLogger(SupplierController.class);
	@Autowired
	private Supplier supplier;
	@Autowired
	private SupplierDAO supplierDAO;
	
	@RequestMapping(value="/supplierList",method=RequestMethod.GET)
	public ModelAndView getCategories() {
		List<Supplier> suppliers = supplierDAO.list();
		return new ModelAndView("SupplierList", "suppliers", suppliers);
	}
  @RequestMapping(value="/AddSupplier",method=RequestMethod.POST)
  public String addSupplier(@ModelAttribute("AddSupplier")Supplier supplier){
	log.debug("add supplier method starts");
	
	  supplierDAO.saveOrUpdate(supplier);
	log.debug("add supplier method ends");
	   return "/AddSupplier";
	   
   }
   @RequestMapping("supplier/remove/{id}")
   public ModelAndView deleteSupplier(@PathVariable("id")String id)throws Exception{
	   boolean flag=supplierDAO.delete(id);
	   ModelAndView mv=new ModelAndView("AddSupplier");
	   String msg="Operation Successful";
	   if(flag!=true)
	   {
		   msg="Operation Failed";
	   }
	   mv.addObject("msg",msg);
	   return mv;
   }
   @RequestMapping("supplier/edit/{id}")
   public String editSupplier(@ModelAttribute("supplier")Supplier supplier){
	   log.debug("Edit Supplier method starts");
	   supplierDAO.saveOrUpdate(supplier);
	   log.debug("Edit Supplier  ends");
	   return "AddSupplier";
	   
   }
}

