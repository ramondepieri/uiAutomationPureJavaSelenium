package com.hellofresh.challenge.page;

import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Elements of page
    private By textTitle = By.cssSelector("h1");
    private By buttonSubmit = By.name("Submit");
    private By fieldSize = By.id("group_1");

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public CartPage addToCart(String productName, String size, String color) {
        selectSize(size);
        selectColor(color);

        ExtentTestManager.getTest().log(Status.INFO, "And add the product '" + productName + "' to cart");
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonSubmit)).click();
        return new CartPage(driver, wait);
    }

    private void selectSize(String size) {
        ExtentTestManager.getTest().log(Status.INFO, "And select size " + size + " on size of product");
        Select select = new Select(driver.findElement(fieldSize));
        select.selectByValue(size);
    }

    private void selectColor(String colorName) {
        ExtentTestManager.getTest().log(Status.INFO, "And select the color '" + colorName + "' of product");
        wait.until(ExpectedConditions.visibilityOfElementLocated(getByFieldColor(colorName))).click();
    }

    private By getByFieldColor(String color) {
        By fieldColor = By.xpath("//a[@title='" + color + "']");
        return fieldColor;
    }

}
