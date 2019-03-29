package com.rscart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class RsCartShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsCartShopApplication.class, args);
	}

}
