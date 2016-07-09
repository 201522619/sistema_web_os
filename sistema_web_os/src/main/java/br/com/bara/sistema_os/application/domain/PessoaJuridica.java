package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CNPJ;


@Entity
@Table(name = "tbl_pessoa_juridica")
public class PessoaJuridica implements Serializable {

	private static final long serialVersionUID = -1107520950096278937L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "pj_cnpj")
	//@CNPJ(message = "CNPJ inválido! Tente novamente.")
	private String cnpj;

	@Column(name = "pj_nome_fantasia")
	private String nomeFantasia;
	
	@Column(name = "pj_inscricao_estadual")
	private String inscricaoEstadual;
	
	@Column(name = "pj_inscricao_municipal")
	private String inscricaoMunicipal;
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
