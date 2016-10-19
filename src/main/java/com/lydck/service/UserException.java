package com.lydck.service;

public class UserException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String code;
	private String message;
	public UserException(String code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
	public UserException(ErrorCode error) {
		this(error.getCode(), error.getMsg());
	}
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
}
