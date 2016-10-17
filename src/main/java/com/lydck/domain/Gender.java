package com.lydck.domain;

/**
 * 性别
 * 
 * @author xiangyajun
 *
 */
public enum Gender {
	MALE(0, "MALE"), FEMALE(1, "FEMALE");

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

	public static int getGender(Gender describe) {
		return describe.gender;
	}

	public static Gender getEnum(String source) {
		if(source.equals(MALE.describe)) {
			return Gender.MALE;
		}
		if(source.equals(FEMALE.describe)) {
			return Gender.FEMALE;
		}
		return null;
	}
	public static Gender getEnum(Integer gender) {
		if(gender == Gender.MALE.gender) {
			return Gender.MALE;
		}
		if(gender == Gender.FEMALE.gender) {
			return Gender.FEMALE;
		}
		return null;
	}
}
