package com.study.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.study.encoder.Encoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements UserDetails, Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private UUID 	id;
	
	@Column( name="username", length = 50, nullable = false, unique = true, updatable = false )
	private String 	username;
	
	@Column( name="password", nullable = false )
	private String 	password;
	
	@Column( name="name", nullable = false )
	private String 	name;
	
	@Column( name="active", nullable = false )
	private Integer active;
	
	@ManyToMany( targetEntity = Role.class, fetch = FetchType.EAGER )
	@JoinTable(
			name = "tb_user_role",
			joinColumns 		= @JoinColumn(name="id_user", referencedColumnName="id"),
			inverseJoinColumns 	= @JoinColumn(name="id_role", referencedColumnName="id")
	)
	private List<Role> listRole;
	
	
	public User() {}
	
	public User(UUID id) {
		this.id = id;
	}
	
	public User(String username) {
		this.username = username;
	}

	public User(String username, String password, String name, Integer active, List<Role> listRole) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.active = active;
		this.listRole = listRole;
	}

	public User(UUID id, String username, String password, String name, Integer active, List<Role> listRole) {
		this.id = id;
		this.username = username;
		this.password = Encoder.getInstance().encode(password);
		this.name = name;
		this.active = active;
		this.listRole = listRole;
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

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Encoder.getInstance().encode(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public List<Role> getListRole() {
		return listRole;
	}
	
	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.getListRole();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
