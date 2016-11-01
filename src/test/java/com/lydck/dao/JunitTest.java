package com.lydck.dao;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class JunitTest {
	private String username;
	private String password;
	private String mobile;
	private int socre;
	
	public JunitTest(String username, String password, String mobile, int socre) {
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.socre = socre;
	}
	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection getParameters() {
		Object[][] object = {
				{"xiangyajun", "xinagyajun123", "18601588247", 99},
				{"lydck", "lydck123", "156468351465", 66}
		};
		return Arrays.asList(object);
	}
	@Before
	public void init() {
		System.out.println("init");
	}
	
	@Test(timeout=100)
	public void testTimeOut() throws InterruptedException {
		Thread.currentThread();
		Thread.sleep(200);
	}
	
	@Test
	public void t() {
		System.out.println("t");
	}
	
	@Test
	public void createUser() {
		System.out.println(username);
		System.out.println(password);
		System.out.println(mobile);
		System.out.println(socre);
	}
}
