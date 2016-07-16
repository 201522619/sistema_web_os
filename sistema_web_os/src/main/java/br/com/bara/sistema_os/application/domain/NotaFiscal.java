package br.com.bara.sistema_os.application.domain;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_nota_fiscal")
public class NotaFiscal extends GenericEntity implements Serializable{
	
	private static final long serialVersionUID = -813729497130308645L;
	
	private Integer numNF;

	private Integer serie;

	private Date dataCompra;

	public Integer getNumNF() {
		return numNF;
	}

	public void setNumNF(Integer numNF) {
		this.numNF = numNF;
	}

	public Integer getSerie() {
		return serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

}
