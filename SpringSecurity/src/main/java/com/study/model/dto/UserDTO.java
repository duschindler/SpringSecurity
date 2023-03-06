package com.study.model.dto;

import java.util.List;
import java.util.UUID;

import com.study.model.Role;
import com.study.model.User;

public class UserDTO {

	private UUID id;
	private String username;
	private String name;
	private List<Role> listRole;
	
	public UserDTO() {}

	public UserDTO(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.name = user.getName();
		this.listRole = user.getListRole();
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Role> getListRole() {
		return listRole;
	}
	
	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}
	
}
