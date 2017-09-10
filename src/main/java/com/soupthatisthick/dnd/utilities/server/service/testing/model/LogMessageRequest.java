package com.soupthatisthick.dnd.utilities.server.service.testing.model;

import com.soupthatisthick.dnd.utilities.server.api.common.BaseRequest;
import org.hibernate.validator.constraints.NotEmpty;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

/**
 * Created by Owner on 9/9/2017.
 */
public class LogMessageRequest extends BaseRequest {

    @NotNull
    private String message;

    @NotNull
    private LogLevel logLevel;

    // ------------------------------- GETTERS AND SETTERS ------------------------------- //

    public String getMessage() {
        return message;
    }

    public void setMessage(@NotNull String message) {
        this.message = message;
    }
    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(@NotNull LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
