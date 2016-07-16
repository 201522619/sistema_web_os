package br.com.bara.sistema_os.application.domain;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_funcionario")
public class Funcionario extends GenericEntity implements Serializable{

	private static final long serialVersionUID = 6971886953333306565L;
	
	@Column(name = "fun_data_criacao")
	private Date dataCriacao;
	
	@Column(name = "fun_data_exclusao")
	private Date dataExcluxao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status_funcionario_id", nullable = false)
	private StatusFuncionario statusFuncionario;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "funcionario", targetEntity = OrdemServico.class)
	private List<OrdemServico> ordemServico;
	
	@ManyToMany
	@JoinTable(name = "tbl_cargo_funcionario", 
	joinColumns = {@JoinColumn(name = "cargo_id")}, 
	inverseJoinColumns = {@JoinColumn(name = "funcionario_id")})
	private List<Cargo> cargos;
	
	public StatusFuncionario getStatusFuncionario() {
		return statusFuncionario;
	}

	public void setStatusFuncionario(StatusFuncionario statusFuncionario) {
		this.statusFuncionario = statusFuncionario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataExcluxao() {
		return dataExcluxao;
	}

	public void setDataExcluxao(Date dataExcluxao) {
		this.dataExcluxao = dataExcluxao;
	}

	public List<OrdemServico> getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(List<OrdemServico> ordemServico) {
		this.ordemServico = ordemServico;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

}
