package br.com.bara.sistema_os.infraestrutura;

import java.util.List;

public interface BaseDao<E> {

	void salvar(E entidade);
	
	void deletar(Long id);

	List<E> listarTodos();

	E obterPorId(Long id);

}