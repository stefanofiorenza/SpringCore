package com.knits.spring.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.knits.spring.common.model.CD;

@Repository
public class CdDaoHibernateImpl implements CdDao{

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public CD findById(Long id) {			
		Session session =sessionFactory.getCurrentSession();		
		return session.load(CD.class, id);			
	}

	@Override
	public List<CD> findByTitle(String title) {

		Session session =sessionFactory.getCurrentSession();
		Query<CD> query =session.createNamedQuery("", CD.class);
		return query.getResultList();
	}

	@Override
	public Long save(CD newCd) {
		Session session =sessionFactory.getCurrentSession();
		return (Long)session.save(newCd);	
	}

	@Override
	public void update(CD updatedCd) {
		Session session =sessionFactory.getCurrentSession();
		session.update(updatedCd);
	}

	@Override
	public void delete(CD updatedCd) {
		Session session =sessionFactory.getCurrentSession();
		session.delete(updatedCd);		
	}
}
