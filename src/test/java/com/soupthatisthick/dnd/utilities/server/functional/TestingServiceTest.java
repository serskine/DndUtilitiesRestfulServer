package com.soupthatisthick.dnd.utilities.server.functional;


import com.soupthatisthick.dnd.utilities.server.testing.TestingService;
import com.soupthatisthick.dnd.utilities.server.testing.model.exception.TestingServiceException;
import com.soupthatisthick.dnd.utilities.server.util.BaseSpringBootTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertNotNull;

public class TestingServiceTest extends BaseSpringBootTest {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    @Autowired
    private TestingService testingService;

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    @Test
    public void testCleanup1() throws TestingServiceException {
        assertTestDataDoesNotExist();
        testingService.initDatabase();
    }

    @Test
    public void testCleanup2() throws TestingServiceException {
        assertTestDataDoesNotExist();
        testingService.initDatabase();
    }

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    private void assertTestDataDoesExist() {
        fail("There is no data in the testing service");
    }

    private void assertTestDataDoesNotExist() {
        AssertionError caught = null;
        try {
            assertTestDataDoesExist();
        } catch (AssertionError error) {
            caught = error;
        }
        assertNotNull(caught);
    }

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
