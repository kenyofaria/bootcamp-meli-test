package br.com.dh.meli;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class RDBMSCategoryDAO implements CategoryDAO{

	private EntityManager em;
	private JPAUtil jpaUtil = new JPAUtil();
	
	public List<Category> getList() {
		initEntityManager();
		TypedQuery<Category> categoriesQuery = em.createQuery("from Category", Category.class);
		return categoriesQuery.getResultList();
	}

	private void initEntityManager() {
		if(em == null || !em.isOpen())
			em = jpaUtil.getEntityManager();
	}

	public List<Category> getRootCategories() {
		initEntityManager();
		TypedQuery<Category> categoriesQuery = em.createQuery("from Category c where c.parent is null", Category.class);
		return categoriesQuery.getResultList();
	}
	
	public Category get(String id) {
		initEntityManager();
		return em.find(Category.class, id);
	}

	public void save(Category category) {
		initEntityManager();
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
	}

	public List<Category> getLeafCategories() {
		initEntityManager();
		TypedQuery<Category> query = em.createQuery(
				"select c from Category c where c.id not in (select d.parent.id from Category d where d.parent.id is not null)",
				Category.class);
		List<Category> resultList = query.getResultList();
		return resultList;
	}

}
