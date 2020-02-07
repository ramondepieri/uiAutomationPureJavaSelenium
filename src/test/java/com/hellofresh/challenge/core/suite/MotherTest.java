package com.hellofresh.challenge.core.suite;

import com.hellofresh.challenge.core.driver.DriverFactory;
import com.hellofresh.challenge.core.driver.DriverManager;
import com.hellofresh.challenge.core.driver.DriverSelect;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class MotherTest {

    DriverManager driverManager;
    public WebDriver driver;
    public WebDriverWait wait;
    public String urlBase = "";

    @Parameters({"browser", "generate-test-evidence"})
    @BeforeTest
    public void beforeMain(String broswer, String generateEvidence, ITestContext context) {
        factoryDrive(broswer);
        context.setAttribute("generate-test-evidence", generateEvidence);
    }

    @Parameters({"url-base", "browser", "generate-test-evidence"})
    @BeforeMethod
    public void beforeEachTest(String urlBase, String broswer, String generateEvidence, ITestContext context) {
        this.urlBase = urlBase;

        if (driverManager == null) {
            factoryDrive(broswer);
        }

        driver = driverManager.getDriver();
        wait = new WebDriverWait(driver, 10, 50);
        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void afterEachTest() {
        driverManager.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    private void factoryDrive(String broswer) {
        if (broswer.trim().toUpperCase().contains("FIREFOX")) {
            driverManager = DriverFactory.getManager(DriverSelect.FIREFOX);
        } else {
            driverManager = DriverFactory.getManager(DriverSelect.CHROME);
        }
    }

}
