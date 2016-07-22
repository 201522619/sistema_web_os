package br.com.bara.sistema_os.infraestrutura.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

@Named
public class BaseDaoHibernate<E> implements BaseDao<E> {

	private Class<E> entidadeClasse;

	@Inject
	private EntityManager manager;
	
	@SuppressWarnings({ "unchecked"})
	public BaseDaoHibernate() {
		Class<?> clazz = getClass();
		if (!(clazz.getGenericSuperclass() instanceof ParameterizedType)) {
			clazz = clazz.getSuperclass();
		}

		ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
		entidadeClasse = (Class<E>) parameterizedType.getActualTypeArguments()[0];

	}

	@Override
	public void salvar(E entidade) {
		try {
			manager.merge(entidade);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	public void remover(Long id) {
		try {
			E objeto = obterPorId(id);
			manager.remove(objeto);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	public List<E> listarTodos() {
		try {
			CriteriaQuery<E> query = manager.getCriteriaBuilder().createQuery(entidadeClasse);
			query.from(entidadeClasse);
			return manager.createQuery(query).getResultList();
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	public E obterPorId(Long id) {
		try {
			return manager.find(entidadeClasse, id);
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
