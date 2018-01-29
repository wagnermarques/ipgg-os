package com.ipgg.ipgg_os.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AvaliacaoOS {
	
	private String manutencao;
	private String tecnico;
	private String statusServico;
	private String descricaoServico;
	private String tipoDefeito;
	private String descricaoDefeito;
	private String recebimentoServico;
	private Date data;
	
	

}
