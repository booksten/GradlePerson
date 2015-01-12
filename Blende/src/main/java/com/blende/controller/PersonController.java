package com.blende.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blende.controller.common.BaseController;
import com.blende.dao.PersonDao;

@RestController
public class PersonController extends BaseController{
	private final PersonDao personDao;
	
	@Autowired
	public PersonController(PersonDao personDao){
		this.personDao = personDao;
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public List getPeople()
	{
		return personDao.getUsers();
	}
	
}
