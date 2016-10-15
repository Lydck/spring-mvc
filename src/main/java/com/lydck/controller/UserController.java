package com.lydck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lydck.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//返回一个ModelAndView对象
	@RequestMapping("/register")
	public String register() {
		System.out.println("register");
		return "user/register";
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView createUser(User user) {
		
		return null;
	}
}
