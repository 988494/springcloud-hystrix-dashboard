package com.atguigu.springcloud.service;

import java.util.List;

import com.atguigu.springcloud.entities.Dept;

public interface DeptService {
	
	 boolean addDept(Dept dept);

	 Dept get(Long id);

	 List<Dept> list();
}
