package com.lydck.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.lydck.domain.ParamA;
import com.lydck.domain.User;

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
	@RequestMapping("handle25")
	public void handle25(WebRequest request) {
		String username = request.getParameter("username");
		logger.info(username);
	}
	/**将请求报文参数列表绑定到requestBody中
	 * @param requestBody
	 */
	@RequestMapping("handle41")
	public void handle41(@RequestBody String requestBody) {
		logger.info(requestBody);
	}
	/**使用ResponseEntity
	 * @param imageId
	 * @return
	 */
	@RequestMapping("handle42/{imageId}")
	public ResponseEntity<byte[]> handle42(@PathVariable("imageId") String imageId) {
		logger.info("根据图片ID加载..." + imageId);
		Resource resource = new ClassPathResource("/image.jpg");
		ResponseEntity<byte[]> fileData = null;
		try {
			byte[] data = FileCopyUtils.copyToByteArray(resource.getInputStream());
			fileData = new ResponseEntity<byte[]>(data, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return fileData;
	}
	@RequestMapping("handle43")
	public void handle43(HttpEntity<String> httpEntity) {
		long contentLength = httpEntity.getHeaders().getContentLength();
		MediaType contentType = httpEntity.getHeaders().getContentType();
		logger.info(contentLength + "");
		logger.info(contentType.toString());
	}
	@RequestMapping("handle51")
	public ResponseEntity<User> handle51(HttpEntity<User> requestEntity) {
		User user = requestEntity.getBody();
		user.setId(100);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
