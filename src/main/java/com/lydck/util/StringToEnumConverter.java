package com.lydck.util;

import org.springframework.core.convert.converter.Converter;

import com.lydck.domain.Gender;

public class StringToEnumConverter implements Converter<String, Gender> {

	@Override
	public Gender convert(String source) {
		if (source == null)
			return null;
		return Gender.genGender(source);
	}
	
	public static void main(String[] args) {
		StringToEnumConverter convert2 = new StringToEnumConverter();
		Gender convert = convert2.convert("MALE");
		System.out.println(convert);
	}
}
