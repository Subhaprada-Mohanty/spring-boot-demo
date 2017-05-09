package com.ncr.test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@ComponentScan
public class Example {

	public static void main(String[] args) {
		
		SpringApplication.run(Example.class, args);
	}

}


