package com.lgcy.blog.cloudblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 启动类
 * @author: 李钢 2580704698@qq.com
 * @date: 2019/8/18 21:27
 * @Copyright: Copyright (c) 2019
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudBlogRegisterCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudBlogRegisterCenterApplication.class, args);
    }

}
