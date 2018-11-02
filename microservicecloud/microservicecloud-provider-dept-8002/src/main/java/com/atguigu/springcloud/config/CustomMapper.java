package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class CustomMapper extends ObjectMapper{
//	public CustomMapper() {
//        // 设置 SerializationFeature.FAIL_ON_EMPTY_BEANS 为 false
//        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//    }
}
