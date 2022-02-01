package com.ecommerce.sports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsApplication.class, args);
		
		
	}

}
