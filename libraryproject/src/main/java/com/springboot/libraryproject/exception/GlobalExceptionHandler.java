package com.springboot.libraryproject.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.springboot.libraryproject.entity.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {

	//Resource Not Found Exception Handler:
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException (ResourceNotFoundException ex, WebRequest request)
	{	ErrorDetails error = new ErrorDetails(new Date(), ex.getMessage());
	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//Global Exception Handler:
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException (Exception ex, WebRequest request)
	{
		ErrorDetails error = new ErrorDetails(new Date(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
