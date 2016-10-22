package com.foodie.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	
	//private String path="E:\\DevOps\\foodie\\src\\main\\webapp\\resources\\images";
	

	
	
	@RequestMapping(value="/Items",method=RequestMethod.GET)
	public ModelAndView getItems() {
		List<Item> items = itemDAO.list();
		System.out.println("List of items");
		return new ModelAndView("/Items", "itemList", items);
	}

/*public String listItems(Model model){
	List<Item> item = itemDAO.list();
	model.addAttribute("item",new Item());
	model.addAttribute("category",new Category());
	model.addAttribute("supplier",new Supplier());
	model.addAttribute("itemList",this.itemDAO.list());
	model.addAttribute("categoryList",this.categoryDAO.list());
	model.addAttribute("supplierList",this.supplierDAO.list());
	return "/AddItems";
}*/

@RequestMapping(value = "/AddItems", method = RequestMethod.POST)
public String storeItem(ModelMap model,@RequestParam("file") MultipartFile file,@ModelAttribute("foodie") Item i,BindingResult result){
	// Binding Result is used if the form that has any error then it will
	// redirect to the same page without performing any functions
	if (result.hasErrors())
		return "AddItems";
	System.out.println("hi "+i.getItemId());
	itemDAO.saveOrUpdate(i);
	MultipartFile image = i.getImage();
	String fileName=null;
	try {
        fileName = file.getOriginalFilename();
        byte[] bytes = file.getBytes();
        BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File("E:/DevOps/foodie/src/main/webapp/resources/images/item" + fileName)));
        buffStream.write(bytes);
        buffStream.close();
       // error= "You have successfully uploaded " + fileName;
        System.out.println("---------->");
    
	File oldName = new File("E:/DevOps/foodie/src/main/webapp/resources/images/item" + fileName);
    File newName = new File("E:/DevOps/foodie/src/main/webapp/resources/images/item" + i.getItemId()+fileName.substring(fileName.indexOf(".")));
    System.out.println("new file name:--------------->"+newName);
    if(oldName.renameTo(newName)) {
       System.out.println(i.getItemId());
      // error=p.getName()+" added Successfully !";
       System.out.println("lafnj");
    } 
	} catch (Exception e) {
    	//error="You failed to upload " + fileName + ": " + e.getMessage();
    	System.out.println("failed");
    }
    return "redirect:./AddItems";
}
	/*if (image != null && !image.isEmpty()) {
		System.out.println("image");
		Path path = Paths.get("E:/DevOps/foodie/src/main/webapp/resources/images"
						+ i.getItemId() + ".jpg");

		try {
			image.transferTo(new File(path.toString()));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	return "redirect:/AddItems";
}
//For Adding and Updating Items
	/*@RequestMapping(value="/AddItems",method=RequestMethod.POST)
	public String addItem(@ModelAttribute("item")Item item,@RequestParam(value="file",required=true)MultipartFile file){
		Category category=categoryDAO.getByName(item.getCategory().getCategoryName());
		Supplier supplier=supplierDAO.getByName(item.getSupplier().getSupplierName());
		
		item.setCategory(category);
		item.setSupplier(supplier);
		item.setCategory_id(category.getCategoryId());
		item.setSupplier_id(supplier.getSupplierId());
		itemDAO.saveOrUpdate(item);
		//FileUtil.upload(path,file,item.getItemId()+".jpg");
		Path path=Paths.get("E:/DevOps/foodie/src/main/webapp/resources/images");
		return "/AddItems";
	}*/
	@RequestMapping("item/remove/{itemId}")
	public String removeItem(@PathVariable("itemId") String id,ModelMap model) throws Exception{
		try{
			itemDAO.delete(id);
			model.addAttribute("message","Item was deleted");
		}catch(Exception e){
			model.addAttribute("message",e.getMessage());
			e.printStackTrace();
		}
		return "/Items";
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
	@RequestMapping(value="Details",method=RequestMethod.GET)
	public ModelAndView Details(HttpServletRequest request,String ItemId){
		//Item item=itemDAO.get(ItemId);
		return new ModelAndView("Details","items",itemDAO.get(ItemId));
	}
}