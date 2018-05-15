package com.soupthatisthick.dnd.utilities.server.api.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.soupthatisthick.dnd.utilities.server.service.common.base.BaseModel;
import io.swagger.annotations.ApiModelProperty;
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
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            locale = "en_CA",
            timezone = "AST"
    )
//    @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
    private LocalDateTime timeStamp = LocalDateTime.now();

    @NotNull
    private String message = "";

    @Nullable
    private String errorCode;

    @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
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
