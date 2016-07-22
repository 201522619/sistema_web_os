package br.com.bara.sistema_os.application.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.bara.sistema_os.application.dao.PessoaDao;
import br.com.bara.sistema_os.application.domain.Pessoa;
import br.com.bara.sistema_os.infraestrutura.interceptors.Transactional;

@Named
@Transactional(readOnly = true)
public class ClienteBusiness implements Serializable{

	private static final long serialVersionUID = 6951385777723359664L;
	
	@Inject
	private PessoaDao pessoaDao;
	
	@Inject
	private ContatoBusiness contatoBusiness;
	
	public void consistirParaSalvar(Pessoa pessoa) {
		try {
			if(pessoa != null){
				salvarPessoa(pessoa);
			}else{
				throw new RuntimeException("Pessoa is Null "+getClass().getSimpleName());
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public List<Pessoa> listarTodos() {
		try {
			return this.pessoaDao.listarTodos();
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Transactional(readOnly = false)
	public void salvarPessoa(Pessoa pessoa) {
		try {
			this.pessoaDao.salvar(pessoa);
			consistirTipoContato(pessoa);
		}  catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	private void consistirTipoContato(Pessoa pessoa){
		try {
			if(pessoa.getContatos() != null){
				this.contatoBusiness.salvar(pessoa.getContatos());
			}else{
				throw new RuntimeException("List of the contatos is null "+getClass().getSimpleName());
			}
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	public Pessoa procurarPeloID(Long id) {
		try {
			return this.pessoaDao.obterPorId(id);
		}  catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}