package com.niit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.UserDAOImpl;
import com.niit.model.User;

@Controller
public class LoginController {


/*	@RequestMapping(value="/link")
	public ModelAndView getpage(){
		
		String msg="Mapping Success with JSP ";
		return new ModelAndView("login","msg",msg);
	}
	
	*/
	@Autowired(required=true)
	UserDAOImpl udaoimpl;

	// Mapping of login spring mvc login form with model class
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public String submitregForm(@ModelAttribute("userobj") User userobj) {

		//ModelAndView model = new ModelAndView("Login");
		System.out.println("welcome to get of register");
		return "Register";
	}

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public ModelAndView submitregForm(Model m) {
		System.out.println("welcome to post of register");
		ModelAndView model = new ModelAndView("Login", "userobj", new User());
		return model;
		// ModelAndView model=new ModelAndView("login");
		// return model;
	}
	

}
