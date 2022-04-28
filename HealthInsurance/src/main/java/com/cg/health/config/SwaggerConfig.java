package com.cg.health.config;

import org.springframework.context.annotation.Bean;
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
import static springfox.documentation.builders.PathSelectors.regex;



@Configuration
@EnableSwagger2
public class SwaggerConfig {



@Bean
public Docket empApi() {
return new Docket(DocumentationType.SWAGGER_2)
.apiInfo(apiInfo())
.select()
.apis(RequestHandlerSelectors.basePackage("com.cg.health.controller"))
//.paths(PathSelectors.ant("/emp").or(PathSelectors.ant("/dept")))
// .paths(PathSelectors.ant("/emp"))
//.paths(PathSelectors.ant("/dept"))
.paths(PathSelectors.any())
.build();
}


private ApiInfo apiInfo() {
return new ApiInfoBuilder()
.title("API")
.contact(new Contact("HealthInsurance","",""))
.version("1.0")
.description("API")
.build();
}
}
