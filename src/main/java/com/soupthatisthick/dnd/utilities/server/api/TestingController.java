package com.soupthatisthick.dnd.utilities.server.api;

import com.soupthatisthick.dnd.utilities.server.api.common.ApiResponse;
import com.soupthatisthick.dnd.utilities.server.service.testing.TestingService;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.LogMessageRequest;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.exception.TestingServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by Owner on 9/9/2017.
 */
@Api(description = "Provided a testing component to interact and initialize the server with")
@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestingController extends BaseApiController {

    @Autowired
    private TestingService testingService;

    @ApiOperation(value = "Request to log a message on the server with the specified log level (INFO, DEBUG, WARNING or ERROR)")
    @Autowired
    public ApiResponse logRequestMessage(@NotNull @Valid LogMessageRequest request) throws TestingServiceException {
        testingService.logMessageRequest(request);
        return new ApiResponse();
    }

}
