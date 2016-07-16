package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tipo_contato")
public class TipoContato extends GenericEntity implements Serializable{
	private static final long serialVersionUID = -8521191621845795677L;
	
	@Column(name = "tc_descricao")
	private String descricao;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tipoContato", targetEntity = Contato.class)
	private List<Contato> contatos;
	
	/*public ETipoContato getDescricao() {
		return descricao;
	}

	public void setDescricao(ETipoContato descricao) {
		this.descricao = descricao;
	}*/

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
