package br.com.bara.sistema_os.application.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.bara.sistema_os.application.business.ClienteBusiness;
import br.com.bara.sistema_os.application.business.ContatoBusiness;
import br.com.bara.sistema_os.application.business.WebServiceCEPBusiness;
import br.com.bara.sistema_os.application.domain.Contato;
import br.com.bara.sistema_os.application.domain.Pessoa;
import br.com.bara.sistema_os.application.domain.TipoContato;
import br.com.bara.sistema_os.application.type.ETipoContato;
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
	
	@PostConstruct
	public void init(){
		this.pessoa = new Pessoa();
		this.clienteBusiness = new ClienteBusiness();
		this.contato = new Contato();
		this.tipoContato = new TipoContato();
		this.contatoBusiness = new ContatoBusiness();
	}
	
	public List<Contato> getlistarTodosContatos() {
		return this.contatoBusiness.listarTodos();
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

	public void salvar(){
		try {
			try {
				consistirParaSalvar();
			} catch (RuntimeException e) {
				FacesUtil.mensagemErro(e.getMessage());
				return;
			}
			FacesUtil.mensagemInfo("Cliente "+pessoa.getNome()+" cadastrado com sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

	private void consistirParaEditar() {
		try {
			clienteBusiness.consistirParaEditar(pessoa);
		} catch (RuntimeException e) {
			FacesUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void editar(){
		try {
			consistirParaEditar();
			FacesUtil.mensagemInfo("Cliente "+pessoa.getNome()+" atualizado com sucesso!");
		} catch (Exception e) {
			FacesUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void consistirParaSalvar() {
		try {
			novoContato();
			clienteBusiness.consistirParaSalvar(pessoa);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public void novoContato(){
		try {
			/*
			 * Mudar os dados estáticos para dinâmicos de acordo com o formulário
			 */
			this.tipoContato.setDescricao(ETipoContato.TELEFONE);
			this.contato.setPessoa(pessoa);
			this.contato.setDescricao("62 3555-4455");
			this.contato.setTipoContato(tipoContato);
			this.pessoa.getContatos().add(this.contato);
			this.tipoContato.setContatos(this.pessoa.getContatos());
		} catch (RuntimeException e) {
			FacesUtil.mensagemErro(e.getMessage());
			e.printStackTrace();
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
