package com.soupthatisthick.dnd.utilities.server.util;

import com.soupthatisthick.dnd.utilities.server.service.testing.TestingService;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.exception.TestingServiceException;
import com.soupthatisthick.dnd.utilities.server.spring.DndUtilitiesApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DndUtilitiesApplication.class)
public abstract class BaseSpringBootTest {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Autowired
    protected TestingService testingService;

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    @Before
    public void cleanUpDatabase() throws TestingServiceException {
        testingService.cleanDatabase();
    }

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
