package com.ipgg.ipgg_os.model.common;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrdemChamado {

	@Id
	private Long nos;

	private String solicitante;
	private String gerencia;
	private String diretoria;
	private String local;
	private String servico;
	private String tipoServico;
	private String bemPatrimonial;
	private String nPatrimonio;
	private String descricaoServico;
	private String grauNecessidade;
	private Boolean rechamado;
	private Long osAnterior;
	private String status;
	
	public OrdemChamado(String solicitante) {
		this.solicitante = solicitante;
	}

	public Long getNos() {
		return nos;
	}

	public void setNos(Long nos) {
		this.nos = nos;
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

	public String getnPatrimonio() {
		return nPatrimonio;
	}

	public void setnPatrimonio(String nPatrimonio) {
		this.nPatrimonio = nPatrimonio;
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
}