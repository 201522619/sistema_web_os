package br.com.bara.sistema_os.application.business;

import java.io.Serializable;
import java.util.List;

import br.com.bara.sistema_os.application.dao.PessoaDao;
import br.com.bara.sistema_os.application.dao.PessoaFisicaDao;
import br.com.bara.sistema_os.application.dao.PessoaJuridicaDao;
import br.com.bara.sistema_os.application.domain.Contato;
import br.com.bara.sistema_os.application.domain.Pessoa;
import br.com.bara.sistema_os.application.domain.TipoContato;
import br.com.bara.sistema_os.application.type.ETipoPessoa;

public class ClienteBusiness implements Serializable{

	private static final long serialVersionUID = 6951385777723359664L;

	private PessoaDao pessoaDao;
	private PessoaFisicaDao pessoaFisicaDao;
	private PessoaJuridicaDao pessoaJuridicaDao;
	private ContatoBusiness contatoBusiness;
	private TipoContatoBusiness tipoContatoBusiness;
	
	public ClienteBusiness(){
		this.pessoaDao = new PessoaDao();
		this.pessoaFisicaDao = new PessoaFisicaDao();
		this.pessoaJuridicaDao = new PessoaJuridicaDao();
		this.contatoBusiness = new ContatoBusiness();
		this.tipoContatoBusiness = new TipoContatoBusiness();
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
			this.pessoaJuridicaDao.salvar(pessoa.getPj());
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void salvarPessoaFisica(Pessoa pessoa) {
		try {
			salvarPessoa(pessoa);
			this.pessoaFisicaDao.salvar(pessoa.getPf());
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

	public void salvarPessoa(Pessoa pessoa) {
		try {
			for(Contato contato : pessoa.getContatos()){
				for(TipoContato tipoContato : this.tipoContatoBusiness.listarTodos()){
					if(contato.getTipoContato().getDescricao() != tipoContato.getDescricao()){
						this.tipoContatoBusiness.salvar(contato.getTipoContato());
					}else{
						throw new RuntimeException("Já possui esse tipo de contato salvo no banco de dados! Por favor informe outro tipo de contato!");
					}
				}
			}
			this.contatoBusiness.salvar(pessoa.getContatos());
			//this.pessoaDao.salvar(pessoa);
		}  catch (RuntimeException e) {
			System.out.println(e.getMessage() + " Causa: "+e.getCause());
			throw new RuntimeException(e.getMessage());
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