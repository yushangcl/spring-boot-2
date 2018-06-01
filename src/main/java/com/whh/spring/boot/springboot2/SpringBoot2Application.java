package com.whh.spring.boot.springboot2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2Application {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(SpringBoot2Application.class);

		logger.info(">>>>> spring-boot 正在启动 <<<<<");
		SpringApplication.run(SpringBoot2Application.class, args);
		logger.info(">>>>> spring-boot 启动完成 <<<<<");

	}
}
