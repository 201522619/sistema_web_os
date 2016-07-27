package br.com.bara.sistema_os.application.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.bara.sistema_os.application.business.ClienteBusiness;
import br.com.bara.sistema_os.application.business.ContatoBusiness;
import br.com.bara.sistema_os.application.business.WebServiceCEPBusiness;
import br.com.bara.sistema_os.application.domain.Contato;
import br.com.bara.sistema_os.application.domain.Pessoa;
import br.com.bara.sistema_os.util.FacesUtil;

@Named
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 5322504104014116091L;
	
	public ClienteController(){
		System.out.println("Construtor ClienteController.class");
	}

	@Inject
	private Pessoa pessoa;
	
	@Inject
	private Contato contato;
	
	@Inject
	private ClienteBusiness clienteBusiness;
	
	@Inject
	private ContatoBusiness contatoBusiness;
	
	private List<Contato> contatos;
	
	public List<Contato> getlistarTodosContatos() {
		if(this.contatos == null){
			this.contatos = this.contatoBusiness.listarTodos();
		}
		return this.contatos;
	}
	
	public void setListaContatos(Contato contato){
		this.contato = contato;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public void adicionarNovoContato() {
		try {
			if (pessoa.getContatos() == null) {
				this.pessoa.setContatos(new ArrayList<Contato>());
			}
			
			contato.setPessoa(pessoa);
			pessoa.getContatos().add(contato);
			contato = new Contato();
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			
		}
	}

	public void removerContato(Contato contato) {
		pessoa.getContatos().remove(contato);
	}

	public void salvar(){
		try {
			try {
				consistirParaSalvar();
			} catch (RuntimeException e) {
				FacesUtil.mensagemErro(e.getMessage());
				return;
			}
			Messages.addGlobalInfo("Cliente "+pessoa.getNome()+" cadastrado com sucesso!");
		} catch (RuntimeException e) {
			e.printStackTrace();
			Messages.addGlobalError(e.getMessage());
		}
	}

	private void consistirParaSalvar() {
		try {
			clienteBusiness.consistirParaSalvar(pessoa);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void procurarCep(){
		Map<Object, Object> mapCep = new HashMap<Object, Object>();
		WebServiceCEPBusiness web = new WebServiceCEPBusiness();
		mapCep.putAll(web.procurarCEP(this.pessoa.getCep()));
		this.pessoa.setEndereco(mapCep.get(1).toString());
		this.pessoa.setEstado  (mapCep.get(3).toString());
		this.pessoa.setCidade  (mapCep.get(2).toString());
		this.pessoa.setBairro  (mapCep.get(4).toString());
	}

}
