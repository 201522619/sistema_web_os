package br.com.bara.sistema_os.util;

import org.junit.Test;

import br.com.bara.sistema_os.application.dao.PessoaDao;
import br.com.bara.sistema_os.application.domain.Pessoa;

public class TestCliente {
	
	@Test
	public void listar(){
		
		PessoaDao pDao = new PessoaDao();
		for(Pessoa p : pDao.listarTodos()){
			System.out.println(p+"\n");
		}
	}

}
