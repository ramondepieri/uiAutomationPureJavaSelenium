package com.hellofresh.challenge.page;

import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmOrderPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Elements of page
    private By textTitle = By.cssSelector("h1");
    private By textLastFourSteps = By.xpath("//li[@class='step_done step_done_last four']");
    private By textLastCurrentStep = By.xpath("//li[@id='step_end' and @class='step_current last']");
    private By textOrderComplet = By.xpath("//*[@class='cheque-indent']/strong");


    public ConfirmOrderPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        wait.until(ExpectedConditions.visibilityOfElementLocated(textTitle));
    }

    public boolean isValid() {
        return hasOrderConfirmationText() && isLastFourStepVisible() &&
                isLastCurrentStepVisible() && isCurrentUrlOrderConfirmation() && hasOrderCompleteText();
    }

    private boolean hasOrderConfirmationText() {
        boolean equals = driver.findElement(textTitle).getText().equals("ORDER CONFIRMATION");
        ExtentTestManager.getTest().log(Status.INFO, "And check has ORDER CONFIRMATION. " + " Result: " + equals);
        return equals;
    }

    private boolean isLastFourStepVisible() {
        boolean displayed = driver.findElement(textLastFourSteps).isDisplayed();
        ExtentTestManager.getTest().log(Status.INFO, "And check if the last fours steps is displayed. Result " + displayed);
        return displayed;
    }

    private boolean isLastCurrentStepVisible() {
        boolean displayed = driver.findElement(textLastCurrentStep).isDisplayed();
        ExtentTestManager.getTest().log(Status.INFO, "And check if the last current step is displayed. Result " + displayed);
        return displayed;
    }

    private boolean hasOrderCompleteText() {
        boolean equals = driver.findElement(textOrderComplet).getText().equals("Your order on My Store is complete.");
        ExtentTestManager.getTest().log(Status.INFO, "And check has text 'Your order on My Store is complete'. " + " Result: " + equals);
        return equals;
    }

    private boolean isCurrentUrlOrderConfirmation() {
        boolean contains = driver.getCurrentUrl().contains("controller=order-confirmation");
        ExtentTestManager.getTest().log(Status.INFO, "And check if the url contains: controller=order-confirmation. Result: " + contains);
        return contains;
    }

}
