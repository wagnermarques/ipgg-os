package com.ipgg.ipggos.model.sistema;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.Session;

import com.ipgg.ipggos.persistence.HibernateUtil;
import com.ipgg.ipggos.persistence.SistemaUsuarioHibernateDAO;

@Entity
public class SistemaUsuario{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<SistemaUsuarioRole> roles = new ArrayList<>();	
	
	@NotNull
	private String login;
	@NotNull
	private String senha;
	
	public SistemaUsuario() {		
	}

	public SistemaUsuario(String login, String senha) {		
		this.login = login;
		this.senha = senha;
	}

	public boolean userInRole(String role) {
		System.out.println(" --- public boolean userInRole(String role) {....");
		System.out.println(this.roles.toArray().toString());
		for(SistemaUsuarioRole r : this.roles) {
			String roleName = r.getRoleName();
			if(roleName.equals(role)) return true;
		}
		return false;
	}
		
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<SistemaUsuarioRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SistemaUsuarioRole> roles) {
		this.roles = roles;
	}

//	public static void insertAdminUser() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		SistemaUsuarioHibernateDAO uDao = new SistemaUsuarioHibernateDAO(session, SistemaUsuario.class, Long.class);
//		SistemaUsuario adminUser = new SistemaUsuario();
//		adminUser.setLogin("admin");
//		adminUser.setSenha("admin123");
//		SistemaUsuarioRole role = new SistemaUsuarioRole();
//		role.setRoleName("admin");
//		adminUser.getRoles().add(role);
//		uDao.inserir(adminUser);
//	}
	
}