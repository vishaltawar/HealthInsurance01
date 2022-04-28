package com.cg.health.advice;

import java.time.LocalDateTime;
import java.util.logging.LogManager;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.health.exception.AdminAlreadyExistsException;
import com.cg.health.exception.AdminNotFoundException;
import com.cg.health.exception.ApiError;
import com.cg.health.exception.BadRequestException;
import com.cg.health.exception.PolicyAlreadyExistsException;
import com.cg.health.exception.PolicyNotFoundException;
import com.cg.health.exception.PolicyPurchaseAlreadyExistsException;
import com.cg.health.exception.PolicyPurchaseNotFoundException;
import com.cg.health.exception.PolicyUserAlreadyExistsException;
import com.cg.health.exception.PolicyUserNotFoundException;

import ch.qos.logback.classic.Logger;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
   
	private static final org.jboss.logging.Logger LOGGER = LoggerFactory.logger(GlobalExceptionHandler.class);
	@ExceptionHandler(PolicyNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handlePolicyNotFound(PolicyNotFoundException ex){
		LOGGER.error(ex.getMessage(),ex);
		return "Policy not found";
	}
	private static final org.jboss.logging.Logger LOGGER1 = LoggerFactory.logger(GlobalExceptionHandler.class);
	@ExceptionHandler(PolicyAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	@ResponseBody
	public String handlePolicyAlreadyExists(PolicyAlreadyExistsException e) {
		LOGGER1.error(e.getMessage(),e);
		return "Policy Already Exists";
	}
	private static final org.jboss.logging.Logger LOGGER2 = LoggerFactory.logger(GlobalExceptionHandler.class);
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleException(BadRequestException e) {
		LOGGER2.error(e.getMessage(),e);
		return "Wrong Request";
	}
	private static final org.jboss.logging.Logger LOGGER3 = LoggerFactory.logger(GlobalExceptionHandler.class);
	@ExceptionHandler(PolicyPurchaseNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handlePolicyPurchaseNotFoundException(PolicyPurchaseNotFoundException e) {
		LOGGER3.error(e.getMessage(),e);
		return "PolicyPurchase not found";
	}
	private static final org.jboss.logging.Logger LOGGER4 = LoggerFactory.logger(GlobalExceptionHandler.class);
	@ExceptionHandler(PolicyPurchaseAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	@ResponseBody
	public String handlePolicyPurchaseAlreadyExists(PolicyPurchaseAlreadyExistsException e) {
		LOGGER4.error(e.getMessage(),e);
		return "PolicyPurchase Already Exists";
}
	private static final org.jboss.logging.Logger LOGGER5 = LoggerFactory.logger(GlobalExceptionHandler.class);
	@ExceptionHandler(AdminAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	@ResponseBody
	public String handlePolicyAlreadyExists(AdminAlreadyExistsException e) {
		LOGGER5.error(e.getMessage(),e);
		return "Admin Already Exists";
}
	private static final org.jboss.logging.Logger LOGGER6 = LoggerFactory.logger(GlobalExceptionHandler.class);
	@ExceptionHandler(AdminNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handlePolicyNotFound(AdminNotFoundException ex){
		LOGGER6.error(ex.getMessage(),ex);
		return "Admin not found";
	}
	private static final org.jboss.logging.Logger LOGGER7 = LoggerFactory.logger(GlobalExceptionHandler.class);
	@ExceptionHandler(PolicyUserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handlePolicyUserNotFound(PolicyUserNotFoundException ex){
		LOGGER7.error(ex.getMessage(),ex);
		return "Policy User not found";
	}
	private static final org.jboss.logging.Logger LOGGER8 = LoggerFactory.logger(GlobalExceptionHandler.class);
	@ExceptionHandler(PolicyUserAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	@ResponseBody
	public String handlePolicyUserAlreadyExists(PolicyUserAlreadyExistsException e) {
		LOGGER8.error(e.getMessage(),e);
		return "Policy User Already Exists";
}
}
