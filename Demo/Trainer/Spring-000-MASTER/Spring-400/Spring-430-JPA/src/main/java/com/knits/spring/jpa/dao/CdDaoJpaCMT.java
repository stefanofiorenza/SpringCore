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
@Transactional
public class CdDaoJpaCMT implements CdDao{

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public CD findById(Long id) {			
		return entityManager.find(CD.class, id);		
	}

	@Override
	public List<CD> findByTitle(String title) {		
		TypedQuery<CD> query =entityManager.createNamedQuery("CD_ByTitle", CD.class);
		query.setParameter("title", title);			
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
	public void delete(CD detachedObject) {		
		if(detachedObject.getId()!=null) {
			CD persistent=entityManager.find(CD.class, detachedObject.getId());
			entityManager.remove(persistent);	
		}						
	}
}
