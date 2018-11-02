package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import MyIRule.MyIRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="microservicecloud-dept",configuration=MyIRule.class)
public class DeptComsumer80_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptComsumer80_App.class, args);
	}
}
