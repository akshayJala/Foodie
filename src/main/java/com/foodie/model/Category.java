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
	private String id;
	private String name;
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
	@Column(name="ID")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
