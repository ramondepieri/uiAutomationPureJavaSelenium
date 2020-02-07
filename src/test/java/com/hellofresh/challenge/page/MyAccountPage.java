package com.hellofresh.challenge.page;

import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Elements of page
    private By textTitle = By.cssSelector("h1");
    private By textFullUserName = By.className("account");
    private By textWelcomeMessage = By.className("info-account");
    private By buttonLogout = By.className("logout");

    public MyAccountPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isValid(String fullUserName) {
        return hasMyAccountText() && hasFullUserAccountName(fullUserName) &&
                hasWelcomeMessage() && isButtonLogoutVisible() && isCurrentUrlMyAccount();
    }

    private boolean hasMyAccountText() {
        boolean equals = driver.findElement(textTitle).getText().equals("MY ACCOUNT");
        ExtentTestManager.getTest().log(Status.INFO, "And check has MY ACCOUNT text. " + " Result: " + equals);
        return equals;
    }

    private boolean hasFullUserAccountName(String fullUserName) {
        String accountNameFound = driver.findElement(textFullUserName).getText();
        boolean equals = accountNameFound.equals(fullUserName);
        ExtentTestManager.getTest().log(Status.INFO, "And check if account name is equal " + fullUserName + "Name found: " + accountNameFound + " Result: " + equals);
        return equals;
    }

    private boolean hasWelcomeMessage() {
        boolean contains = driver.findElement(textWelcomeMessage).getText().contains("Welcome to your account.");
        ExtentTestManager.getTest().log(Status.INFO, "And check if there is the message: Welcome to your account. Result: " + contains);
        return contains;
    }

    private boolean isButtonLogoutVisible() {
        boolean displayed = driver.findElement(buttonLogout).isDisplayed();
        ExtentTestManager.getTest().log(Status.INFO, "And check if the logout button is displayed. Result " + displayed);
        return displayed;
    }

    private boolean isCurrentUrlMyAccount() {
        boolean contains = driver.getCurrentUrl().contains("controller=my-account");
        ExtentTestManager.getTest().log(Status.INFO, "And check if the url contains: controller=my-account. Result: " + contains);
        return contains;
    }

    public CategoryPage openCategory(String categoryName) {
        ExtentTestManager.getTest().log(Status.INFO, "And open product category: " + categoryName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getByFieldCategory(categoryName))).click();
        return new CategoryPage(driver, wait);
    }

    public By getByFieldCategory(String categoryName) {
        By byCategoryName = By.xpath("//a[@title='" + categoryName + "']");
        return byCategoryName;
    }

}
