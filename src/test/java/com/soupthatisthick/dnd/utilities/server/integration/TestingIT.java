package com.soupthatisthick.dnd.utilities.server.integration;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.soupthatisthick.dnd.utilities.server.api.common.ApiResponse;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.LogLevel;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.LogMessageRequest;
import com.soupthatisthick.dnd.utilities.server.util.AssertUtil;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

import javax.validation.constraints.NotNull;

import static org.springframework.http.HttpStatus.OK;

public class TestingIT extends BaseIT {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    @Test
    public void testLogRequest() throws UnirestException {

        for(LogLevel logLevel : LogLevel.values()) {
            ApiResponse apiResponse = sendLogMessage(
                logLevel,
                "Log message for " + logLevel.name() + "."
            );
            AssertUtil.assertResponseStatus(apiResponse, OK);
        }
    }

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    private ApiResponse sendLogMessage(@NotNull LogLevel logLevel, @NotEmpty String message) throws UnirestException {
        LogMessageRequest request = new LogMessageRequest();
        request.setLogLevel(logLevel);
        request.setMessage(message);

        return sendRequest(request, "test/log");
    }

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
