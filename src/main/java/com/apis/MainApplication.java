package com.apis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.apis.repository")
@SpringBootApplication
public class MainApplication {
	  public static void main(String[] args) {
	        SpringApplication.run(MainApplication.class, args);
	    }

}
