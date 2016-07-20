package br.com.bara.sistema_os.application.business;

import java.io.Serializable;
import java.util.List;

import br.com.bara.sistema_os.application.dao.ContatoDao;
import br.com.bara.sistema_os.application.domain.Contato;


public class ContatoBusiness  implements Serializable{
	private static final long serialVersionUID = -7155457828133359696L;
	
	private ContatoDao contatoDao;
		
	public ContatoBusiness(){
		this.contatoDao = new ContatoDao();
	}
	
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
