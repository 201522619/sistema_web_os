package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_status_funcionario")
public class StatusFuncionario extends GenericEntity implements Serializable{

	private static final long serialVersionUID = 7901086432290552292L;
	
	@Column(name = "sf_descricao")
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, 
    mappedBy = "statusFuncionario", 
	targetEntity = Funcionario.class)
	private List<Funcionario> funcionarios; 

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
