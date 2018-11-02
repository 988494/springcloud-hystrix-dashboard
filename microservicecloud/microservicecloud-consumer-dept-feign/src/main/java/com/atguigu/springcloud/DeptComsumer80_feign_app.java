package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import FeignToIRule.FeignToIRule;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.atguigu.springcloud"})
@ComponentScan("com.atguigu.springcloud")
@RibbonClient(name="microservicecloud-dept",configuration=FeignToIRule.class)
public class DeptComsumer80_feign_app {
	public static void main(String[] args) {
		SpringApplication.run(DeptComsumer80_feign_app.class, args);
	}
}
