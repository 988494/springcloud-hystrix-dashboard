# Hystrix dashborad服务监控

## 配置：
	windows中配置host文件中的域名解析，在C:\Windows\System32\drivers\etc\HOSTS中添加如下配置<br>
	127.0.0.1 eureka7001.com<br>
	127.0.0.1 eureka7002.com<br>
	127.0.0.1 eureka7003.com<br>
## 数据库脚本：
```clouddb01```:
DROP TABLE IF EXISTS `dept`;<br>
CREATE TABLE `dept` (<br>
  `deptno` bigint(20) NOT NULL AUTO_INCREMENT,<br>
  `dname` varchar(60) DEFAULT NULL,<br>
  `db_source` varchar(60) DEFAULT NULL,<br>
  PRIMARY KEY (`deptno`)<br>
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;<br>
<br>

## 启动顺序：<br>
	1.首先启动eureka集群：microservicecloud-eureka-7001、microservicecloud-eureka-7002、microservicecloud-eureka-7003<br>
	2.然后启动带有熔断功能得服务提供者microservicecloud-provider-dept-hystrix-8001
	3.最后服务监控：microservicecloud-consumer-hystrix-dashboard<br>
	其中microservicecloud为所有服模块的父工程，microservicecloud-api是公共模块<br>
	其他微服务不用管<br>
	<br>
## 注意问题（非常重要）：
第一：那个服务被监控，则需要加入这个依赖
actuator监控信息完善
<dependency><br>
<groupId>org.springframework.boot</groupId><br>
<artifactId>spring-boot-starter-actuator</artifactId><br>
</dependency><br>

第二：springcloud2.0以后xxx/hystrix.stream以后没反应，需要再被监控的服务中配置servletl来拦截/hystrix.stream<br/>
参考网址：https://blog.csdn.net/ddxd0406/article/details/79643059
## 结果呈现：
	访问:<br>
    先访问数据库中有数据id：http://localhost:8001/dept/get/id   如http://localhost:8001/dept/get/1<br>
    能正常访问<br>
    访问hystrix服务监控：http://localhost:9001/hystrix（默认microservicecloud-consumer-hystrix-dashboard服务的端口号+/hystrix）<br>
    访问每个被监控的服务ping数据：（这里开启的被监控的是microservicecloud-provider-dept-hystrix-8001）<br>
      既访问->http://localhost:8001/hystrix.stream<br>
    再 访问hystrix服务监控：http://localhost:9001/hystrix中输入http://localhost:8001/hystrix.stream,Delay与titile选项随便填写,<br>
    点击按钮,就进去到microservicecloud-provider-dept-hystrix-8001这个微服务的服务监控界面上去了！<br>
	eureka服务注册中心：http://eureka7001.com:7001、http://eureka7002.com:7002、http://eureka7003.com:7003<br>
