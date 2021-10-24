package com.farinas.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketApplication {

	public static void main(String[] args) {
		System.setProperty("user.timezone", "America/Managua");
		SpringApplication.run(MarketApplication.class, args);
	}

}
