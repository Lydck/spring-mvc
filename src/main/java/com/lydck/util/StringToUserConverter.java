package com.lydck.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import com.lydck.domain.User;

public class StringToUserConverter implements Converter<String, User>{
	public User convert(String source) {
		User user = new User();
		if(StringUtils.isNotBlank(source)) {
			String[] items = source.split(":");
			user.setUsername(items[0]);
			user.setPassword(items[1]);
			user.setMobile(items[2]);
			return user;
		}
		return null;
	}
}
