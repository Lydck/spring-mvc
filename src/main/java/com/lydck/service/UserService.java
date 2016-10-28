package com.lydck.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lydck.dao.UserDao;
import com.lydck.domain.User;
import com.lydck.entity.TUser;
import com.lydck.util.BeanUtil;
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
	public List<User> getUsers(User user) {
		logger.info("查询用户列表，入参：" + user);
		TUser param = null;
		if(user != null) {
			param = new TUser();
			BeanUtil.copyBean(user, param);
		}
		List<TUser> users = userDao.getUsers(param);
		List<User> result = null;
		if(!users.isEmpty()) {
			result = new ArrayList<User>();
			for (TUser tuser : users) {
				User target = new User();
				BeanUtil.copyBean(tuser, target);
				result.add(target);
			}
		}
		return result;
	}
	public boolean createUser(User user) throws UserException{
		logger.info("创建用户，入参：" + user);
		String validate = ValidateUtil.validate(user);
		if(validate != null) {
			logger.error(validate);
			throw new UserException(ErrorCode.E0001.getCode(), validate);
		}
		TUser tuser = new TUser();
		BeanUtil.copyBean(user, tuser);
		return userDao.createUser(tuser);
	}
	
}
