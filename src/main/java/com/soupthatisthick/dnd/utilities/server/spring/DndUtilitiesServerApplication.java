package com.soupthatisthick.dnd.utilities.server.spring;


import com.soupthatisthick.dnd.utilities.server.util.podam.ResourceUtil;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Executor;

import static com.soupthatisthick.dnd.utilities.server.util.logger.Logger.LOG;

/**
 * Created by Owner on 9/9/2017.
 */
//@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableJpaRepositories({"com.soupthatisthick.dnd.utilities.server.data.jpa.*"})
@EntityScan({"com.soupthatisthick.dnd.utilities.server.data.jpa.*"})
@ComponentScan({"com.soupthatisthick.dnd.utilities.server.*"})
@PropertySources({
        @PropertySource("classpath:/com/soupthatisthick/dnd/utilities/server/config/application.properties"),
        @PropertySource(value = "classpath:/com/soupthatisthick/dnd/utilities/server/config/application-test.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "document:/opt/dnd-utilities-server/config/application-test.properties", ignoreResourceNotFound = true)
})
//@EnableAsync
//@EnableAspectJAutoProxy(proxyTargetClass = false)
public class DndUtilitiesServerApplication extends SpringBootServletInitializer implements InitializingBean {
    private static final String RESOURCE_PATH = "/com/soupthatisthick/dnd/utilities/server/";

    @Autowired
    private DataSource primaryDataSource;

    public static void main(String[] args) throws UnsupportedEncodingException {
        SpringApplication.run(DndUtilitiesServerApplication.class, args);
        String banner = ResourceUtil.readResourceIntoString(RESOURCE_PATH + "/config/banner.txt");
        LOG.debug("\n{}", banner);
        LOG.debug("Swagger URL: http://localhost:8000/swagger-ui.html");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DndUtilitiesServerApplication.class);
    }

    @Bean
    public WebMvcConfigurer enableCors() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry corsRegistry) {
                corsRegistry.addMapping("/**");
            }
        };
    }

    @Bean(name = "ThreadPoolTaskExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(1);
        executor.setQueueCapacity(500);
        executor.initialize();
        return executor;
    }

    @Bean(name = "liquibase")
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:/db.changelog/liquibase-changeLog.xml");
        liquibase.setDataSource(dataSource());
        LOG.info("Created liquibase for database versioning management.");
        return liquibase;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        return primaryDataSource;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("Initializing applications after properties have been set.");
    }
}



