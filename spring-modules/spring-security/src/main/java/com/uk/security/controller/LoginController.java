package com.uk.security.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	/**
	 * For Login page
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "err", required = false) String error,
			@RequestParam(value = "out", required = false) String logout,
			@RequestParam(value = "time", required = false) String time) {

		ModelAndView model = new ModelAndView();
		if (error != null && error.equalsIgnoreCase("1")) {
			model.addObject("error", "Invalid username and password!");
		}

		if ((logout != null && logout.equalsIgnoreCase("1")) || (time != null && time.equalsIgnoreCase("1"))) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
	}

	/**
	 * For 403 access denied page
	 * @return
	 */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accessDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}

		model.setViewName("403");
		
		return model;
	}
}
