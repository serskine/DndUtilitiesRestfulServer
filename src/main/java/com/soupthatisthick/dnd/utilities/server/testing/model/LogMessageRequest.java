package com.soupthatisthick.dnd.utilities.server.testing.model;

import com.soupthatisthick.dnd.utilities.server.common.model.messages.BaseRequest;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 * Created by Owner on 9/9/2017.
 */
public class LogMessageRequest extends BaseRequest {

    @NotNull
    private String message = "DEFAULT MESSAGE";

    @NotNull
    @Enumerated(EnumType.STRING)
    private LogLevel logLevel = LogLevel.DEBUG;

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
