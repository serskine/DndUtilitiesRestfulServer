package com.soupthatisthick.dnd.utilities.server.integration;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.soupthatisthick.dnd.utilities.server.api.common.ApiResponse;
import com.soupthatisthick.dnd.utilities.server.api.common.ApiStatus;
import com.soupthatisthick.dnd.utilities.server.api.common.BaseRequest;
import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.validation.constraints.NotNull;

import static com.soupthatisthick.dnd.utilities.server.util.AssertUtil.assertHttpResponseStatus;
import static com.soupthatisthick.dnd.utilities.server.util.logger.Logger.LOG;

public class BaseIT {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    private static final int PORT = 8000;
    private static final String SERVER = String.format("http://localhost:%d/", PORT);

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    private void logHttpResponse(@NotNull HttpResponse<String> response) {
        LOG.info("----- Http Response ------");
        LOG.info("Status:      " + response.getStatus());
        LOG.info("Status Text: " + response.getStatusText());
        LOG.info(response.getBody());
        LOG.info("--------------------------");
    }

    private void logRequest(@NotNull BaseRequest request) {
        LOG.info("------ Api Request -------");
        LOG.info("Request Class: " + request.getClass().getSimpleName());
        LOG.info("\n" + JsonUtil.toJson(request, true));
        LOG.info("--------------------------");
    }

    protected final void logApiResponse(@NotNull ApiResponse apiResponse) {
        ApiStatus status = apiResponse.getStatus();
        HttpStatus httpStatus = status.getStatusCode();
        String jsonText = JsonUtil.toJson(status, true);
        LOG.info("------ Api Response ------");
        LOG.info("Http Status:       " + httpStatus.name() + " (" + httpStatus.value() + ")");
        LOG.info("Status Code:       " + status.getStatusCode());
        LOG.info("Status error code: " + status.getErrorCode());
        LOG.info("Status message:    " + status.getMessage());
        LOG.info("Data: " + ((jsonText != null && jsonText.contains("\n")) ? "\n" : "") + jsonText);
        LOG.info("--------------------------");
    }

    /**
     * This is used to send a base request to an endpoint via post.
     * @param request contains the relevant information we will send in the body
     * @param endPoint is the location expected to receive the request.
     * @return an {@link ApiResponse}
     * @throws UnirestException is we could not reach the server.
     */
    protected final ApiResponse sendRequest(@NotNull BaseRequest request, @NotNull String endPoint) throws UnirestException {

        logRequest(request);

        String requestBodyAsJson = JsonUtil.toJson(request, true);

        HttpResponse<String> response = Unirest.post(SERVER + endPoint)
                .header("content-type", MediaType.APPLICATION_JSON_VALUE)
                .body(requestBodyAsJson)
                .asString();

        logHttpResponse(response);

        assertHttpResponseStatus(response, HttpStatus.OK);

        ApiResponse apiResponse = JsonUtil.toObject(response.getBody(), ApiResponse.class);

        logApiResponse(apiResponse);

        return apiResponse;
    }

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
