package br.com.bara.sistema_os.infraestrutura;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class BaseDaoHibernate<E> implements BaseDao<E> {

	private Class<E> entidadeClasse;

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
			manager = EntityManagerProducer.getEntityManager();
			manager.getTransaction().begin();
			manager.merge(entidade);
			manager.getTransaction().commit();
		} catch (RuntimeException e) {
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
			}
			throw e;
		}finally {
			manager.close();
		}
	}

	@Override
	public void deletar(Long id) {
		try {
			manager = EntityManagerProducer.getEntityManager();
			manager.getTransaction().begin();
			E objeto = obterPorId(id);
			manager.remove(objeto);
			manager.getTransaction().commit();
		} catch (RuntimeException e) {
			if (manager.isOpen()) {
				manager.getTransaction().rollback();
			}	
			throw e;
		}finally {
			manager.close();
		}
	}

	@Override
	public List<E> listarTodos() {
		CriteriaQuery<E> query = manager.getCriteriaBuilder().createQuery(entidadeClasse);
		query.from(entidadeClasse);
		return manager.createQuery(query).getResultList();
	}

	@Override
	public E obterPorId(Long id) {
		return manager.find(entidadeClasse, id);
	}

}
