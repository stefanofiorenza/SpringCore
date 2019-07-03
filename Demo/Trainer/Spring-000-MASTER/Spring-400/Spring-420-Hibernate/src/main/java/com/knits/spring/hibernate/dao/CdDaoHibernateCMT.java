package com.knits.spring.hibernate.dao;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.knits.spring.hibernate.model.CD;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class CdDaoHibernateCMT implements CdDao{

	@PersistenceContext
    private Session session;
	
	@Override	
	public CD findById(Long id) {			
		return session.get(CD.class, id);		
	}

	@Override	
	public List<CD> findByTitle(String title) {
		Query<CD> query =session.createNamedQuery("CD_ByTitle", CD.class);
		query.setParameter("title", title);
		return query.getResultList();
	}

	@Override
	public Long save(CD newCd) {		
		return (Long)session.save(newCd);			
	}

	@Override
	public void update(CD updatedCd) {
		session.update(updatedCd);			
	}

	@Override	
	public void delete(CD updatedCd) {
		session.delete(updatedCd);		
	}
}
