package com.soupthatisthick.dnd.utilities.server.util;

public interface Matcher<T> {
    boolean isEqual(T expected, T observed);
}
