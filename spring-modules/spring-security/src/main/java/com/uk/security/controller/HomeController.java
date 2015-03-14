package com.uk.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = { "/", "/home**" }, method = RequestMethod.GET)
	public ModelAndView home() {
		
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Home Page");
		model.addObject("message", "This is home page!");
		model.setViewName("home");
		
		return model;
	}
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Home Page");
		model.addObject("message", "This is admin protected page!");
		model.setViewName("admin");
 
		return model;
	}
}
