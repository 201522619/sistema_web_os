package br.com.bara.sistema_os.application.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.bara.sistema_os.application.type.ETipoContato;

@Entity
@Table(name = "tbl_contato")
public class Contato extends GenericEntity implements Serializable{

	private static final long serialVersionUID = 4081899643595068845L;
	
	@Column(name = "cont_descricao")
	private String descricao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipo_contato_id", nullable = false)
	private TipoContato tipoContato;
	
	public ArrayList<TipoContato> getTiposContato() {
		ArrayList<TipoContato> tipoContatos = new ArrayList<TipoContato>();
		TipoContato tc = new TipoContato();
		tc.setDescricao(ETipoContato.TELEFONE.toString());
		tipoContatos.add(tc);
		TipoContato tc2 = new TipoContato();
		tc2.setDescricao(ETipoContato.EMAIL.toString());
		tipoContatos.add(tc2);
        return tipoContatos;
    }
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

	
}
