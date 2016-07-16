package br.com.bara.sistema_os.application.domain;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_pagamento")
public class Pagamento extends GenericEntity implements Serializable{

	private static final long serialVersionUID = -5891665093238486680L;
	
	private Date dataVencimento;

	private Date dataPagamento;

	private Double valor;

	private Double acrescimos;

	private Double descontos;

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getAcrescimos() {
		return acrescimos;
	}

	public void setAcrescimos(Double acrescimos) {
		this.acrescimos = acrescimos;
	}

	public Double getDescontos() {
		return descontos;
	}

	public void setDescontos(Double descontos) {
		this.descontos = descontos;
	}
	
	

}
