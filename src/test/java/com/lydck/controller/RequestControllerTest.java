package com.lydck.controller;

import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RequestControllerTest {
	
	@Test
	public void handle41() {
		RestTemplate restTemplate = new RestTemplate();
		LinkedMultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add("username", "Tom");
		form.add("password", "123456");
		form.add("age", "25");
		restTemplate.postForLocation("http://localhost:8080/spring-mvc/handle41", form);
	}
	@Test
	public void handle42() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		byte[] postForObject = restTemplate.postForObject("http://localhost:8080/spring-mvc/handle42/{imageId}", null, byte[].class, "1223");
		Resource outFile = new FileSystemResource("D:\\image.jpg");
		FileCopyUtils.copy(postForObject, outFile.getFile());
	}
	@Test
	public void handle43() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForLocation("http://localhost:8080/spring-mvc/handle43", null);
	}
}
