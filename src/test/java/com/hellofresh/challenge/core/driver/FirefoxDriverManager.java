package com.hellofresh.challenge.core.driver;

import com.hellofresh.challenge.core.utils.CommonUtils;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

    protected void createDriver() {
        String driverExecutableNamePath = "";

        if (CommonUtils.isWindows()) {
            driverExecutableNamePath = "src/test/resources/geckodriver.exe";
        } else if (CommonUtils.isLinuxOS()) {
            driverExecutableNamePath = "src/test/resources/geckodriver_linux";
        } else {
            driverExecutableNamePath = "src/test/resources/geckodriver_mac";
        }

        System.setProperty("webdriver.gecko.driver", driverExecutableNamePath);
        driver = new FirefoxDriver();
    }

    protected void initiateServiceDriver() {

    }

    protected void terminateServiceDriver() {

    }
}
