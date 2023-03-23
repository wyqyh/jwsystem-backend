package com.ldsg.jwsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = {"com.ldsg.jwsystem.dao"})
@ImportResource(locations = {"classpath:config/kaptcha.xml"})
public class JwsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwsystemApplication.class, args);
	}

}
