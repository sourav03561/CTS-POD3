package com.cts.pmsm.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity handleAuthorizationException(AuthorizationException ex){
		//log.error(ex.getMessage());
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity handleMissingRequestHeaderException(MissingRequestHeaderException ex){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}