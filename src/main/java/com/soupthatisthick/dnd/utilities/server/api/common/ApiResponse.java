package com.soupthatisthick.dnd.utilities.server.api.common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.soupthatisthick.dnd.utilities.server.service.common.BaseModel;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Owner on 9/9/2017.
 */
public class ApiResponse<A extends Serializable> extends BaseModel {

    @NotNull
    private ApiStatus status;

    @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
    private A data = null;

    public ApiResponse() {
        status = new ApiStatus();
    }

    public ApiResponse(A data) {
        this();
        this.data = data;
    }

    public ApiResponse(@NotNull ApiStatus status) {
        this();
        this.status = status;
    }

    public ApiResponse(A data, @NotNull ApiStatus status) {
        this();
        this.status = status;
        this.data = data;
    }

    // ------------------------------- GETTERS AND SETTERS ------------------------------- //

    public ApiStatus getStatus() {
        return status;
    }

    public void setStatus(ApiStatus status) {
        this.status = status;
    }

    public A getData() {
        return data;
    }

    public void setData(A data) {
        this.data = data;
    }
}
