package com.hellofresh.challenge.page;

import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPaymentBankWirePage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Elements of page
    private By textTitle = By.cssSelector("h1");
    private By buttonConfirmOrder = By.xpath("//*[@id='cart_navigation']/button");

    public OrderPaymentBankWirePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public ConfirmOrderPage confirmOrder() {
        ExtentTestManager.getTest().log(Status.INFO, "And confirm order");
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonConfirmOrder)).click();
        return new ConfirmOrderPage(driver, wait);
    }
}
