package com.ipgg.ipggos.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrdemServico {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;

	private String solicitante;
	private String gerencia;
	private String diretoria;
	private String local;
	private String servico;
	private String tipoServico;
	private String bemPatrimonial;
	private String numPatrimonio;
	private String descricaoServico;
	private String grauNecessidade;
	private Boolean rechamado;
	private Long osAnterior;
	private String status;
	private LocalDateTime momAbertura;
	
	

	public LocalDateTime getMomAbertura() {
		return momAbertura;
	}

	public void setMomAbertura(LocalDateTime momAbertura) {
		this.momAbertura = momAbertura;
	}

	public void setNumPatrimonio(String numPatrimonio) {
		this.numPatrimonio = numPatrimonio;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getGerencia() {
		return gerencia;
	}

	public void setGerencia(String gerencia) {
		this.gerencia = gerencia;
	}

	public String getDiretoria() {
		return diretoria;
	}

	public void setDiretoria(String diretoria) {
		this.diretoria = diretoria;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getBemPatrimonial() {
		return bemPatrimonial;
	}

	public void setBemPatrimonial(String bemPatrimonial) {
		this.bemPatrimonial = bemPatrimonial;
	}

	public String getNumPatrimonio() {
		return numPatrimonio;
	}

	public void setnPatrimonio(String nPatrimonio) {
		this.numPatrimonio = nPatrimonio;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}
	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public String getGrauNecessidade() {
		return grauNecessidade;
	}

	public void setGrauNecessidade(String grauNecessidade) {
		this.grauNecessidade = grauNecessidade;
	}

	public Boolean getRechamado() {
		return rechamado;
	}

	public void setRechamado(Boolean rechamado) {
		this.rechamado = rechamado;
	}

	public Long getOsAnterior() {
		return osAnterior;
	}

	public void setOsAnterior(Long osAnterior) {
		this.osAnterior = osAnterior;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status= status;
	}

	@Override
	public String toString() {
		return this.getId()+":"+this.descricaoServico;
	}
	
	
}