package com.lydck.controller;

import java.io.IOException;
import java.util.Collections;

import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.lydck.domain.User;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class RequestControllerTest {
	
	@Test
	public void handle41() {
		RestTemplate restTemplate = new RestTemplate();
		LinkedMultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add("username", "Tom");
		form.add("password", "123456");
		form.add("age", "25");
		restTemplate.postForLocation("http://localhost:8081/spring-mvc/handle41", form);
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
		restTemplate.postForLocation("http://localhost:8081/spring-mvc/handle43", null);
	}
	/**
	 * servlet端配置的xml转换器会将请求中的对象流化为xml格式
	 */
	@Test
	public void handle51() {
		RestTemplate restTemplate = new RestTemplate();
		User user = new User();
		user.setUsername("xiangyajun");
		user.setPassword("123456");
		user.setMobile("186015882474");
		HttpHeaders httpHeaders = new HttpHeaders();
		//httpHeaders.setContentType(MediaType.valueOf("application/xml;UTF-8"));
		//httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));//返回响应报文为Xml
		httpHeaders.setContentType(MediaType.valueOf("application/json;UTF-8"));
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));//返回响应报文为Json
		HttpEntity<User> httpEntity = new HttpEntity<User>(user, httpHeaders);
		ResponseEntity<User> exchange = restTemplate.exchange("http://localhost:8081/spring-mvc/handle51", HttpMethod.POST, httpEntity, User.class);
		User body = exchange.getBody();
		System.out.println(body.getId());
		System.out.println(body.getUsername());
	}
	@Test
	public void buildXMLRequest() {
		XStreamMarshaller xmlMarshaller = new XStreamMarshaller();
		xmlMarshaller.setStreamDriver(new StaxDriver());
		xmlMarshaller.setAnnotatedClasses(User.class);
		MarshallingHttpMessageConverter xmlConvert = new MarshallingHttpMessageConverter();
		xmlConvert.setMarshaller(xmlMarshaller);
		xmlConvert.setUnmarshaller(xmlMarshaller);
	}
	@Test
	public void handle61() {
		RestTemplate restTemplate = new RestTemplate();
		LinkedMultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add("username", "Tom");
		form.add("password", "123456");
		form.add("age", "25");
		restTemplate.postForLocation("http://localhost:8081/spring-mvc/handle61", form);
	}
	
	@Test
	public void handle63() {
		RestTemplate restTemplate = new RestTemplate();
		LinkedMultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add("username", "Tom");
		form.add("password", "123456");
		form.add("age", "25");
		restTemplate.postForLocation("http://localhost:8081/spring-mvc/handle63", form);
	}
}
