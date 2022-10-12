package com.example.couponanddeals;

import com.example.service.CouponService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages={
		"com.example.service", "com.example.controller"})
@EnableEurekaClient
@EnableMongoRepositories("com.example.repository")
@ComponentScan(basePackages = "com.example.controller")
@ComponentScan(basePackages = "com.example.dto")
@ComponentScan(basePackages = "com.example.entity")
@ComponentScan(basePackages = "com.example.service")
public class CouponAndDealsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponAndDealsApplication.class, args);
	}

}
