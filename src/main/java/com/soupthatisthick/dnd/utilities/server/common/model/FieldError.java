package com.soupthatisthick.dnd.utilities.server.common.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Owner on 9/9/2017.
 */
public class FieldError {

    @NotEmpty
    private String code;

    @NotEmpty
    private String rejectedValue;

    @NotEmpty
    private String message;

    @NotEmpty
    private String field;

    // ------------------------------- GETTERS AND SETTERS ------------------------------- //

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(String rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
