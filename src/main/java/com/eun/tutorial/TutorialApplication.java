package com.eun.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//public class TutorialApplication extends SpringBootServletInitializer{
public class TutorialApplication {
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(TutorialApplication.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);
	}

}
