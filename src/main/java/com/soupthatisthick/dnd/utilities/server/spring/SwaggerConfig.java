package com.soupthatisthick.dnd.utilities.server.spring;

import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final transient Logger LOG = LoggerFactory.getLogger(SwaggerConfig.class);

    @Bean
    public Docket api() {
        final Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
        docket.apiInfo(apiInfo());
        LOG.debug("Swagger docket: {}", JsonUtil.toJson(docket, true));
        return docket;
    }

    @Bean
    public ApiInfo apiInfo() {
        final ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Dungeons and Dragons Utilities Documentation")
                .description("Dungeons and Dragons Dashboard API Documentation")
                .version("1.0")
                .build();
        LOG.debug("Swagger api info: {}", JsonUtil.toJson(apiInfo, true));
        return apiInfo;
    }
}
