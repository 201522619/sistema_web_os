package br.com.bara.sistema_os.application.business;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import br.com.bara.sistema_os.application.dao.TipoContatoDao;
import br.com.bara.sistema_os.application.domain.Contato;
import br.com.bara.sistema_os.application.domain.TipoContato;

public class TipoContatoBusiness implements Serializable{
	private static final long serialVersionUID = 40899736028913075L;
	
	private TipoContatoDao tipoContatoDao;
	
	public TipoContatoBusiness(){
		this.tipoContatoDao = new TipoContatoDao();
	}

	public void salvar(TipoContato tipoContato) {
		try {
			if(tipoContato != null){
				this.tipoContatoDao.salvar(tipoContato);
			}else{
				throw new RuntimeException("TipoContato is null: "+getClass());
			}
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public Collection<TipoContato> listarTodos() {
		return this.tipoContatoDao.listarTodos();
	}

	public void remover(TipoContato tipoContato) {
		try {
			if(tipoContato != null){
				this.tipoContatoDao.deletar(tipoContato.getId());
			}else{
				throw new RuntimeException("TipoContato is null: "+getClass());
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
			/*for(TipoContato tc : listarTodos()){
				if(c.getTipoContato().getDescricao().equals(tc.getDescricao()) || c.getTipoContato().getId() == tc.getId()){
					//c.setTipoContato(tc);
					//salvar(c.getTipoContato());
					return;
				}
			}
				Verifica a necessidade da utilização desse bloco de instrução
			*/
			salvar(c.getTipoContato());
		}
	}
	

}
