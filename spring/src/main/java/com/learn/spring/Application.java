package com.learn.spring;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {
	Logger logger = LoggerFactory.getLogger(ILoggerFactory.class);
	@RequestMapping("/hello")
	String handleRequest() {
		logger.trace("\nProcessing handle request");
		return "hello world!";
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
