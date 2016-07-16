package br.com.bara.sistema_os.application.domain;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_ordem_servico")
public class OrdemServico extends GenericEntity implements Serializable{

	private static final long serialVersionUID = 6980028505250705014L;
	
	
	@Column(name = "os_data_gerada")
	private Date dataGerada;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_os_id", nullable = false)
	private TipoDeOs tipoDeOs;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ordemServico", targetEntity = OrdemServicoItem.class)
	private List<OrdemServicoItem> ordemServicoItems;

	public Date getDataGerada() {
		return dataGerada;
	}

	public void setDataGerada(Date dataGerada) {
		this.dataGerada = dataGerada;
	}

	public TipoDeOs getTipoDeOs() {
		return tipoDeOs;
	}

	public void setTipoDeOs(TipoDeOs tipoDeOs) {
		this.tipoDeOs = tipoDeOs;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<OrdemServicoItem> getOrdemServicoItems() {
		return ordemServicoItems;
	}

	public void setOrdemServicoItems(List<OrdemServicoItem> ordemServicoItems) {
		this.ordemServicoItems = ordemServicoItems;
	}
}
