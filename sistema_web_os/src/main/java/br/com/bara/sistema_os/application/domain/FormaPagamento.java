package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_forma_pagamento")
public class FormaPagamento extends GenericEntity implements Serializable{

	private static final long serialVersionUID = -1321413658579797283L;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
