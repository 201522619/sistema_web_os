package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.bara.sistema_os.application.type.EStatus;

@Entity
@Table(name = "tbl_pessoa")
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 4526125424731353784L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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
	
	@OneToOne(fetch = FetchType.EAGER)
	private PessoaFisica pf;

	@OneToOne(fetch = FetchType.EAGER)
	private PessoaJuridica pj;

	@Enumerated(EnumType.STRING)
	@Column(name = "p_status")
	private EStatus status;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pessoa", targetEntity = Contato.class)
	private List<Contato> contatos;
	
	//private Contato contato;
	
	public Pessoa(){
		this.pf = new PessoaFisica();
		this.pj = new PessoaJuridica();
		//this.contato = new Contato();
		this.contatos = new ArrayList<Contato>();
	}
	
	/*public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
*/
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

	public PessoaFisica getPf() {
		return pf;
	}

	public void setPf(PessoaFisica pf) {
		this.pf = pf;
	}

	public PessoaJuridica getPj() {
		return pj;
	}

	public void setPj(PessoaJuridica pj) {
		this.pj = pj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", tipoPessoa="
				+ tipoPessoa + ", endereco=" + endereco + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep
				+ ", pf=" + pf + ", pj=" + pj + ", status=" + status
				+ ", contatos=" + contatos + "]";
	}
	
}
