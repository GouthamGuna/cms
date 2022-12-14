package com.cerp.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = ("com.cerp.springboot.model"))
public class DemoCmsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoCmsApplication.class, args);
		System.out.println("Spring Boot Application Start...");
	}
	
}
