package com.soupthatisthick.dnd.utilities.server.spring;

import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    private static final transient Logger LOG = LoggerFactory.getLogger(SwaggerConfig.class);

    @Bean
    public static PropertySourcesPlaceholderConfigurer swaggerProperties() {
        PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
        return properties;
    }

    @Bean
    public Docket api(){
        final Docket docket = new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
        docket.apiInfo(apiInfo());
        return docket;
    }

    private ApiInfo apiInfo() {
        final ApiInfo apiInfo = new ApiInfoBuilder()
                .title("SpringBoot REST API - Dungeons and Dragons Utilities")
                .description("Dungeons and Dragons Dashboard API Documentation")
                .version("1.0")
                .termsOfServiceUrl("Terms of Service")
                .contact(new Contact("Stuart Erskine","www.linkedin.com/in/stuartmarrerskine", "stuart.marr.erskine@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
        return apiInfo;
    }

}
