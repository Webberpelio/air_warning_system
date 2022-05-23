package com.air_research.airwarningsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zwell
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean(value = "兰州")
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("兰州空气预警系统API", "兰州空气预警系统相关接口的文档"))
                .groupName("兰州API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.air_research.airwarningsystem.lanzhou.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean(value = "广州")
    public Docket guangzhouRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("广州空气预警系统API", "广州空气预警系统相关接口的文档"))
                .groupName("广州API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.air_research.airwarningsystem.guangzhou"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean(value = "哈尔滨")
    public Docket harbinRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("哈尔滨空气预警系统API", "哈尔滨空气预警系统相关接口的文档"))
                .groupName("哈尔滨API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.air_research.airwarningsystem.harbin"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean(value = "拉萨")
    public Docket lhasaRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("拉萨空气预警系统API", "拉萨空气预警系统相关接口的文档"))
                .groupName("拉萨API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.air_research.airwarningsystem.lhasa"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(String title, String description) {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
