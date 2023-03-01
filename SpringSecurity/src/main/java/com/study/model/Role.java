package com.study.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;

import com.study.role.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "tb_role" )
public class Role implements GrantedAuthority, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private UUID id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private UserRole name;
	
	@ManyToMany
	private List<User> listUser;

	public Role() {}
	
	public Role(UserRole name) {
		this.name = name;
	}

	public Role(UUID id, UserRole name) {
		this.id = id;
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UserRole getName() {
		return name;
	}

	public void setName(UserRole name) {
		this.name = name;
	}
	
	public List<User> getListUser() {
		return listUser;
	}
	
	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	@Override
	public String getAuthority() {
		return this.name.toString();
	}
	
	
}
