package br.com.bara.sistema_os.application.business;

import java.io.Serializable;
import java.util.List;

import br.com.bara.sistema_os.application.dao.ContatoDao;
import br.com.bara.sistema_os.application.domain.Contato;


public class ContatoBusiness  implements Serializable{
	private static final long serialVersionUID = -7155457828133359696L;
	
	private ContatoDao contatoDao;
	
	private TipoContatoBusiness tipoContatoBusiness;
	
	public ContatoBusiness(){
		this.contatoDao = new ContatoDao();
		this.tipoContatoBusiness = new TipoContatoBusiness();
	}
	
	public void salvar(List<Contato> contatos) {
		for(Contato contato : contatos) {
			consistirTipocontato(contato);
			salvarContato(contato);
		}
	}
	
	private void consistirTipocontato(Contato contato){
		/*if(this.tipoContatoBusiness.listarTodos() != null){
			for(TipoContato tipoContato : this.tipoContatoBusiness.listarTodos()){
				if(contato.getTipoContato().getTipoContato() != tipoContato.getDescricao().getTipoContato()){
					this.tipoContatoBusiness.salvar(contato.getTipoContato());
				}else{
					throw new RuntimeException("Já possui esse tipo de contato salvo no banco de dados! Por favor informe outro tipo de contato!");
				}
			}
		}else{
			this.tipoContatoBusiness.salvar(contato.getTipoContato());
		}*/
		this.tipoContatoBusiness.salvar(contato.getTipoContato());
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
