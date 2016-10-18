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

import com.foodie.dao.SupplierDAO;
import com.foodie.model.Supplier;

@Controller
public class SupplierController {
	private static Logger log=LoggerFactory.getLogger(SupplierController.class);
	@Autowired
	private Supplier supplier;
	@Autowired
	private SupplierDAO supplierDAO;
	
	@RequestMapping(value="/Suppliers",method=RequestMethod.GET)
	public String listSuppliers(Model model){
		log.debug("supplier list method starts");
		model.addAttribute("supplier",supplier);
		model.addAttribute("supplierList",this.supplierDAO.list());
		log.debug("supplier list method ends");
		return "supplier";
	}
  @RequestMapping(value="/AddSupplier",method=RequestMethod.POST)
  public String addSupplier(@ModelAttribute("supplier")Supplier supplier){
	log.debug("add supplier method starts");
	
	  supplierDAO.saveOrUpdate(supplier);
	log.debug("add supplier method ends");
	   return "supplier";
	   
   }
   @RequestMapping("supplier/remove/{id}")
   public ModelAndView deleteSupplier(@PathVariable("id")String id)throws Exception{
	   boolean flag=supplierDAO.delete(id);
	   ModelAndView mv=new ModelAndView("supplier");
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
	   return "supplier";
	   
   }
}

