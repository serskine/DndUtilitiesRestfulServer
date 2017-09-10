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

import javax.validation.constraints.NotNull;

import static com.soupthatisthick.dnd.utilities.server.util.AssertUtil.assertHttpResponseStatus;
import static com.soupthatisthick.dnd.utilities.server.util.AssertUtil.assertResponseStatus;

public class BaseIT {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    protected static final int PORT = 8000;
    protected static final String SERVER = String.format("http://localhost:%d/", PORT);

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    protected final void logResponse(@NotNull HttpResponse<String> response) {
        Logger.info("Response: " + response.getStatus());
        Logger.json(response.getStatusText());
        Logger.json(response.getBody());
    }

    protected final void logRequest(@NotNull BaseRequest request) {
        Logger.info("Request: " + request.getClass().getSimpleName());
        Logger.json(request);
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
        HttpResponse<String> response = Unirest.post(SERVER + endPoint).asString();

        logResponse(response);

        String prettyBody = JsonUtil.prettyPrintUglyJsonString(response.getBody());
        Logger.info(prettyBody);

        assertHttpResponseStatus(response, HttpStatus.OK);
        ApiResponse apiResponse = JsonUtil.toObject(response.getBody(), ApiResponse.class);

        return JsonUtil.toObject(response.getBody(), ApiResponse.class);
    }

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
