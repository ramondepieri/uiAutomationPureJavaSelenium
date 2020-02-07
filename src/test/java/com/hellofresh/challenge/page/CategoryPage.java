package com.hellofresh.challenge.page;

import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Elements of page
    private By textTitle = By.cssSelector("h1");


    public CategoryPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public ProductPage openProduct(String productName) {
        By product = getByProduct(productName);
        ExtentTestManager.getTest().log(Status.INFO, "And view the product "+productName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(product)).click();
        return new ProductPage(driver, wait);
    }

    private By getByProduct(String productName) {
        return By.xpath("//a[@title='" + productName + "']");
    }

}
