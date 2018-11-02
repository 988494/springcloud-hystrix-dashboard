package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.atguigu.springcloud.entities.Dept;

@FeignClient(value="microservicecloud-dept",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

	@GetMapping("/dept/get/{id}")
	public  Dept get(@PathVariable ("id")Long id);

	@GetMapping("/dept/list")
	 public List<Dept> list();
	
	 @PostMapping("/dept/add")
	public boolean add(Dept dept);
}
