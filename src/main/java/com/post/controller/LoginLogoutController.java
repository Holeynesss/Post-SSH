package com.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginLogoutController{
	
	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
}
