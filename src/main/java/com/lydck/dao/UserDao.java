package com.lydck.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lydck.domain.User;
import com.lydck.entity.TUser;

@Service
public class UserDao {
	@Autowired
	private SqlSessionTemplate batisTemplate;
	
	public User getUser(User user) {
		return batisTemplate.selectOne(this.getClass().getName() + ".getUser", user);
	}
	
	public boolean createUser(TUser user) {
		int insert = batisTemplate.insert(this.getClass().getName() + ".createUser", user);
		return insert == 1;
	}
}
