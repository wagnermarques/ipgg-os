package com.ipgg.ipgg_os.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AvaliacaoOS {
	
	@Id
	private Long id;

	private String manutencao;
	private String tecnico;
	private String statusServico;
	private String descricaoServico;
	private String tipoDefeito;
	private String descricaoDefeito;
	private String recebimentoServico;
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManutencao() {
		return manutencao;
	}

	public void setManutencao(String manutencao) {
		this.manutencao = manutencao;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getStatusServico() {
		return statusServico;
	}

	public void setStatusServico(String statusServico) {
		this.statusServico = statusServico;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public String getTipoDefeito() {
		return tipoDefeito;
	}

	public void setTipoDefeito(String tipoDefeito) {
		this.tipoDefeito = tipoDefeito;
	}

	public String getDescricaoDefeito() {
		return descricaoDefeito;
	}

	public void setDescricaoDefeito(String descricaoDefeito) {
		this.descricaoDefeito = descricaoDefeito;
	}

	public String getRecebimentoServico() {
		return recebimentoServico;
	}

	public void setRecebimentoServico(String recebimentoServico) {
		this.recebimentoServico = recebimentoServico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
