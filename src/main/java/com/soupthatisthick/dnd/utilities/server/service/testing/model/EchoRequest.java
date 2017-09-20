package com.soupthatisthick.dnd.utilities.server.service.testing.model;

import javax.validation.constraints.NotNull;

public class EchoRequest {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    @NotNull
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
