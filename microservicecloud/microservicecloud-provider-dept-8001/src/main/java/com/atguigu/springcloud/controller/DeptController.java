package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;



@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;
	@Autowired
	private DiscoveryClient client;
	
	@PostMapping("/dept/add")
	public boolean add(@RequestBody Dept dept) {
		return deptService.addDept(dept);
	}
	
	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable Long id) {
		Dept dept = deptService.get(id);
		return dept;
	}
	@GetMapping("/dept/list")
	public List<Dept>  list() {
		List<Dept> list = deptService.list();
		return list;
	}
	
	@GetMapping("/dept/discovery")
	public Object  disconvery() {
		List<String> list = client.getServices();
		System.out.println("------"+list);
		
		List<ServiceInstance> instances = client.getInstances("microservicecloud-dept");
		for(ServiceInstance s:instances) {
			System.out.println(s.getServiceId()+"\t"+s.getHost()+"\t"+s.getPort()+"\t"+s.getUri());
		}
		return this.client;
	}
}
