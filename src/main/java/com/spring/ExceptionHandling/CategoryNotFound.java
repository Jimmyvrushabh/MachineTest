package com.spring.ExceptionHandling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
	public class CategoryNotFound extends RuntimeException {

		public CategoryNotFound(String msg) {
			super(msg);
			log.debug("Id is not Valid :: CATEGORYEXCEPTION");

		}


}
