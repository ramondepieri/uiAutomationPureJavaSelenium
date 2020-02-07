package com.hellofresh.challenge.core.driver;

public class DriverFactory {

    public static DriverManager getManager(DriverSelect driverSelect) {
        DriverManager driverManager = null;

        switch (driverSelect) {
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }

}
