package com.study.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class UserRoleId implements Serializable {

	private static final long serialVersionUID = 2534931093928640009L;

	private UUID idUser;
	private UUID idRole;

	public UserRoleId() {}

	public UserRoleId(UUID idUser, UUID idRole) {
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
		return Objects.hash(idRole, idUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoleId other = (UserRoleId) obj;
		return Objects.equals(idRole, other.idRole) && Objects.equals(idUser, other.idUser);
	}

	
	
}
