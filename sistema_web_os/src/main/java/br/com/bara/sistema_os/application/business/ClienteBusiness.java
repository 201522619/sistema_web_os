package br.com.bara.sistema_os.application.business;

import java.io.Serializable;
import java.util.List;

import br.com.bara.sistema_os.application.dao.PessoaDao;
import br.com.bara.sistema_os.application.dao.PessoaFisicaDao;
import br.com.bara.sistema_os.application.dao.PessoaJuridicaDao;
import br.com.bara.sistema_os.application.domain.Pessoa;
import br.com.bara.sistema_os.application.type.ETipoPessoa;

public class ClienteBusiness implements Serializable{

	private static final long serialVersionUID = 6951385777723359664L;

	private PessoaDao pessoaDao;
	
	private PessoaFisicaDao pessoaFisicaDao;
	
	private PessoaJuridicaDao pessoaJuridicaDao;
	
	public ClienteBusiness(){
		this.pessoaDao = new PessoaDao();
		this.pessoaFisicaDao = new PessoaFisicaDao();
		this.pessoaJuridicaDao = new PessoaJuridicaDao();
	}
	
	public void consistirParaSalvar(Pessoa pessoa) {
		try {
			if (pessoa.getTipoPessoa().equals(ETipoPessoa.FISICA.getTipoPessoa())) {
				salvarPessoaFisica(pessoa);
			} else {
				salvarPessoaJuridica(pessoa);
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	public void consistirParaEditar(Pessoa pessoa) {
		try {
			if(pessoa.getTipoPessoa().equals(ETipoPessoa.FISICA.getTipoPessoa())){
				salvarPessoaFisica(pessoa);
			}else{
				salvarPessoaJuridica(pessoa);
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void salvarPessoaJuridica(Pessoa pessoa) {
		try {
			salvarPessoa(pessoa);
			pessoaJuridicaDao.salvar(pessoa.getPj());
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void salvarPessoaFisica(Pessoa pessoa) {
		try {
			salvarPessoa(pessoa);
			pessoaFisicaDao.salvar(pessoa.getPf());
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Pessoa> listarTodos() {
		try {
			return pessoaDao.listarTodos();
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

	public void salvarPessoa(Pessoa pessoa) {
		try {
			pessoaDao.salvar(pessoa);
		}  catch (RuntimeException e) {
			System.out.println(e.getMessage() + " Causa: "+e.getCause());
			throw new RuntimeException(e.getMessage());
		}
	
	}
	
	public Pessoa procurarPeloID(Long id) {
		try {
			return pessoaDao.obterPorId(id);
		}  catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}

}