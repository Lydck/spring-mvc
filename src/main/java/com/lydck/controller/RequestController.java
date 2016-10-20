package com.lydck.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lydck.domain.ParamA;

@Controller
public class RequestController {
	
	private static Logger logger = LoggerFactory.getLogger(RequestController.class);
	
	@RequestMapping(value = "handle12",method=RequestMethod.POST)
	public void handle12(@CookieValue(value="sessionId", required = false)String sessionId,
			@RequestParam("age") int age) {
		logger.info(sessionId);
		logger.info(age + "");
	}
	@RequestMapping(value = "handle13")
	public void handle13(ParamA paramA) {
		logger.info(paramA.getA());
		logger.info(paramA.getParamB().getB());
		logger.info(paramA.getParamB().getParamC().getC());
	}
}
