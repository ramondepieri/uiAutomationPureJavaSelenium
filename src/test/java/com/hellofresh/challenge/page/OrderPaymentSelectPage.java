package com.hellofresh.challenge.page;

import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPaymentSelectPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Elements of page
    private By textTitle = By.cssSelector("h1");
    private By buttonProceedWithBankWire = By.className("bankwire");

    public OrderPaymentSelectPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public OrderPaymentBankWirePage proceedWithBankWire() {
        ExtentTestManager.getTest().log(Status.INFO, "And proceed with bank wire");
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonProceedWithBankWire)).click();
        return new OrderPaymentBankWirePage(driver, wait);
    }
}
