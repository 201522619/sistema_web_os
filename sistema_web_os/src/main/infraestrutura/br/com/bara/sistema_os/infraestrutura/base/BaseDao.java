package br.com.bara.sistema_os.infraestrutura.base;

import java.util.List;

public interface BaseDao<E> {

	void salvar(E entidade);
	
	void remover(Long id);

	List<E> listarTodos();

	E obterPorId(Long id);

}