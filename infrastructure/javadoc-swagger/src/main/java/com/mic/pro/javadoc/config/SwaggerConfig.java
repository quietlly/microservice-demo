package com.mic.pro.javadoc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@RefreshScope
public class SwaggerConfig {

    @Value("${swagger.basePackage}")
    private String basePackage = "com.mic.pro.service";

    @Value("${swagger.title}")
    private String title = "RESTFUL API";

    @Value("${swagger.description}")
    private String description = "";

    @Value("${swagger.version}")
    private String version = "";

    public String teamPage = "https://github.com/quietlly";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title(title)
                        .description(description)
                        .termsOfServiceUrl(teamPage)
                        .version(version)
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }
}
