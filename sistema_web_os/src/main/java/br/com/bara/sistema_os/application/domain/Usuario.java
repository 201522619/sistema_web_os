package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_usuario")
public class Usuario extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 4370449561443997113L;
	
	@Column(name = "usu_data_criacao")
	private Date dataCriacao;

	@Column(name = "usu_data_exclusao")
	private Date dataExclusao;

	@Column(name = "usu_data_alteracao")
	private Date dataAlteracao;

	@Column(name = "usu_login")
	private String login;

	@Column(name = "usu_senha")
	private String senha;
	
	@OneToOne
	private Configuracao configuracao;

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Configuracao getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}
	
}
