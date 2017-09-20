package com.soupthatisthick.dnd.utilities.server.api;

import com.soupthatisthick.dnd.utilities.server.api.common.ApiResponse;
import com.soupthatisthick.dnd.utilities.server.api.common.ApiStatus;
import com.soupthatisthick.dnd.utilities.server.api.common.FieldError;
import com.soupthatisthick.dnd.utilities.server.service.common.base.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static com.soupthatisthick.dnd.utilities.server.util.logger.Logger.LOG;

public class BaseApiController {

    // Constants ----------------------------------------------------------------- Constants //

    private static final String UNSUPPORTED_MEDIA_TYPE_MESSAGE = "Unsupported Media Type, Content-Type must be application.json";

    // Instance Variables ----------------------------------------------- Instance Variables //

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ApiResponse handleServiceException(
            final ServiceException exception,
            final HttpServletResponse httpResponse
    ) {
        LOG.error(exception.getMessage(), exception);
        ApiResponse apiResponse = new ApiResponse();
        ApiStatus status = new ApiStatus();
        status.setErrorCode(exception.getClass().getSimpleName());
        status.setMessage(exception.getMessage());
        status.setStatusCode(HttpStatus.I_AM_A_TEAPOT);
        apiResponse.setStatus(status);
        httpResponse.setStatus(HttpStatus.I_AM_A_TEAPOT.value());
        return apiResponse;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiResponse handleMethodArgumentNotValidException(
            final MethodArgumentNotValidException exception,
            final HttpServletResponse httpResponse
    ) {
        ApiResponse apiResponse = new ApiResponse();
        BindingResult bindingResult = exception.getBindingResult();
        apiResponse.getStatus().setValidationErrors(parseFieldErrors(bindingResult));
        apiResponse.getStatus().setStatusCode(HttpStatus.BAD_REQUEST);
        httpResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return apiResponse;
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public ApiResponse mediaTypeNotSupported(
            final HttpMediaTypeNotSupportedException exception,
            final HttpServletResponse httpResponse
    ) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.getStatus().setStatusCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
        apiResponse.getStatus().setMessage(UNSUPPORTED_MEDIA_TYPE_MESSAGE);
        httpResponse.setStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
        return apiResponse;
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ApiResponse catchAll(final Throwable throwable, final HttpServletResponse httpResponse) {
        LOG.error("Unexpected error occurred.", throwable);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.getStatus().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        apiResponse.getStatus().setMessage(throwable.getMessage());
        httpResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return apiResponse;
    }

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    private List<FieldError> parseFieldErrors(BindingResult bindingResult) {
        List<FieldError> apiFieldErrors = new ArrayList<>();
        for(org.springframework.validation.FieldError fieldError : bindingResult.getFieldErrors()) {
            FieldError apiFieldError = new FieldError();
            apiFieldError.setMessage(fieldError.getDefaultMessage());
            apiFieldError.setField(fieldError.getDefaultMessage());
            apiFieldError.setCode(fieldError.getCode());
            if (fieldError.getRejectedValue() != null) {
                apiFieldError.setRejectedValue(fieldError.getRejectedValue().toString());
            }
            apiFieldErrors.add(apiFieldError);
        }
        return apiFieldErrors;
    }

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
