package br.com.bara.sistema_os.application.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.bara.sistema_os.application.business.ClienteBusiness;
import br.com.bara.sistema_os.application.business.WebServiceCEPBusiness;
import br.com.bara.sistema_os.application.domain.Pessoa;
import br.com.bara.sistema_os.application.domain.TipoContato;
import br.com.bara.sistema_os.application.type.ETipoContato;
import br.com.bara.sistema_os.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 5322504104014116091L;

	private Pessoa pessoa;
	
	private ClienteBusiness clienteBusiness;
	
	@PostConstruct
	public void init(){
		this.pessoa = new Pessoa();
		this.clienteBusiness = new ClienteBusiness();
	}
	
	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
			clienteBusiness.consistirParaSalvar(pessoa);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public void novoContato(){
		try {
			TipoContato tipoContato = new TipoContato();
			
			tipoContato.setDescricao(ETipoContato.TELEFONE);
			this.pessoa.getContato().setPessoa(pessoa);
			this.pessoa.getContato().setDescricao("62 9165-45566");
			this.pessoa.getContato().setTipoContato(tipoContato);
			
			this.pessoa.getContatos().add(this.pessoa.getContato());
			
			tipoContato.setContatos(this.pessoa.getContatos());
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
		System.out.println(mapCep.values());
	}

}
