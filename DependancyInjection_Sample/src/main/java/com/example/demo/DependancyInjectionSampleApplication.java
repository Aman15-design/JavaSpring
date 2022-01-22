package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DependancyInjectionSampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(DependancyInjectionSampleApplication.class, args);
		Customers c=context.getBean(Customers.class);
		c.display();
	}

}
