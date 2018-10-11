package com.hh.webcollect.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author hongbo.pan
 * @date 2018/10/11
 */
@Configuration
@EnableSwagger2
public class Swagger2Configurer {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hh.webcollect"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建api文档的详细信息函数
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("网页收藏夹API")
                //创建人
                .contact(new Contact("panhb", "http://panhb.github.io/", "panhongbo891010@gmail.com"))
                //版本号
                .version("1.0")
                //描述
                .description("网页收藏夹v1版本API")
                .build();
    }

}
