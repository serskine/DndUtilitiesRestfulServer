package com.soupthatisthick.dnd.utilities.server.service.common;

/**
 * Created by Owner on 9/9/2017.
 */
public enum ServiceId {
    UNKNOWN (0),
    TESTING (1);

    private int value;

    ServiceId(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%2d", value);
    }

    public int getValue() {
        return value;
    }
}
