package com.cachingtut.learningcaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class LearningcachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningcachingApplication.class, args);
	}

}
