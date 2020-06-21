package com.michael.courser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Starting point for initialization
 */
@SpringBootApplication(scanBasePackages = {"com.michael.courser.controller", "com.michael.courser.dao", "com.michael.courser.model", "com.michael.courser.service"})
@EnableScheduling
@EnableCaching
public class CourserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourserApplication.class, args);
	}

}
