package com.graduation.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 //启用在线接口文档
public class Swagger2Config {
    //添加摘要信息
    @Bean
    public Docket controllerApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("毕业设计：学生选课系统_接口文档")
                        .description("用于管理后端开发的接口")
                        .version("0.0.1")
                        .build()).select()
                .apis(RequestHandlerSelectors.basePackage("com.graduation.demo"))
                .paths(PathSelectors.any())
                .build();
    }
}
