package br.com.bara.sistema_os.application.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.bara.sistema_os.application.domain.Contato;
import br.com.bara.sistema_os.application.domain.Pessoa;

@Named
@ViewScoped
public class PesquisaClienteController implements Serializable {

	private static final long serialVersionUID = -7669892764774083935L;

	private ArrayList<Pessoa> pessoas;

	private Contato contato;

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	

}
