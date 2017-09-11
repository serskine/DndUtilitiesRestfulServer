package com.soupthatisthick.dnd.utilities.server.integration;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.soupthatisthick.dnd.utilities.server.api.common.ApiResponse;
import com.soupthatisthick.dnd.utilities.server.api.common.ApiStatus;
import com.soupthatisthick.dnd.utilities.server.api.common.BaseRequest;
import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;
import com.soupthatisthick.dnd.utilities.server.util.logger.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.validation.constraints.NotNull;

import static com.soupthatisthick.dnd.utilities.server.util.AssertUtil.assertHttpResponseStatus;

public class BaseIT {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    private static final int PORT = 8000;
    private static final String SERVER = String.format("http://localhost:%d/", PORT);

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    private void logHttpResponse(@NotNull HttpResponse<String> response) {
        Logger.info("----- Http Response ------", 1);
        Logger.info("Status:      " + response.getStatus(), 1);
        Logger.info("Status Text: " + response.getStatusText(), 1);
        Logger.info(response.getBody());
        Logger.info("--------------------------", 1);
    }

    private void logRequest(@NotNull BaseRequest request) {
        Logger.info("------ Api Request -------", 1);
        Logger.info("Request Class: " + request.getClass().getSimpleName());
        Logger.info("\n" + JsonUtil.toJson(request, true));
        Logger.info("--------------------------", 1);
    }

    protected final void logApiResponse(@NotNull ApiResponse apiResponse) {
        ApiStatus status = apiResponse.getStatus();
        HttpStatus httpStatus = status.getStatusCode();
        String jsonText = JsonUtil.toJson(status, true);
        Logger.info("------ Api Response ------", 1);
        Logger.info("Http Status:       " + httpStatus.name() + " (" + httpStatus.value() + ")", 1);
        Logger.info("Status Code:       " + status.getStatusCode(), 1);
        Logger.info("Status error code: " + status.getErrorCode(), 1);
        Logger.info("Status message:    " + status.getMessage(), 1);
        Logger.info("Data: " + ((jsonText != null && jsonText.contains("\n")) ? "\n" : "") + jsonText, 1);
        Logger.info("--------------------------", 1);
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
