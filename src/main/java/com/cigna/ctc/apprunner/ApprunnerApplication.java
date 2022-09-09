package com.cigna.ctc.apprunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.cigna.ctc.apprunner"}) 
public class ApprunnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApprunnerApplication.class, args);
	}

}
