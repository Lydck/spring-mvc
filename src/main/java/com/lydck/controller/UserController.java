package com.lydck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lydck.domain.User;
import com.lydck.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//返回一个ModelAndView对象
	@RequestMapping("/register")
	public String register(User user) {
//		userService.getUser(user);
		return "user/register";
	}
	@RequestMapping(value = "createUser", method=RequestMethod.POST)
	public ModelAndView createUser(User user) {
		userService.getUser(user);
		return null;
	}
	
}
