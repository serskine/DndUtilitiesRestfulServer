package com.soupthatisthick.dnd.utilities.server.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import static com.soupthatisthick.dnd.utilities.server.util.logger.Logger.LOG;

/**
 * Created by Owner on 9/9/2017.
 */
@Configuration
@EnableTransactionManagement
@Profile(value = "inMemory-datasource")
public class DataJpaConfigInMemoryDataSource {

    @Autowired
    private Environment env;

    @Bean(name = "inMemoryDataSource")
    public DataSource inMemoryDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.HSQL)
                .build();

        if (db==null) {
            LOG.warning("Failed to initialize the in-memory data source!");
        } else {
            LOG.info("Initialized in-memory DB.");
            return db;
        }

        return db;
    }
}
