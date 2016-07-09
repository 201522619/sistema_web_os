package br.com.bara.sistema_os.infraestrutura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	
	private static final String PERSISTENCE_UNIT = "sistema_web_os";

	private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();

	private static EntityManagerFactory entityManagerFactory;

	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}
		EntityManager entityManager = threadEntityManager.get();

		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = entityManagerFactory.createEntityManager();
			EntityManagerProducer.threadEntityManager.set(entityManager);
		}
		return entityManager;
	}

	public static void closeEntityManager() {
		EntityManager em = threadEntityManager.get();
		if (em != null) {
			EntityTransaction transaction = em.getTransaction();
			if (transaction.isActive()) {
				transaction.commit();
			}
			em.close();
			threadEntityManager.set(null);
		}
	}

	public static void closeEntityManagerFactory() {
		closeEntityManager();
		entityManagerFactory.close();
	}
	
}

