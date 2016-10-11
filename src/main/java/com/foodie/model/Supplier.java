package com.foodie.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Supplier")
@Component
public class Supplier {
	
	
	private String id;
	public String name;
	public String address;
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
	@Column(name="id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
