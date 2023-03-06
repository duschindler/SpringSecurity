package com.study.model;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user_role")
@IdClass(UserRoleId.class)
public class UserRole{

	@Id
	@Column( name="id_user", nullable = false )
	private UUID idUser;
	
	@Id
	@Column( name="id_role", nullable = false )
	private UUID idRole;
	
	public UserRole() {}

	public UserRole(UUID idUser) {
		this.idUser = idUser;
	}
	
	public UserRole(UUID idUser, UUID idRole) {
		this.idUser = idUser;
		this.idRole = idRole;
	}

	public UUID getIdUser() {
		return idUser;
	}

	public void setIdUser(UUID idUser) {
		this.idUser = idUser;
	}

	public UUID getIdRole() {
		return idRole;
	}

	public void setIdRole(UUID idRole) {
		this.idRole = idRole;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		return Objects.equals(idUser, other.idUser);
	}


}
