package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.bara.sistema_os.application.type.ETipoContato;


@Entity
@Table(name = "tbl_tipo_contato")
public class TipoContato implements Serializable{
	private static final long serialVersionUID = -8521191621845795677L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tc_descricao")
	private ETipoContato descricao;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tipoContato", targetEntity = Contato.class)
	private List<Contato> contatos;
	
	public ETipoContato getDescricao() {
		return descricao;
	}

	public void setDescricao(ETipoContato descricao) {
		this.descricao = descricao;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
