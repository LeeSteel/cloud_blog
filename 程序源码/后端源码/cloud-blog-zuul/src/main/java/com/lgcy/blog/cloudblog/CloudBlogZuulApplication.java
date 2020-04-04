package com.lgcy.blog.cloudblog;

import com.lgcy.blog.cloudblog.filter.AccessTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
@RestController
public class CloudBlogZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudBlogZuulApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "Hello Zuul";
    }

    /**
     * 加载过滤器
     * @return
     */
    @Bean
    public AccessTokenFilter accessFilter() {
        return new AccessTokenFilter();
    }
}
