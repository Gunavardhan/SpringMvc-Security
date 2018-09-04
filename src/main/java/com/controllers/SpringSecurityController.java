package com.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringSecurityController {
	@RequestMapping(value="/gotologin")
	public ModelAndView gotoLoginView(){
		System.out.println("Login page opened");
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
	@RequestMapping(value="/gotologinfail")
	public String gotoLoginFail(Model model){
		System.out.println("Login page failure");
		model.addAttribute("msg", "Invalid Credntilas,Please try with valid credentilas");
		return "login";
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}
		model.setViewName("403");
		return model;

	}
	
	@RequestMapping(value="/home")
	public String gotoHome(){
		System.out.println("Home Page");
		return "home";
	}
}
