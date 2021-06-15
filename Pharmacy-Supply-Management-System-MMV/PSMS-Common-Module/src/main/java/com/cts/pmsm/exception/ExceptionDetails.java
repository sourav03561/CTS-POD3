package com.cts.pmsm.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExceptionDetails {

	public ExceptionDetails() {
		// TODO Auto-generated constructor stub
	}
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timeStamp;
	private HttpStatus status;
	private String message;
	
	
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}



	public HttpStatus getStatus() {
		return status;
	}



	public String getMessage() {
		return message;
	}



	public ExceptionDetails(LocalDateTime timeStamp, HttpStatus status, String message) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.message = message;
	}

}
