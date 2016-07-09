package br.com.bara.sistema_os.application.domain;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.bara.sistema_os.application.type.EStatus;


@Entity
@Table(name = "tbl_ordem_servico_item")
public class OrdemServicoItem implements Serializable{

	private static final long serialVersionUID = 3505170149061945029L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "os_item_garantia")
	private boolean garantia;

	@Column(name = "os_item_valor")
	private Double valor;

	@Column(name = "os_item_defeito")
	private String defeito;

	@Column(name = "os_item_conserto")
	private String conserto;

	@Column(name = "os_item_data_prevista")
	private Date dataPrevista;

	@Column(name = "os_item_data_entrada")
	private Date dataEntrega;
	
	@Column(name = "os_item_obs")
	private String observacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ordem_servico_id", nullable = false)
	private OrdemServico ordemServico;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "objeto_id", nullable = false)
	private Objeto objeto;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "os_item_status")
	private EStatus status;
	
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "status_id", nullable = false)
	private Status status;*/

	public boolean isGarantia() {
		return garantia;
	}

	public void setGarantia(boolean garantia) {
		this.garantia = garantia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public String getConserto() {
		return conserto;
	}

	public void setConserto(String conserto) {
		this.conserto = conserto;
	}

	public Date getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public EStatus getStatus() {
		return status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}*/
	
	

}
