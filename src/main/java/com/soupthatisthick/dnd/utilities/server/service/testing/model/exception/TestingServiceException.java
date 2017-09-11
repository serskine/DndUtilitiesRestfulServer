package com.soupthatisthick.dnd.utilities.server.service.testing.model.exception;

import com.soupthatisthick.dnd.utilities.server.service.common.base.ErrorCode;
import com.soupthatisthick.dnd.utilities.server.service.common.base.ServiceException;

/**
 * Created by Owner on 9/9/2017.
 */
public class TestingServiceException extends ServiceException {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    // Constructors ----------------------------------------------------------- Constructors //

    public TestingServiceException(ErrorCode errorCode) {
        super(errorCode);
    }

    public TestingServiceException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public TestingServiceException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    // Public Methods ------------------------------------------------------- Public Methods //

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
