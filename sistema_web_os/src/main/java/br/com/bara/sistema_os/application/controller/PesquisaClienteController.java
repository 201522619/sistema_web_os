package br.com.bara.sistema_os.application.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import br.com.bara.sistema_os.application.domain.Contato;
import br.com.bara.sistema_os.application.domain.Pessoa;

public class PesquisaClienteController implements Serializable {

	private static final long serialVersionUID = -7669892764774083935L;

	private List<Pessoa> pessoas;

	private Contato contato;

	@PostConstruct
	public void init() {
		pessoas = new ArrayList<Pessoa>();
		contato = new Contato();
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	

}
