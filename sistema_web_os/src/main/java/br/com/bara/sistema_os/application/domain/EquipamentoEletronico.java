package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_equip_eletronico")
public class EquipamentoEletronico extends GenericEntity implements Serializable{

	private static final long serialVersionUID = -5746512356013797711L;
	
	@Column(name = "equip_eletr_numero_serie")
	private String numeroSerie;

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	
	

}
