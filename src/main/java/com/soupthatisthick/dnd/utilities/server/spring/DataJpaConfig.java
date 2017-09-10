package com.soupthatisthick.dnd.utilities.server.spring;

import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;
import com.soupthatisthick.dnd.utilities.server.util.logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Owner on 9/9/2017.
 */
@Configuration
@EnableTransactionManagement
@Profile(value = "primary-datasource")
public class DataJpaConfig {
    @Autowired
    private Environment env;

    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "datasource.primary")
    public DataSource primaryDataSource() {
        DataSource dataSource = DataSourceBuilder.create()
                .url(env.getProperty("spring.datasource.url"))
                .username(env.getProperty("spring.datasource.username"))
                .password(env.getProperty("spring.datasource.password"))
                .driverClassName(env.getProperty("spring.datasource.driver-class-name"))
                .build();

        Logger.debug("\n***\n*** Primary Data Source\n***\n" + JsonUtil.toJson(dataSource, true));

        if (dataSource==null) {
            Logger.warning("Failed to initialize the datasource!");
        }

        return dataSource;
    }

    @Bean(name="jdbcPrimaryTemplate")
    public JdbcTemplate jdbcPrimaryTemplate(@Qualifier(value="primaryDataSource") DataSource primaryDataSource) {
        return new JdbcTemplate(primaryDataSource);
    }
}
