package br.com.bara.sistema_os.application.business;

import java.util.Collection;
import java.util.List;

import br.com.bara.sistema_os.application.domain.Contato;


public class ContatoBusiness  {

	
	public void salvar(List<Contato> contatos) {
		for(Contato contato : contatos) {
			for(Contato c: listarTodos()){
				if(contato.getDescricao().trim().equals(c.getDescricao().trim()) || contato.getId() == c.getId()){
					c.setDescricao(contato.getDescricao());
					salvarContato(c);
					return;
				}
			}
			salvarContato(contato);
		}
	}
	
	private void salvarContato(Contato contato){
	}

	public Collection<Contato> listarTodos() {
		return null;
	}

	public Contato procurarPeloID(Long id) {
		return null;
	}

	public void remover(Contato contato) {
	}

}
