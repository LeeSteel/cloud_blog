package com.lgcy.blog.cloudblog;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.lgcy.blog.cloudblog"})
public class CloudBlogAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudBlogAdminApplication.class, args);
    }



}
