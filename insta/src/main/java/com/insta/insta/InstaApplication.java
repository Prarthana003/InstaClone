package com.insta.insta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InstaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstaApplication.class, args);
	}

	@GetMapping()
	public String apiRoot(){
		return "Hello World!";
	}

}
