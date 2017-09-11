package com.soupthatisthick.dnd.utilities.server.util;

import com.mashape.unirest.http.HttpResponse;
import com.soupthatisthick.dnd.utilities.server.api.common.ApiResponse;
import com.soupthatisthick.dnd.utilities.server.api.common.ApiStatus;
import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;
import com.soupthatisthick.dnd.utilities.server.util.logger.Logger;
import com.soupthatisthick.dnd.utilities.server.util.podam.PodamUtil;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class AssertUtil {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    public static final void assertResponseStatus(ApiResponse response, HttpStatus expected) {
        assertNotNull(response);
        ApiStatus status = response.getStatus();
        assertNotNull(status);
        assertNotNull(status.getStatusCode());

        String assertMessage = "Expected " + expected.name() + " but was " + status.getStatusCode().name() + ".";
        assertMessage += "\n" + status.getMessage();

        assertEquals(assertMessage, expected.value(), status.getStatusCode());
    }

    public static final void assertResponseStatusIsNot(ApiResponse response, HttpStatus notExpected) {
        assertNotNull(response);
        ApiStatus status = response.getStatus();
        assertNotNull(status);
        assertNotNull(status.getStatusCode());

        String assertMessage = "Expecting anything but " + notExpected.name() + " and observed " + notExpected.name() + ".";
        assertMessage += "\n" + status.getMessage();
        assertNotEquals(assertMessage, notExpected, status.getStatusCode());
    }

    public static final void assertHttpResponseStatus(HttpResponse httpResponse, HttpStatus expected) {
        assertNotNull(httpResponse);

        String assertMessage = "Expecting " + expected.name() + " but was " + HttpStatus.valueOf(httpResponse.getStatus()).name();
        assertEquals(assertMessage, expected.value(), httpResponse.getStatus());
    }

    public static final <T> void assertCollectionsSame(Collection<T> expected, Collection<T> observed) {
        assertCollectionsSame(expected, observed, null);
    }

    public static final <T> void assertCollectionsSame(
            Collection<T> expected,
            Collection<T> observed,
            Matcher<T> matcher
    ) {
        assertEquals("Size should be the same", expected.size(), observed.size());
        Collection<T> observedCopy = new ArrayList<>();
        observedCopy.addAll(observed);
        assertEquals("Copy size should be the same.", observed.size(), observedCopy.size());
        for(T item : expected) {
            assertTrue("Should have been able to remove" + item, removeFirst(observedCopy, item, matcher));
        }
        assertEquals("All items should have been removed. ", 0, observedCopy.size());
    }

    public static <T extends Serializable> void assertClassIsJsonConvertable(Class<T> classType) {

        T expected = PodamUtil.manufacture(classType);
        String expectedJson = JsonUtil.toJson(expected, true);

        T observed = JsonUtil.toObject(expectedJson, classType);
        String observedJson = JsonUtil.toJson(observed);

        assertEquals("should match", expectedJson, observedJson);
    }

    public static void assertObjectIsJsonConvertable(Object expected) {
        String expectedJson = JsonUtil.toJson(expected, true);
        Logger.info("--- Expected Json ---\n" + expectedJson);
        Object observed = JsonUtil.toObject(expectedJson, expected.getClass());
        String observedJson = JsonUtil.toJson(observed, true);
        Logger.info("--- Observed Json ---\n" + observedJson);

        assertEquals("should match", expectedJson, observedJson);
    }

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //


    private static final <T> boolean removeFirst(Collection<T> list, T expected, Matcher<T> matcher) {
        Iterator<T> iterator = list.iterator();
        while(iterator.hasNext()) {
            T item = iterator.next();
            boolean isMatch = ((matcher==null) ? expected.equals(item) : matcher.isEqual(expected, item));
            if (isMatch) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
