package com.labs.spring.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CannotCreateTransactionException extends Exception {
	public CannotCreateTransactionException(String message) {
		super(message);
	}

}