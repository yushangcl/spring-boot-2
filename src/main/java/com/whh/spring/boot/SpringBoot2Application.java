package com.whh.spring.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author log.r
 */
@SpringBootApplication
@EnableCaching
@MapperScan("com.whh.spring.boot.dao")
public class SpringBoot2Application {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(SpringBoot2Application.class);

        logger.info(">>>>> spring-boot 正在启动 <<<<<");
        SpringApplication.run(SpringBoot2Application.class, args);
        logger.info(">>>>> spring-boot 启动完成 <<<<<");

    }
}
