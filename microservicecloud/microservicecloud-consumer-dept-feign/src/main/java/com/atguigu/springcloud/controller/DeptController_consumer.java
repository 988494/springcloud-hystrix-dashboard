package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;

@RestController 
public class DeptController_consumer {
	
	@Autowired
	private DeptClientService deptClientService;
	
	@PostMapping("/comsumer/dept/add")
	public Boolean add(Dept dept) {
		return deptClientService.add(dept);
	}
	
	@GetMapping("/comsumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return deptClientService.get(id);
	}
	
	@GetMapping("/comsumer/dept/list")
	public List<Dept> list() {
		return deptClientService.list();
	}
}
