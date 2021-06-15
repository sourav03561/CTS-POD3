package com.cts.pmsm.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.exception.MedicineStockNotFoundException;
import com.cts.pmsm.model.ExceptionDetails;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ExceptionDetails> handleAuthorizationException(AuthorizationException ex){
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), HttpStatus.FORBIDDEN,ex.getMessage());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(MedicineStockNotFoundException.class)
	public ResponseEntity<ExceptionDetails> handleMedicineStockNotFoundException(MedicineStockNotFoundException ex){
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), HttpStatus.NOT_FOUND, ex.getMessage());
		return new ResponseEntity<>(exceptionDetail,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<ExceptionDetails> handleMissingRequestHeaderException(MissingRequestHeaderException ex){
		ExceptionDetails exceptionDetail = new ExceptionDetails(LocalDateTime.now(), HttpStatus.BAD_REQUEST,ex.getMessage());
		return new ResponseEntity<>(exceptionDetail, HttpStatus.BAD_REQUEST);
	}
	
}