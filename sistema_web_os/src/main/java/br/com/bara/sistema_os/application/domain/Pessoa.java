package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.bara.sistema_os.application.type.EStatus;

@Entity
@Table(name = "tbl_pessoa")
public class Pessoa extends GenericEntity implements Serializable{

	private static final long serialVersionUID = 4526125424731353784L;
	
	@Column(name = "p_nome")
	//@NotEmpty(message = "O nome é obrigatório!")
	private String nome;

	@Column(name = "p_tipoPessoa")
	private String tipoPessoa;

	@Column(name = "p_endereco")
	private String endereco;

	@Column(name = "p_numero")
	private String numero;

	@Column(name = "p_complemento")
	private String complemento;

	@Column(name = "p_bairro")
	private String bairro;

	@Column(name = "p_cidade")
	private String cidade;

	@Column(name = "p_estado")
	private String estado;
	
	@Column(name = "p_cep")
	//@NotEmpty(message = "O CEP é obrigatório!")
	private String cep;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "p_status")
	private EStatus status;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pessoa", targetEntity = Contato.class)
	private List<Contato> contatos;
	
	public Pessoa(){
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep.replaceAll("[.-]", "");;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public EStatus getStatus() {
		return status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String comlemento) {
		this.complemento = comlemento;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
}
