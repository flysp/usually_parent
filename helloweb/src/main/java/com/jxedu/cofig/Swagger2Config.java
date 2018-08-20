package com.jxedu.cofig;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableWebMvc
@EnableSwagger2
public class Swagger2Config {


    @Bean
    public Docket createDocker() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation((ApiOperation.class)))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("spring mvc 中使用swagger2 构建 RESTful API")
                .termsOfServiceUrl("http://localhost")
                .description("测试中的构建")
                .version("1.0")
                .build();
    }
}
