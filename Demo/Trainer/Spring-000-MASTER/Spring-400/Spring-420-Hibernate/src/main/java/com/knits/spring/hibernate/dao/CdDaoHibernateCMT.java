package com.knits.spring.hibernate.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.knits.spring.hibernate.model.CD;

@Repository
public class CdDaoHibernateCMT implements CdDao{

	@PersistenceContext
    private Session session;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CD findById(Long id) {			
		return session.get(CD.class, id);		
	}

	@Override
	public List<CD> findByTitle(String title) {
		Query<CD> query =session.createNamedQuery("", CD.class);
		/*
		List<CDDto> results = new ArrayList<CDDto>();
		query.getResultList().forEach( cdModel -> results.add(BeanUtils.model2Dto(cdModel) ));;
		return results;
		*/
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
