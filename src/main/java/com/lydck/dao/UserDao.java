package com.lydck.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lydck.entity.TUser;

@Service
public class UserDao {
	@Autowired
	private SqlSessionTemplate batisTemplate;
	
	public TUser getUser(TUser user) {
		return batisTemplate.selectOne(this.getClass().getName() + ".getUser", user);
	}
}
