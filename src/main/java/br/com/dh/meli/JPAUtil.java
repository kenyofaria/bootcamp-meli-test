package br.com.dh.meli;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("meli-testing");
	
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	} 
	
}
