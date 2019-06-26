package com.knits.spring.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDaoHibernate {

	@Autowired
    private SessionFactory sessionFactory;
	
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	
}
