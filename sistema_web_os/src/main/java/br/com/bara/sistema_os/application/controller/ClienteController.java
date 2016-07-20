package br.com.bara.sistema_os.application.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.bara.sistema_os.application.business.ClienteBusiness;
import br.com.bara.sistema_os.application.business.ContatoBusiness;
import br.com.bara.sistema_os.application.business.TipoContatoBusiness;
import br.com.bara.sistema_os.application.business.WebServiceCEPBusiness;
import br.com.bara.sistema_os.application.domain.Contato;
import br.com.bara.sistema_os.application.domain.Pessoa;
import br.com.bara.sistema_os.application.domain.TipoContato;
import br.com.bara.sistema_os.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 5322504104014116091L;

	private Pessoa pessoa;
	private Contato contato;
	private TipoContato tipoContato;
	private ClienteBusiness clienteBusiness;
	private ContatoBusiness contatoBusiness;
	private TipoContatoBusiness tipoContatoBusiness;
	private List<TipoContato> tipoContatoList;
	private List<Contato> contatos;
	
	@PostConstruct
	public void init(){
		this.pessoa = new Pessoa();
		this.clienteBusiness = new ClienteBusiness();
		this.contato = new Contato();
		this.tipoContato = new TipoContato();
		this.contatoBusiness = new ContatoBusiness();
		this.tipoContatoBusiness = new TipoContatoBusiness();
	}
	
	public List<TipoContato> getTipoContatoList() {
		if(this.tipoContatoList == null){
			this.tipoContatoList = tipoContatoBusiness.listarTodos();
		}
		return tipoContatoList;
	}

	public void setTipoContatoList(List<TipoContato> tipoContatoList) {
		this.tipoContatoList = tipoContatoList;
	}

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

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}
	
	public void adicionarNovoContato() {
		try {
			if (pessoa.getContatos() == null) {
				this.pessoa.setContatos(new ArrayList<Contato>());
			}
			
			contato.setPessoa(pessoa);
			pessoa.getContatos().add(contato);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			contato = new Contato();
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
