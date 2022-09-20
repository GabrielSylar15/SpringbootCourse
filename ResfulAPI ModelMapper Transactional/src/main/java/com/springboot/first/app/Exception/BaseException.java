package com.springboot.first.app.Exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {
	private Integer code;
	private String message;
	private HttpStatus httpStatus;

	public Integer getCode() {
		return code;
	}

	public BaseException(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public BaseException(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public BaseException(Integer code, String message, HttpStatus httpStatus) {
		super();
		this.code = code;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
