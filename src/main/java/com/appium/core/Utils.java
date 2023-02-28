package com.appium.core;

public class Utils {
    public static String returnCurrentDir() {
        String dir = System.getProperty("user.dir");
        // System.out.println(dir);
        return dir;
    }
}
