package com.foodie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.foodie.dao.CategoryDAO;
import com.foodie.dao.ItemDAO;
import com.foodie.dao.SupplierDAO;
import com.foodie.model.Category;
import com.foodie.model.Item;
import com.foodie.model.Supplier;
import com.foodie.util.FileUtil;

@Controller
public class ItemController {
	
	@Autowired(required=true)
	private ItemDAO itemDAO;
	@Autowired(required=true)
	private CategoryDAO categoryDAO;
	@Autowired(required=true)
	private SupplierDAO supplierDAO;
	
	private String path="E:\\DevOps\\foodie\\src\\main\\webapp\\resources\\images";
	

	
	
@RequestMapping(value="/items",method=RequestMethod.GET)
public String listItems(Model model){
	model.addAttribute("item",new Item());
	model.addAttribute("category",new Category());
	model.addAttribute("supplier",new Supplier());
	model.addAttribute("itemList",this.itemDAO.list());
	model.addAttribute("categoryList",this.categoryDAO.list());
	model.addAttribute("supplierList",this.supplierDAO.list());
	return "item";
}
//For Adding and Updating Items
	@RequestMapping(value="/AddItems",method=RequestMethod.POST)
	public String addItem(@ModelAttribute("item")Item item,@RequestParam("file")MultipartFile file){
		Category category=categoryDAO.getByName(item.getCategory().getCategoryName());
		Supplier supplier=supplierDAO.getByName(item.getSupplier().getSupplierName());
		
		item.setCategory(category);
		item.setSupplier(supplier);
		item.setCategory_id(category.getCategoryId());
		item.setSupplier_id(supplier.getSupplierId());
		itemDAO.saveOrUpdate(item);
		FileUtil.upload(path,file,item.getItemId()+".jpg");
		return "item";
	}
	@RequestMapping("item/remove/{id}")
	public String removeItem(@PathVariable("id") String id,ModelMap model) throws Exception{
		try{
			itemDAO.delete(id);
			model.addAttribute("message","Item was Added");
		}catch(Exception e){
			model.addAttribute("message",e.getMessage());
			e.printStackTrace();
		}
		return "item";
	}
	
	@RequestMapping("item/edit/{id}")
	public String editItem(@PathVariable("id")String id,Model model){
		System.out.println("editItem");
		model.addAttribute("item",this.itemDAO.get(id));
		model.addAttribute("itemList",this.itemDAO.list());
		model.addAttribute("categoryList",this.categoryDAO.list());
		model.addAttribute("supplierList",this.supplierDAO.list());
		
		return "item";
	}
	//To Get Selected Item 
	@RequestMapping("item/get/{id}")
	public Model getItem(@PathVariable("id")String id,Model model)
	{
		Item selectedItem=itemDAO.get(id);
		model.addAttribute("selectedItem",selectedItem);
		return model;
	}
}