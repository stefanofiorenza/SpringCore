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
public class CdDaoHibernateBMT implements CdDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CD findById(Long id) {			
		Session session =sessionFactory.getCurrentSession();	
		session.getTransaction().begin();
		CD cd= session.get(CD.class, id);
		session.getTransaction().commit();
		return cd;
	}

	@Override
	public List<CD> findByTitle(String title) {
		Session session =sessionFactory.getCurrentSession();
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
		Session session =sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		Long generatedId= (Long)session.save(newCd);	
		session.getTransaction().commit();
		return generatedId;
	}

	@Override
	public void update(CD updatedCd) {
		Session session =sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		session.update(updatedCd);
		session.getTransaction().commit();
	}

	@Override
	public void delete(CD updatedCd) {
		Session session =sessionFactory.getCurrentSession();
		session.getTransaction().begin();
		session.delete(updatedCd);	
		session.getTransaction().commit();
	}
}
