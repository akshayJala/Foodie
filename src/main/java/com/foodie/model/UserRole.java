package com.foodie.model;

import javax.persistence.Id;
import javax.persistence.OneToOne;

public class UserRole {
	@Id
	@OneToOne
	private User roleId;
	
	private String roleName;
	
	public User getRoleId() {
		return roleId;
	}
	public void setRoleId(User roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
