package com.ipgg.ipggos.model.common;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ipgg.ipggos.model.sistema.SistemaUsuario;

@Entity
public class FeedbackOS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	private String posicionamento;
	private Date dta;
	private SistemaUsuario u;

	

	public SistemaUsuario getU() {
		return u;
	}

	public void setU(SistemaUsuario u) {
		this.u = u;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDta() {
		return dta;
	}

	public void setDta(Date dta) {
		this.dta = dta;
	}

	public String getPosicionamento() {
		return posicionamento;
	}

	public void setPosicionamento(String posicionamento) {
		this.posicionamento = posicionamento;
	}
}
