package com.niit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.RegisterDAOImpl;
import com.niit.dao.UserDAOImpl;
import com.niit.model.Register;
import com.niit.model.User;

@Controller
public class RegisterController {


	@Autowired(required=true)
	RegisterDAOImpl regdaoimpl;

	// Mapping of login spring mvc login form with model class
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public ModelAndView submitregForm(@ModelAttribute("userobj") Register userobj) {

		ModelAndView model = new ModelAndView("Register");
		System.out.println("WElcome to register page");
		return model;
	
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView saveUser(Register userobj) {
		System.out.println("welcome to post of register");
		regdaoimpl.addUser(userobj);
		ModelAndView model = new ModelAndView("RegSucess", "userobj",new Register());
		return model;
	}
	
}
