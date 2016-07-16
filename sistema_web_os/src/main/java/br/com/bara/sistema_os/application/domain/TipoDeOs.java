package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_tipo_os")
public class TipoDeOs extends GenericEntity implements Serializable{

	private static final long serialVersionUID = 8259676006018228996L;
	
	@Column(name = "tos_descricao")
	private String descricao;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tipoDeOs", targetEntity = OrdemServico.class)
	private List<OrdemServico> ordemServicos;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<OrdemServico> getOrdemServicos() {
		return ordemServicos;
	}

	public void setOrdemServicos(List<OrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}

}
