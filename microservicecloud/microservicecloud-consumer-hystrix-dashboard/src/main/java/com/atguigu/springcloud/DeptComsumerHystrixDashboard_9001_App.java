package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard//开启服务监控（Hystrix dashboard）
public class DeptComsumerHystrixDashboard_9001_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptComsumerHystrixDashboard_9001_App.class, args);
	}
}
