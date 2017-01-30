package com.niit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.UserDAOImpl;
import com.niit.model.Register;
import com.niit.model.User;

@Controller
public class LoginController {


	@Autowired(required=true)
	UserDAOImpl udaoimpl;

	// Mapping of login spring mvc login form with model class
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView submitregForm(@ModelAttribute("userobj") User userobj) {

		ModelAndView model = new ModelAndView("Login");
		System.out.println("welcome to get of login");
		return model;
	
	}

	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public ModelAndView saveUser(User userobj) {
		System.out.println("welcome to post of register");
		udaoimpl.addUser(userobj);
		ModelAndView model = new ModelAndView("sucess", "userobj",new User());
		return model;
	}
	
}
