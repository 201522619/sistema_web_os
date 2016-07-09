package br.com.bara.sistema_os.application.business;

import java.util.Collection;
import java.util.List;

import br.com.bara.sistema_os.application.domain.Contato;
import br.com.bara.sistema_os.application.domain.TipoContato;

public class TipoContatoBusiness {
	

	public void salvar(TipoContato tipoContato) {
	}

	public Collection<TipoContato> listarTodos() {
		return null;
	}

	public void remover(TipoContato tipoContato) {
	}

	public TipoContato procurarPeloID(Long id) {
		return null;
	}
	
	public void consistirAntesDeSalvar(List<Contato> contatos){
		for(Contato c : contatos){
			for(TipoContato tc : listarTodos()){
				if(c.getTipoContato().getDescricao().equals(tc.getDescricao()) || c.getTipoContato().getId() == tc.getId()){
					//c.setTipoContato(tc);
					//salvar(c.getTipoContato());
					return;
				}
			}
			//salvar(c.getTipoContato());
		}
	}
	

}
