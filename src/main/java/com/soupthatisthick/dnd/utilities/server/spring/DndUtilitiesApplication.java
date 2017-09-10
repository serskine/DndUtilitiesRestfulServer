package com.soupthatisthick.dnd.utilities.server.spring;


import de.codecentric.boot.admin.config.EnableAdminServer;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.util.concurrent.Executor;

/**
 * Created by Owner on 9/9/2017.
 */
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableJpaRepositories({"com.soupthatisthick.encounterbuilder.server.dnd.utilities.server.data.jpa.*"})
@EntityScan({"com.soupthatisthick.encounterbuilder.server.dnd.utilities.server.data.jpa.*"})
@ComponentScan({"com.soupthatisthick.encounterbuilder.server.dnd.utilities.server.*"})
@PropertySources({
        @PropertySource("classpath:/com/soupthatisthick/encounterbuilder/server/dnd/utilities/server/config/application.properties"),
        @PropertySource(value = "classpath:/com/soupthatisthick/encounterbuilder/server/dnd/utilities/server/config/application-test.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "file:/opt/dnd-utilities-server/config/application-test.properties", ignoreResourceNotFound = true)
})
@EnableAdminServer
@EnableAsync
public class DndUtilitiesApplication extends SpringBootServletInitializer {

    @Autowired
    private DataSource primaryDataSource;

    public static void main(String[] args) {
        SpringApplication.run(DndUtilitiesApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DndUtilitiesApplication.class);
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
        liquibase.setChangeLog("classpath:/db/changelog/liquibase-changeLog.xml");
        liquibase.setDataSource(dataSource());
        return liquibase;
    }

    @Bean(name = "datasource")
    public DataSource dataSource() {
        return primaryDataSource;
    }
}



