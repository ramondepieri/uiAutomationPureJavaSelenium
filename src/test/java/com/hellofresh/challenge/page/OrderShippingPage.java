package com.hellofresh.challenge.page;

import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderShippingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Elements of page
    private By textTitle = By.cssSelector("h1");
    private By fieldAgreeTerms = By.id("uniform-cgv");
    private By buttonProceedToCheckout = By.name("processCarrier");

    public OrderShippingPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public OrderShippingPage clickAgreeTerms(){
        ExtentTestManager.getTest().log(Status.INFO, "And agree the terms");
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldAgreeTerms)).click();
        return new OrderShippingPage(driver, wait);
    }

    public OrderPaymentSelectPage proceedCheckout() {
        ExtentTestManager.getTest().log(Status.INFO, "And proceed to checkout");
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonProceedToCheckout)).click();
        return new OrderPaymentSelectPage(driver, wait);
    }
}
