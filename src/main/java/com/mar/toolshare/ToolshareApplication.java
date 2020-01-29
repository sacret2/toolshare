package com.mar.toolshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = {"com.mar.toolshare"})
public class ToolshareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolshareApplication.class, args);
	}

}
