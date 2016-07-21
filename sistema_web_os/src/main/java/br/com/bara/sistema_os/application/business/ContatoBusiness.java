package br.com.bara.sistema_os.application.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.bara.sistema_os.application.dao.ContatoDao;
import br.com.bara.sistema_os.application.domain.Contato;

@Named
public class ContatoBusiness  implements Serializable{
	private static final long serialVersionUID = -7155457828133359696L;
	
	@Inject
	private ContatoDao contatoDao;
		
	public void salvar(List<Contato> contatos) {
		for(Contato contato : contatos) {
			salvarContato(contato);
		}
	}
	
	private void salvarContato(Contato contato){
		try {
			
			this.contatoDao.salvar(contato);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Contato> listarTodos() {
		return this.contatoDao.listarTodos();
	}

	public Contato procurarPeloID(Long id) {
		return this.contatoDao.obterPorId(id);
	}

	public void remover(Contato contato) {	
		try {
			if(contato != null){
				this.contatoDao.remover(contato.getId());
			}else{
				throw new RuntimeException("Não foi possível remover o contato! (Contato is null): "+getClass().getSimpleName());
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
