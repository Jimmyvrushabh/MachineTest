package com.spring.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	
	
	@ExceptionHandler(value = CategoryNotFound.class)
	public ResponseEntity<?> handleCategoryNotFoundException(CategoryNotFound msg) {

		return new ResponseEntity(msg.getMessage(), HttpStatus.NOT_FOUND);
	}

}
