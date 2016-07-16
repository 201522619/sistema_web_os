package br.com.bara.sistema_os.application.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "tbl_status")
@XmlRootElement(name = "statusApp")
public class Status extends GenericEntity implements Serializable{

	private static final long serialVersionUID = -6610600922491368348L;
	
	@Column(name = "sts_descricao")
	@XmlElement(required = true)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
