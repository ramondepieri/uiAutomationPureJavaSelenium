package com.hellofresh.challenge.page;

import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Elements of page
    private By fieldEmail = By.id("email");
    private By fieldEmailCreate = By.id("email_create");
    private By fieldPasswd = By.id("passwd");
    private By buttonSubmitLogin = By.id("SubmitLogin");
    private By buttonSubmitCreate = By.id("SubmitCreate");

    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public LoginPage open(String url){
        openLoginPage(url);
        clickLogin();
        return this;
    }

    public MyAccountPage submitLogin(String user, String passwd){
        waitEmailField();
        typeEmail(user);
        typePasswd(passwd);
        clickSignIn();
        return new MyAccountPage(driver, wait);
    }

    private void openLoginPage(String url) {
        ExtentTestManager.getTest().log(Status.INFO, "Given the user is on login page:  "+url);
        driver.get(url);
    }

    private void clickLogin() {
        ExtentTestManager.getTest().log(Status.INFO, "And click on login button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
    }

    private void clickSignIn() {
        ExtentTestManager.getTest().log(Status.INFO, "And click on 'Sign in' button ");
        driver.findElement(buttonSubmitLogin).click();
    }

    private void typePasswd(String passwd) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the value "+passwd+ " on password field");
        driver.findElement(fieldPasswd).sendKeys(passwd);
    }

    private void typeEmail(String user) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the value "+user+ " on email field");
        driver.findElement(fieldEmail).sendKeys(user);
    }

    private void waitEmailField() {
        ExtentTestManager.getTest().log(Status.INFO, "And wait email field be visible");
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldEmail));
    }

    public SigninPage submitCreate(String email){
        waitEmailCreateField();
        typeEmailCreate(email);
        clickCreateAccount();
        return new SigninPage(driver, wait);
    }

    private void waitEmailCreateField() {
        ExtentTestManager.getTest().log(Status.INFO, "And wait email_create field be visible");
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldEmailCreate));
    }

    private void typeEmailCreate(String email) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the value "+email+ " on email_create field");
        driver.findElement(fieldEmailCreate).sendKeys(email);
    }

    private void clickCreateAccount() {
        ExtentTestManager.getTest().log(Status.INFO, "And click on 'Create an account' button ");
        driver.findElement(buttonSubmitCreate).click();
    }

}
