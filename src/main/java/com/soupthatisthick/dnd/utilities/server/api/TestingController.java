package com.soupthatisthick.dnd.utilities.server.api;

import com.soupthatisthick.dnd.utilities.server.api.common.ApiResponse;
import com.soupthatisthick.dnd.utilities.server.service.testing.TestingService;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.EchoRequest;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.LogMessageRequest;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.ResetRequest;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.exception.TestingServiceException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.soupthatisthick.dnd.utilities.server.util.logger.Logger.LOG;


@SuppressWarnings({"unchecked", "SpringJavaAutowiredFieldsWarningInspection"})
@Api(description = "Testing Management Endpoint")
@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
class TestingController extends BaseApiController {

    @Autowired
    private TestingService testingService;

    @ApiOperation(value = "Request to log a message on the server with the specified log level (INFO, DEBUG, WARNING or ERROR)")
    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public ApiResponse logMessage(@Valid @RequestBody LogMessageRequest request) throws TestingServiceException {
        testingService.logMessageRequest(request);
        return new ApiResponse();
    }

    @ApiOperation(value = "Reset the data source by deleting all records and then initializing the records again.")
    @RequestMapping(value="/reset", method = RequestMethod.POST)
    public ApiResponse reset(@Valid @RequestBody ResetRequest request) throws TestingServiceException {
        testingService.resetDatabase();
        return new ApiResponse();
    }

    @ApiOperation(value = "Echo the response back to the user")
    @RequestMapping(value="/echo", method = RequestMethod.POST)
    public ApiResponse echo(@Valid @RequestBody EchoRequest request) {
        LOG.info("echo\n{}", request.getMessage());
        return new ApiResponse(testingService.echoResponse(request));
    }

    @ApiOperation(value = "Wipes all the database tables. Called before every test.")
    @RequestMapping(value="/wipe", method = RequestMethod.GET)
    public ApiResponse deleteAll() throws TestingServiceException {
        testingService.wipeDatabase();
        return new ApiResponse();
    }

    @ApiOperation(value = "Init the database. Assumes the database has been wiped already.")
    @RequestMapping(value="/init", method = RequestMethod.GET)
    public ApiResponse init() throws TestingServiceException {
        LOG.info("init");
        testingService.initDatabase();
        return new ApiResponse();
    }

}
