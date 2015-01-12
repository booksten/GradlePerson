package com.blende.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.blende.dao.common.GenericDao;
import com.blende.model.Person;

@Repository
public interface PersonDao extends GenericDao<Person>{
	List getUsers();
	Person getByUserName(String userName);
}
