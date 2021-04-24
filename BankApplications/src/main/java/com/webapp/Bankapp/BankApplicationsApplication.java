package com.webapp.Bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.webapp.Bankapp")
public class BankApplicationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplicationsApplication.class, args);
		System.out.println("Hello ");
		if(1 > 2) {
		  //abc
		  //do add
		  //do sub
		}
	}

}
