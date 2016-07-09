package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.bara.sistema_os.application.type.ETipoContato;


@Entity
@Table(name = "tbl_contato")
public class Contato implements Serializable{

	private static final long serialVersionUID = 4081899643595068845L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "cont_descricao")
	private String descricao;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_contato_id", nullable = false)
	private TipoContato tipoContato;
	
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

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
