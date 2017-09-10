package com.soupthatisthick.dnd.utilities.server.service.testing.model;

import com.soupthatisthick.dnd.utilities.server.api.common.BaseRequest;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

/**
 * Created by Owner on 9/9/2017.
 */
public class LogMessageRequest extends BaseRequest {

    @NotEmpty
    private String message;

    @NotNull
    private LogLevel logLevel;

    @Nullable
    private Throwable throwable;

    // ------------------------------- GETTERS AND SETTERS ------------------------------- //

    public String getMessage() {
        return message;
    }

    public void setMessage(@NotEmpty String message) {
        this.message = message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Nullable
    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(@Nullable Throwable throwable) {
        this.throwable = throwable;
    }
}
