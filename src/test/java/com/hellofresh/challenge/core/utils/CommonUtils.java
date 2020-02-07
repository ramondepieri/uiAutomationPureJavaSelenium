package com.hellofresh.challenge.core.utils;

public class CommonUtils {

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

    public static boolean isMacOS() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }

    public static boolean isLinuxOS() {
        return System.getProperty("os.name").toLowerCase().contains("linux");
    }

}
