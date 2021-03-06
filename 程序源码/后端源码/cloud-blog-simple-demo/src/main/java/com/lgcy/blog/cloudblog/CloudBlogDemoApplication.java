package com.lgcy.blog.cloudblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 启动类
 * @author: 李钢 2580704698@qq.com
 * @date: 2019/8/18 21:27
 * @Copyright: Copyright (c) 2019
 */
@EnableSwagger2
@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient
@ComponentScan(basePackages = {"com.lgcy.blog.cloudblog"})
public class CloudBlogDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudBlogDemoApplication.class, args);
    }

}
