package com.knits.spring.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.knits.spring.common.model.CD;

public class CdDaoFromAbstractHibernateImpl extends AbstractDaoHibernate implements CdDao{


	@Override
	public CD findById(Long id) {			
		return getCurrentSession().load(CD.class, id);	
	}

	@Override
	public List<CD> findByTitle(String title) {
		Query<CD> query =getCurrentSession().createNamedQuery("", CD.class);
		return query.getResultList();
	}

	@Override
	public Long save(CD newCd) {		
		return (Long)getCurrentSession().save(newCd);	
	}

	@Override
	public void update(CD updatedCd) {		
		getCurrentSession().update(updatedCd);
	}

	@Override
	public void delete(CD updatedCd) {		
		getCurrentSession().delete(updatedCd);		
	}
}
