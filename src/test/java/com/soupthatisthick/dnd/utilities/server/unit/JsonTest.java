package com.soupthatisthick.dnd.utilities.server.unit;

import com.soupthatisthick.dnd.utilities.server.common.model.messages.ApiResponse;
import com.soupthatisthick.dnd.utilities.server.util.podam.PodamUtil;
import org.junit.Test;

import java.time.LocalDateTime;

import static com.soupthatisthick.dnd.utilities.server.util.AssertUtil.assertObjectIsJsonConvertable;

public class JsonTest {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //



    @Test
    public void localDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();

        assertObjectIsJsonConvertable(localDateTime);
    }

    @Test
    public void apiResponse() {
        ApiResponse apiResponse = new ApiResponse<String>();
        apiResponse.setData(PodamUtil.manufacture(String.class));

        assertObjectIsJsonConvertable(apiResponse);
    }

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
