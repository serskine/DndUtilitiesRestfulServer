package com.soupthatisthick.dnd.utilities.server.service.common;

/**
 * Created by Owner on 9/9/2017.
 */
public class ServiceException extends Exception {
    private final ErrorCode errorCode;

    public ServiceException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ServiceException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public final ErrorCode getErrorCode() {
        return errorCode;
    }
}
