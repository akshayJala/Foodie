package com.foodie.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
//@RequestMapping("/Cart")
public class CartController {
	@Autowired
	private User user;
	@Autowired
	private CategoryDAO categoryDAO;
@Autowired
private CartDAO cartDAO;
@Autowired
private Cart cart;
@Autowired
private ItemDAO itemDAO;
@Autowired
UserDAO userDAO;
@Autowired
Item item;

@RequestMapping(value = "/CartList", method = RequestMethod.GET)
public String myCart(Model model) {
	model.addAttribute("category", new Category());
	model.addAttribute("categoryList", categoryDAO.list());

	model.addAttribute("cart", new Cart());
	model.addAttribute("cartList", this.cartDAO.list());
//	model.addAttribute("totalAmount", cartDAO.getTotalAmount("user")); // Just to test, password user
	model.addAttribute("displayCart", "true");
	return "CartList";
}
             //added "/Cart" to top of controller
@RequestMapping(value= "/Items/addToCart/{id}/{userId}", method = RequestMethod.GET)
public String addToCart(@PathVariable("id") String id,HttpSession session){
System.out.println("connect....");


Item item = itemDAO.getItem(id);
Cart cart = new Cart();
System.out.println("connect cart...");
cart.setPrice(item.getPrice());
cart.setItemName(item.getName());
cart.setQuantity(1);
cart.setUserID(user.getUserId());  
cart.setStatus("N");  
cartDAO.saveOrUpdate(cart);
System.out.println("connect to controller");	
return "/Items";
}
	

@RequestMapping("/cart/delete/{id}")
public String deleteCart(@PathVariable("id") int id,Model model)
{

	cartDAO.delete(id);
	
	
	 return "redirect:/myCart";
}

@RequestMapping(value = "/checkout", method = RequestMethod.GET)
public String checkout(Model model) {
    
	int i,j=0;
	int s=0;
	int n=cartDAO.list().size();
	System.out.println(n);
	for(i=0;i<n;i++)
	{
		s=s+cartDAO.list().get(i).getPrice();
		
	}
	System.out.println(s);
	model.addAttribute("sum", s);
	model.addAttribute("cart", new Category());
	model.addAttribute("cartList", this.cartDAO.list());
	//model.addAttribute("total", this.cartDAO.getTotalAmount("id"));
	

	
	//System.out.println(U);
	return "/checkout";
}

@RequestMapping(value = "/logout2", method = RequestMethod.GET)
public String logout2(Model model) {

	
	
	

	
	//System.out.println(U);
	return "/logout";
}

@RequestMapping("/logout")
public String logout(Model model)
{
	int i,s=0,j=0;
	int n=cartDAO.list().size();
	System.out.println(n);
	for(i=0;i<n;i++)
	{
		s=s+cartDAO.list().get(i).getPrice();
		
	}
	System.out.println(s);
	model.addAttribute("sum", s);
	while(n!=0)
	{
		cartDAO.delete(cartDAO.list().get(j).getId());
		n=cartDAO.list().size();
		
	}
	return "logout";
}

@RequestMapping("/pay")
public String getthanks()
{
	return "pay";	
}

@RequestMapping("/pay1")
public String getpayment()
{
	return "pay1";	
}
@RequestMapping("/cod")
public String getcod()
{
	return "cod";	
}
@RequestMapping("/bank")
public String getBank()
{
	return "bank";	
}
}





























































































/*@RequestMapping("/Cart/addToCart/")
public ModelAndView addcart(HttpServletRequest request){
	System.out.println("Store Cart");
	//String itemId = request.getParameter("i");
	Cart c=new Cart();
	//Item item=item.get(ItemId);
	c.setQuantity(1);
	System.out.print("adding to cart ");
	//c.setUser(userDAO.getUser(UserId));
	cartDAO.addCart(c);
	return new ModelAndView("/Items");
}
}

/*@RequestMapping(value="/Cart",method=RequestMethod.GET)
public String myCart(Model model,HttpSession session){
	model.addAttribute("Cart",new Cart());
	//get the logged in user id
	String UserId=(String) session.getAttribute("UserId");
int cartSize=cartDAO.list(UserId).size();
if(cartSize==0){
	model.addAttribute("errorMessage","no items in your cart");
}else{
	model.addAttribute("cartList",cartDAO.list(UserId));
	//model.addAttribute("totalAmount",cartDAO.TotalAmount(UserId));
	model.addAttribute("displayCart",true);
}
return "/Home";
}

//to add and update cart
/*@RequestMapping(value="/Cart/addToCart/{CartId}",method=RequestMethod.GET)
public String addToCart(@PathVariable("CartId")int cartId,HttpSession session){
//	Item item=itemDAO.get(id);
	Cart cart=new Cart();
//cart.setTotal_price(item.getPrice());
	//cart.setItem(item.getItemName());
	//cart.setQuantity(1);
//	String loggedInUserid=(String) session.getAttribute("loggedInUserID");
	cart.setCartId(cartId);
	System.out.println("Cart");
	cartDAO.saveorUpdate(cart);
	return "/Items";
	
}*/

/*@RequestMapping("Cart/addToCart/{item}")
public String addToCart(@PathVariable("item") String ItemName, HttpSession session) throws Exception {
	User user=(User)userDAO.getUser();
	System.out.println("1");
	String UserId=user.getUserId();
	System.out.println("12");
	if (cartDAO.getitem(ItemName, UserId) != null) {
		System.out.println("2");
		Cart item = cartDAO.getitem(ItemName, UserId);
		//item.setQuantity(1);
		item.setQuantity(item.getQuantity() + 1);
		System.out.println("3");
		Item i = itemDAO.get(item.getItemName());
		System.out.println("4");
		item.setPrice(item.getPrice() + (1 * i.getPrice()));
		cartDAO.saveorUpdate(item);
		System.out.println("5");
		session.setAttribute("getcount", cartDAO.getCount((String) session.getAttribute("UserId")));
		return "/Items";
	} else {
		Cart item = new Cart();
		System.out.println("6");
		Item i = itemDAO.get(item.getItemName());
		System.out.println("6");
		item.setItemName(item.getItemName());
		item.setUserId(UserId);
		item.setQuantity(1);
		item.setPrice(1 * i.getPrice());
		item.setStatus("C");
		item.setItemName(ItemName);
		System.out.println("7");
		cartDAO.saveorUpdate(item);
		session.setAttribute("getcount", cartDAO.getCount((String) session.getAttribute("UserId")));
		session.setAttribute("getcount",cartDAO.getCount(UserId));
	
		return "/Items";
	}

}


@RequestMapping("Cart/delete/{id}")
public String removeCart(@PathVariable("CartId") int CartId,ModelMap model) throws Exception{
	try{
		cartDAO.delete(CartId);
		model.addAttribute("message","removed successfully!");
	}catch(Exception e){
		model.addAttribute("message",e.getMessage());
		e.printStackTrace();
		
	}
	return "Home";
}
@RequestMapping(value="/CartList",method=RequestMethod.GET)
public ModelAndView getItems() {
	List<Cart> cart = cartDAO.list();
	System.out.println("List of cart");
	return new ModelAndView("/CartList", "cartList", cart);
}
@RequestMapping("CartList/edit/{id}")
public String editCart(@PathVariable("CartId")int CartId,Model model,HttpSession session){
	System.out.println("editCart");
	model.addAttribute("CartId",this.cartDAO.get(CartId));
	String UserId=(String) session.getAttribute("UserId");
	model.addAttribute("CartList",this.cartDAO.list(UserId));
	return "cart";
	
}*/
