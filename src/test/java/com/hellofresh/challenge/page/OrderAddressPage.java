package com.hellofresh.challenge.page;

import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderAddressPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Elements of page
    private By textTitle = By.cssSelector("h1");
    private By buttonProceedAddress = By.name("processAddress");

    public OrderAddressPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public OrderShippingPage proceedAddress() {
        ExtentTestManager.getTest().log(Status.INFO, "And proceed address");
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonProceedAddress)).click();
        return new OrderShippingPage(driver, wait);
    }
}
