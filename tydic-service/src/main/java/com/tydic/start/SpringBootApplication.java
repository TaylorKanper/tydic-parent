package com.tydic.start;

import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class SpringBootApplication {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringBootApplication.class,
				"classpath:spring/dubbo-provider.xml");
		application.run(args);
	}
}
