package com.blende.dao.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractHibernateDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected final Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
