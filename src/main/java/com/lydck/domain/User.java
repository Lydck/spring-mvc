package com.lydck.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lydck.util.ParamValiAnno;
import com.lydck.util.RegexType;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	@ParamValiAnno(nullable = false, minLength = 6, maxLength = 25, description = "用户名不能为空且长度在6到25之间")
	private String username;
	@ParamValiAnno(nullable = false, minLength = 6, description = "密码不能为空且长度至少为6")
	private String password;
	private Gender gender;
	private String mobile;
	@ParamValiAnno(regexType = RegexType.EMAIL, description = "邮箱格式")
	private String email;
	private int score;
	private Date lastLoginTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
