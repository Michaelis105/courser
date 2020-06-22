package com.michael.courser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Starting point for initialization
 */
@SpringBootApplication
@EnableSwagger2
public class CourserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourserApplication.class, args);
	}

}
