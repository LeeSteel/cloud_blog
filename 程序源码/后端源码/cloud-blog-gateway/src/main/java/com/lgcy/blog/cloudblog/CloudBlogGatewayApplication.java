package com.lgcy.blog.cloudblog;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class CloudBlogGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudBlogGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		//这里是请求转发
		return builder.routes()
				// basic proxy
				.route(r -> r.path("/azkaban")
						.uri("http://192.168.25.213:8081/index"))
				.build();
	}

   @RequestMapping("/baidu/test")
	public String doTest(){
      return "http://localhost:28760/baidu/test";
   }

}
