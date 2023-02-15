package com.study.entity;

import com.study.encoder.Encoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long 	id;
	
	@Column( name="user", length = 50, nullable = false, unique = true, updatable = false )
	private String 	user;
	
	@Column( name="password", nullable = false )
	private String 	password;
	
	@Column( name="name", nullable = false )
	private String 	name;
	
	public User() {}
	
	public User(Long id) {
		this.id = id;
	}

	public User(Long id, String user, String password, String name) {
		this.id = id;
		this.user = user;
		this.password = Encoder.encode(password);
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Encoder.encode(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
