package com.spring.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping("/test")
	public String Testing() {
		System.out.println("testing");
		return "Testing";
	}

}
