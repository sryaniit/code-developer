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
	public String saveUser(Model model,@ModelAttribute("userobj")User userobj) {
		System.out.println("welcome to post of login");
		udaoimpl.addUser(userobj);
		 if (userobj != null && userobj.getUsername() != null & userobj.getPassword() != null) {
	            if (userobj.getUsername().equals("surya") && userobj.getPassword().equals("srya123")) {
	                model.addAttribute("msg", "welcome" + userobj.getUsername());
	                return "sucess";
	                
	            } else {
	                model.addAttribute("error", "Invalid Details");
	                return "error";
	            }
	        } else {
	            model.addAttribute("error", "Please enter Details");
	            return "error";
	        }
			
		}
	}
	

