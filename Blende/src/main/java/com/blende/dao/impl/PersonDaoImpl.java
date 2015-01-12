package com.blende.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.hibernate.transform.Transformers;

import com.blende.dao.PersonDao;
import com.blende.dao.common.AbstractHibernateGenericDao;
import com.blende.dto.PersonResponse;
import com.blende.model.Person;

@Repository
public class PersonDaoImpl extends AbstractHibernateGenericDao<Person> implements PersonDao {
	
	@Override
	public Person getByUserName(String userName){
		return new Person();
	}
	
	@Override
	public List getUsers(){
		final String sql = "select p.id as id, p.firstName as firstName, p.lastName as lastName from Person p";
		
		return getSession()
				.createQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(PersonResponse.class))
				.list();
	}
}
