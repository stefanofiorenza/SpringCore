package com.knits.spring.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.knits.spring.jpa.model.CD;

@Repository
public class CdDaoJpaBMT implements CdDao{

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public CD findById(Long id) {			
		EntityManager em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		CD cd= em.find(CD.class, id);
		em.getTransaction().commit();
		return cd;
	}

	@Override
	public List<CD> findByTitle(String title) {
		EntityManager em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CD> query =em.createNamedQuery("CD_ByTitle", CD.class);
		query.setParameter("title", title);
		List<CD> cds= query.getResultList();
		em.getTransaction().commit();
		return cds;
	}

	@Override
	public Long save(CD newCd) {
		EntityManager em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(newCd);	
		em.getTransaction().commit();
		return newCd.getId();
	}

	@Override
	public void update(CD updatedCd) {
		EntityManager em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(updatedCd);	
		em.getTransaction().commit();		
	}

	@Override
	public void delete(CD detachedObject) {
		EntityManager em =entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		if(detachedObject.getId()!=null) {
			CD persistent=em.find(CD.class, detachedObject.getId());
			em.remove(persistent);	
		}		
		em.getTransaction().commit();			
	}
}
