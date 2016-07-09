package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_objeto")
public class Objeto implements Serializable{

	private static final long serialVersionUID = 3101579128688610761L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "obj_marca")
	private String marca;

	@Column(name = "obj_modelo")
	private String modelo;

	@Column(name = "obj_obs")
	private String observacao;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "objeto", targetEntity = OrdemServicoItem.class)
	private List<OrdemServicoItem> ordemServicoItems;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<OrdemServicoItem> getOrdemServicoItems() {
		return ordemServicoItems;
	}

	public void setOrdemServicoItems(List<OrdemServicoItem> ordemServicoItems) {
		this.ordemServicoItems = ordemServicoItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
