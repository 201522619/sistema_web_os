package br.com.bara.sistema_os.application.business;

import java.io.Serializable;
import java.util.List;

import br.com.bara.sistema_os.application.dao.TipoContatoDao;
import br.com.bara.sistema_os.application.domain.Contato;
import br.com.bara.sistema_os.application.domain.TipoContato;
import br.com.bara.sistema_os.application.type.ETipoContato;

public class TipoContatoBusiness implements Serializable{
	private static final long serialVersionUID = 40899736028913075L;
	
	private TipoContatoDao tipoContatoDao;
	
	private TipoContato tipoContato;
	
	public TipoContatoBusiness(){
		this.tipoContato = new TipoContato();
		this.tipoContatoDao = new TipoContatoDao();
	}

	public void salvar(ETipoContato eTipoContato) {
		try {
			if(eTipoContato != null){
				this.tipoContato.setDescricao(eTipoContato);
				this.tipoContatoDao.salvar(tipoContato);
			}else{
				throw new RuntimeException("TipoContato is null: "+getClass().getSimpleName());
			}
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public List<TipoContato> listarTodos() {
		return this.tipoContatoDao.listarTodos();
	}

	public void remover(TipoContato tipoContato) {
		try {
			if(tipoContato != null){
				this.tipoContatoDao.remover(tipoContato.getId());
			}else{
				throw new RuntimeException("TipoContato is null: "+getClass().getSimpleName());
			}
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public TipoContato procurarPeloID(Long id) {
		return this.tipoContatoDao.obterPorId(id);
	}
	
	public void consistirAntesDeSalvar(List<Contato> contatos){
		for(Contato c : contatos){
			salvar(c.getTipoContato());
		}
	}
	

}
