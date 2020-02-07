package com.hellofresh.challenge.core.driver;

import com.hellofresh.challenge.core.utils.CommonUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService chromeDriverService;

    protected void createDriver() {
        driver = new ChromeDriver(chromeDriverService);
    }

    protected void initiateServiceDriver() {
        String driverExecutableName = "";

        if (CommonUtils.isWindows()) {
            driverExecutableName = "src/test/resources/chromedriver.exe";
        } else if (CommonUtils.isLinuxOS()) {
            driverExecutableName = "src/test/resources/chromedriver_linux";
        } else {
            driverExecutableName = "src/test/resources/chromedriver_mac";
        }

        if (null == chromeDriverService) {
            try {
                chromeDriverService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(driverExecutableName))
                        .usingAnyFreePort()
                        .build();
                chromeDriverService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void terminateServiceDriver() {
        if (null != chromeDriverService && chromeDriverService.isRunning())
            chromeDriverService.stop();
    }
}
