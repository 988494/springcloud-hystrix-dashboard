package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@GetMapping("/dept/get/{id}")
	@HystrixCommand(fallbackMethod="processHystrix_Get")	//注意processHystrix_Get()方法方法得返回类型要与get()方法得返回类型一致
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = deptService.get(id);
		if(dept == null) {
			throw new RuntimeException("该id："+id+"在数据库中查不到数据！");
		}
		return dept;
	}
	//注意processHystrix_Get()方法方法得返回类型要与get()方法得返回类型一致
	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		Dept dept = new Dept();
		dept.setDeptno(id);
		dept.setDname("该ID：" + id + "在数据库中查不到数据！");
		dept.setDb_source("数据库中没有此数据库！");
		return dept;
	}
}
