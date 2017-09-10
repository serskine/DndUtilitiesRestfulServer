package com.soupthatisthick.dnd.utilities.server.api.common;

import com.soupthatisthick.dnd.utilities.server.service.common.BaseModel;
import org.springframework.http.HttpStatus;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 9/9/2017.
 */
public class ApiStatus extends BaseModel {

    @NotNull
    private HttpStatus statusCode;

    @NotNull
    private LocalDateTime timeStamp = LocalDateTime.now();

    @NotNull
    private String message = "";

    @Nullable
    private String errorCode;

    private List<FieldError> validationErrors = new ArrayList<>();

    public ApiStatus() {
        statusCode = HttpStatus.OK;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<FieldError> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<FieldError> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
