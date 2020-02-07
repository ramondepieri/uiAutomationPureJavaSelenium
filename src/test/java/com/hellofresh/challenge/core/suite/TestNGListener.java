package com.hellofresh.challenge.core.suite;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentManager;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

public class TestNGListener implements ITestListener {

    private Logger log = Logger.getLogger("UI test automation");

    public void onStart(ITestContext context) {
        log.info("================= UI test automation JAVA " + context.getName() + " started =================");
    }

    public void onFinish(ITestContext context) {
        log.info("================= UI test automation JAVA " + context.getName() + " ending ================= UI test automation JAVA ");
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    public void onTestStart(ITestResult result) {
        log.info("================= UI test automation JAVA  Running test method " + result.getMethod().getMethodName() + "...");
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        log.info("================= UI test automation JAVA  Executed " + result.getMethod().getMethodName() + " test successfully...");

        if (result.getTestContext().getAttribute("generate-test-evidence").toString().trim().toUpperCase().contains("Y")) {
            ITestContext context = result.getTestContext();
            WebDriver driver = (WebDriver) context.getAttribute("driver");

            String targetLocation = null;
            String testClassName = getTestClassName(result.getInstanceName()).trim();
            File targetFile = null;

            ScreenShoot screenShoot = new ScreenShoot(result, driver, testClassName, targetLocation, targetFile);
            screenShoot.takeScreenShoot();

            targetFile = screenShoot.getTargetFile();
            targetLocation = screenShoot.getTargetLocation();

            try {
                if (targetLocation != null) {
                    ExtentTestManager.getTest().info("Test Evidence - Screenshot",
                            MediaEntityBuilder.createScreenCaptureFromPath("./screenshots/" + testClassName + "/" + targetFile.getName()).build());
                }
            } catch (IOException e) {
                log.info("An exception occured while taking screenshot " + e.getCause());
            }
        }

        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    public void onTestFailure(ITestResult result) {
        log.info("================= UI test automation JAVA  Test execution " + result.getMethod().getMethodName() + " failed...");
        log.info((result.getMethod().getMethodName() + " failed!"));

        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("driver");

        String errorCatch = "";

        if (null != result.getThrowable()) {
            errorCatch = result.getThrowable().getMessage();
        }

        String targetLocation = null;
        String testClassName = getTestClassName(result.getInstanceName()).trim();
        File targetFile = null;

        ScreenShoot screenShoot = new ScreenShoot(result, driver, testClassName, targetLocation, targetFile);
        screenShoot.takeScreenShoot();

        targetFile = screenShoot.getTargetFile();
        targetLocation = screenShoot.getTargetLocation();

        try {
            if (targetLocation != null) {
                ExtentTestManager.getTest().fail("Screenshot",
                        MediaEntityBuilder.createScreenCaptureFromPath("./screenshots/" + testClassName + "/" + targetFile.getName()).build());
            }
        } catch (IOException e) {
            log.info("An exception occured while taking screenshot " + e.getCause());
        }

        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed. " + errorCatch);
    }

    public void onTestSkipped(ITestResult result) {
        log.info("================= UI test automation JAVA  Test " + result.getMethod().getMethodName() + " skipped...");
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("================= UI test automation JAVA  Test failed but within percentage % " + result.getMethod().getMethodName());
    }

    public String getTestClassName(String testName) {
        String[] reqTestClassname = testName.split("\\.");
        int i = reqTestClassname.length - 1;
        log.info("Required Test Name : " + reqTestClassname[i]);
        return reqTestClassname[i];
    }

    public class ScreenShoot {

        private ITestResult result;
        private WebDriver driver;
        private String testClassName;
        private String targetLocation;
        private File targetFile;

        public ScreenShoot(ITestResult result, WebDriver driver, String testClassName, String targetLocation, File targetFile) {
            this.result = result;
            this.driver = driver;
            this.testClassName = testClassName;
            this.targetLocation = targetLocation;
            this.targetFile = targetFile;
        }

        public void takeScreenShoot() {
            String timestamp = String.valueOf(new Date().getTime());
            String testMethodName = result.getName().trim();
            String screenShotName = testMethodName + timestamp + ".png";
            String fileSeperator = System.getProperty("file.separator");
            String reportsPath = System.getProperty("user.dir") + fileSeperator + "TestReport" + fileSeperator
                    + "screenshots";
            log.info("Screen shots reports path - " + reportsPath);
            try {
                File file = new File(reportsPath + fileSeperator + testClassName); // Set
                // screenshots
                // folder
                if (!file.exists()) {
                    if (file.mkdirs()) {
                        log.info("Directory: " + file.getAbsolutePath() + " is created!");
                    } else {
                        log.info("Failed to create directory: " + file.getAbsolutePath());
                    }

                }

                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                targetLocation = reportsPath + fileSeperator + testClassName + fileSeperator + screenShotName;// define
                // location
                targetFile = new File(targetLocation);
                log.info("Screen shot file location - " + screenshotFile.getAbsolutePath());
                log.info("Target File location - " + targetFile.getAbsolutePath());
                FileHandler.copy(screenshotFile, targetFile);

            } catch (FileNotFoundException e) {
                log.info("File not found exception occurred while taking screenshot " + e.getMessage());
            } catch (Exception e) {
                log.info("An exception occurred while taking screenshot " + e.getCause());
            }
        }

        public ITestResult getResult() {
            return result;
        }

        public WebDriver getDriver() {
            return driver;
        }

        public String getTestClassName() {
            return testClassName;
        }

        public String getTargetLocation() {
            return targetLocation;
        }

        public File getTargetFile() {
            return targetFile;
        }
    }


}
