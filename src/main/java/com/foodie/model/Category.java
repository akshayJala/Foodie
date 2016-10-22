package com.foodie.model;



import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Category")
@Component
public class Category {
	
	private String CategoryId;
	private String CategoryName;
	private String description;
	
	
	private Set<Item> items;
	@Transient
	@OneToMany(mappedBy="item:,fetch=FetchType.EAGER")
	//ondelete cascade
public Set<Item> getItems() {
	return items;
}
	public void setItems(Set<Item> items){
		this.items=items;
	}
	
	@Id
	@Column(name="CategoryId")
	
	public String getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(String categoryId) {
		CategoryId = categoryId;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}

}
