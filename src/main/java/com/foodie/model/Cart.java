package com.foodie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Cart")
@Component
public class Cart {
	
	private String CartId;



	//private Item item;


/*private Item itemId;
	
	public Item getItemId() {
	return itemId;
}
public void setItemId(Item itemId) {
	this.itemId = itemId;
}*/
	private int quantity;
	
	private int total_price;
	@Id
	@Column(name="CartId")
	public String getCartId() {
		return CartId;
	}
	public void setCartId(String cartId) {
		CartId = cartId;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	//public Item getItem() {
		//return item;
	//}
	//public void setItem(Item item) {
		//this.item = item;
	//}

}
