package com.knits.spring.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.knits.spring.jpa.model.CD;

@Repository
public class CdDaoJpaCMT implements CdDao{

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CD findById(Long id) {			
		return entityManager.find(CD.class, id);		
	}

	@Override
	public List<CD> findByTitle(String title) {
		TypedQuery<CD> query =entityManager.createNamedQuery("", CD.class);
		return query.getResultList();
	}

	@Override
	public Long save(CD newCd) {
		 entityManager.persist(newCd);	
		 return newCd.getId();
	}

	@Override
	public void update(CD updatedCd) {
		entityManager.merge(updatedCd);		
	}

	@Override
	public void delete(CD updatedCd) {
		entityManager.remove(updatedCd);			
	}
}
