package com.soupthatisthick.dnd.utilities.server.util;

import com.soupthatisthick.dnd.utilities.server.service.testing.TestingService;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.exception.TestingServiceException;
import com.soupthatisthick.dnd.utilities.server.spring.DndUtilitiesServerApplication;
import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DndUtilitiesServerApplication.class)
public abstract class BaseSpringBootTest {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    private static final transient Logger LOG = LoggerFactory.getLogger(BaseSpringBootTest.class);

    @Autowired
    protected TestingService testingService;

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    @Before
    public void cleanUpDatabase() throws TestingServiceException {
        testingService.wipeDatabase();
    }

    // Protected Methods ------------------------------------------------- Protected Methods //

    protected static final void titleLog(@NotNull String title, Serializable body) {
        LOG.debug("\n___ {} ___\n{}\n", title, JsonUtil.toJson(body, true));
    }

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
