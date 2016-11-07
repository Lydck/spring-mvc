package com.lydck.dao;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.lydck.service.UserException;
import com.lydck.service.UserService;

public class SimpleMockitoTest {
	
	//模拟实现类
	UserDao mockUserDao = mock(UserDao.class);
	
	UserService mockUserService = mock(UserService.class);
	
	@Test
	public void mockService() throws UserException {
		mockUserService.createUser(null);
		
	}
}
