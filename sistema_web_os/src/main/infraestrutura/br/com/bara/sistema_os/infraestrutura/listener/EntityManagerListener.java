package br.com.bara.sistema_os.infraestrutura.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.com.bara.sistema_os.infraestrutura.EntityManagerProducer;

@WebListener
public class EntityManagerListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		EntityManagerProducer.getEntityManager();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		EntityManagerProducer.closeEntityManagerFactory();
	}

}
