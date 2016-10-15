package com.lydck.domain;

/**
 * 性别
 * @author xiangyajun
 *
 */
public enum Gender {
	MALE(0, "男"),
	FEMALE(1, "女");
	
	private int gender;
	private String describe;
	private Gender(int gender, String describe) {
		this.gender = gender;
		this.describe = describe;
	}
	public int gender() {
		return gender;
	}
	public String describe() {
		return describe;
	}
}
