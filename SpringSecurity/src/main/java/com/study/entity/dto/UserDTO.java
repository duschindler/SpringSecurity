package com.study.entity.dto;

import com.study.entity.User;

public class UserDTO {

	private String user;
	private String name;
	
	public UserDTO() {}

	public UserDTO(String user, String name) {
		this.user = user;
		this.name = name;
	}

	public UserDTO(User user) {
		this.user = user.getUser();
		this.name = user.getName();
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
