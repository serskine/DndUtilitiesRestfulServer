package com.soupthatisthick.dnd.utilities.server.service.common;

/**
 * Created by Owner on 9/9/2017.
 */
public enum ErrorCode {
    UNKNOWN_ERROR                           (ServiceId.UNKNOWN,     0),
    TESTING_LOG_LEVEL_REQUIRED              (ServiceId.TESTING,     1)
    ;

    private ServiceId serviceId;
    private int errorId;
    private String code;

    ErrorCode(ServiceId serviceId, int errorId) {
        this.serviceId = serviceId;
        this.errorId = errorId;
        this.code = String.format("%2d-%2d", serviceId.getValue(), errorId);
    }

    @Override
    public final String toString() {
        return code;
    }

    public final ServiceId getServiceId() {
        return serviceId;
    }

    public final int getErrorId() {
        return errorId;
    }
}
