package com.lgcy.blog.cloudblog.config;


import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @author: 李钢 2580704698@qq.com
 * @date: 2019/10/22 14:50
 * @Copyright: Copyright (c) 2019
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    /*
     * 定义分隔符,配置Swagger多包
     */
    private static final String splitor = ",";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //    .apis(RequestHandlerSelectors.basePackage("com.lgcy.blog.cloudblog.modules.sys.controller"))
                .apis(basePackage("com.lgcy.blog.cloudblog.modules.sys.controller" + splitor + "com.lgcy.blog.cloudblog.modules.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("云博客-权限管理系统-Swagger2 RESTFul API 文档")
                .description("")
                .termsOfServiceUrl("")
                .contact("李钢 陈冶")
                .version("1.0")
                .build();
    }

    /**
     * 重写basePackage方法，使能够实现多包访问，复制贴上去
     *
     * @param basePackage
     * @return com.google.common.base.Predicate<springfox.documentation.RequestHandler>
     * @author teavamc
     * @date 2019/1/26
     */
    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }
}
