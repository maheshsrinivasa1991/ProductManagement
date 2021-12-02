package com.SpringBootExample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
	String message;
	public ResourceNotFoundException(String message) {
		this.message = message;	
	}
}
