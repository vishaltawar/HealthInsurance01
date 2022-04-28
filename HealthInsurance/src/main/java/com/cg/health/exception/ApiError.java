package com.cg.health.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;



public class ApiError {
 
	private String message;
	private HttpStatus status;
	private LocalDateTime timeStamp;
	public ApiError() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiError(String message, HttpStatus status, LocalDateTime timeStamp) {
		super();
		this.message = message;
		this.status = status;
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "ApiError [message=" + message + ", status=" + status + ", timeStamp=" + timeStamp + "]";
	}
	
}
 