package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.bara.sistema_os.application.type.ETipoContato;

@Entity
@Table(name = "tbl_contato")
public class Contato extends GenericEntity implements Serializable{

	private static final long serialVersionUID = 4081899643595068845L;
	
	@Column(name = "cont_descricao")
	private String descricao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoa_id", nullable = true)
	private Pessoa pessoa;
	
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_contato_id", nullable = true)
	private TipoContato tipoContato;*/
	
	private ETipoContato tipoContato;
	
	public ETipoContato[] getTiposContato() {
		return ETipoContato.values();
    }
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public ETipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(ETipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}
	
	

	/*public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}*/

	
}
