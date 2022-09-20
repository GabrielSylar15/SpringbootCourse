package com.springboot.first.app.Exception;

import org.springframework.http.HttpStatus;

public class NotFoundItemException extends BaseException{
	public NotFoundItemException(String message) {
		super(HttpStatus.NO_CONTENT, message);
	}
}
