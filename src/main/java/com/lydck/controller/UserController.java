package com.lydck.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lydck.domain.User;
import com.lydck.service.UserException;
import com.lydck.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	//返回一个ModelAndView对象
	@RequestMapping("/register")
	public String register() {
		return "user/register";
	}
	@RequestMapping(value = "createUser", method=RequestMethod.POST)
	public ModelAndView createUser(User user) {
		boolean result = false;
		ModelAndView mav = new ModelAndView();
		try {
			result = userService.createUser(user);
		} catch (UserException e) {
			logger.error("创建用户失败,信息：", e);
			mav.addObject("errorMsg", e.getMessage());
			mav.setViewName("user/error");
			return mav;
		}
		if(result) {
			mav.setViewName("user/createSuccess");
			mav.addObject("user", user);
		} else {
			mav.addObject("errorMsg", "系统未知错误");
			mav.setViewName("user/error");
		}
		return mav;
	}
	@RequestMapping(value = "handle12",method=RequestMethod.POST)
	public void handle12(@CookieValue(value="sessionId")String sessionId,
			@RequestParam("age") int age) {
		logger.info(sessionId);
		logger.info(age + "");
	}
}
