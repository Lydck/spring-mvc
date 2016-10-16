package com.lydck.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lydck.dao.UserDao;
import com.lydck.domain.User;
import com.lydck.util.ValidateUtil;

@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	public User getUser(User user) {
		logger.info("查询用户信息，入参：" + user);
		String validate = ValidateUtil.validate(user);
		if(validate != null) {
			logger.error(validate);
			throw new RuntimeException(validate);
		}
		return userDao.getUser(user);
	}
	
}
