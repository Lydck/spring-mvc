package com.lydck.service;

public enum ErrorCode {
	/** 参数错误 */
	E0001("E0001", "参数错误"),
	/** 用户名不能为空且长度在6到25之间 */
	E0002("E0002", "用户名不能为空且长度在6到25之间"),
	/** 密码不能为空且长度至少为6*/
	E0003("E0003", "密码不能为空且长度至少为6");
	
	private ErrorCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	private String code;
	private String msg;
	
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
}
