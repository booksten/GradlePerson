package com.blende.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blende.controller.common.BaseController;
import com.blende.dao.PersonDao;

@Controller
public class UsersController extends BaseController {
	private final PersonDao personDao;
	
	@Autowired
	public UsersController(PersonDao personDao){
		this.personDao = personDao;
	}
	
	@RequestMapping("users")
	public String loadHomePage(Model m) {
        m.addAttribute("name", "Users Page");
        return "users";
    }
	
}
