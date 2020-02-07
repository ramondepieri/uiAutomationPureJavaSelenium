package com.hellofresh.challenge.page;

import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Elements of page
    private By textTitle = By.cssSelector("h1");
    private By buttonProceedToCheckout = By.xpath("//a[@title='Proceed to checkout']");


    public CartPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public OrderPage proceedCheckout() {
        ExtentTestManager.getTest().log(Status.INFO, "And proceed to checkout");
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonProceedToCheckout)).click();
        return new OrderPage(driver, wait);
    }

}
