package com.ipgg.ipggos.model.sistema;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SistemaUsuarioRole {

	@Id
	private String roleName;

	public SistemaUsuarioRole(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
		
}
