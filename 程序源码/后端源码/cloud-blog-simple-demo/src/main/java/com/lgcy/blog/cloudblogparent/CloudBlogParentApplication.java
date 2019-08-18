package com.lgcy.blog.cloudblogparent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@ComponentScan(basePackages = { "com.lgcy.blog.cloudblogparent"})
public class CloudBlogParentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudBlogParentApplication.class, args);
    }

}
