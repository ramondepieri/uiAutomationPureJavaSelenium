package com.hellofresh.challenge.core.driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void createDriver();

    protected abstract void initiateServiceDriver();

    protected abstract void terminateServiceDriver();

    public WebDriver getDriver() {
        if (null == driver) {
            initiateServiceDriver();
            createDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

}
