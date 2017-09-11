package com.soupthatisthick.dnd.utilities.server.util.podam;

import java.util.Random;

public class RandomUtil {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    private static Random random = new Random();

    // Constructors ----------------------------------------------------------- Constructors //

    // Public Methods ------------------------------------------------------- Public Methods //

    public static String randomString() {
        return PodamUtil.manufacture(String.class);
    }

    public static long randLong() {
        return Math.abs(random.nextLong()) + 1;
    }

    public static int randInt(int min, int max) {
        return random.nextInt((max-min) + 1) + min;
    }

    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class
