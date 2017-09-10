package com.soupthatisthick.dnd.utilities.server.api;

import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Owner on 9/9/2017.
 */
@Api(description = "A controller to handle the default error page.")
@RestController
@RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiErrorController extends BaseApiController implements ErrorController {
    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    /**
     * Error Attributes in the Application
     */
    private ErrorAttributes errorAttributes;

    private final static String ERROR_PATH = "/error";

    // Constructors ----------------------------------------------------------- Constructors //

    /**
     * Controller for the Error Controller
     * @param errorAttributes
     */
    public ApiErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    // Public Methods ------------------------------------------------------- Public Methods //


    /**
     * Supports other formats like JSON, XML
     * @param request
     * @return
     */
    @ApiOperation(value = "User to provide the generic error message")
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request, getTraceParameter(request));
        HttpStatus status = getStatus(request);
        return new ResponseEntity<Map<String, Object>>(body, status);
    }

    /**
     * Returns the path of the error page.
     *
     * @return the error path
     */
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }


    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request,
                                                   boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes,
                includeStackTrace);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            try {
                return HttpStatus.valueOf(statusCode);
            }
            catch (Exception ex) {
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
