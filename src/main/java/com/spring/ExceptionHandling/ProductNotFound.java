package com.spring.ExceptionHandling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductNotFound extends RuntimeException {

	public ProductNotFound(String msg) {
		super(msg);
		log.debug("PrductNotFoundException occures :: ");

	}

}
