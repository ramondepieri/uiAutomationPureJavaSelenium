package com.hellofresh.challenge.testcase;

import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import com.hellofresh.challenge.core.suite.MotherTest;
import com.hellofresh.challenge.page.LoginPage;
import com.hellofresh.challenge.page.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LogInTest extends MotherTest {

    //Common data
    private final String urlLogin = "/index.php";
    private final String existingUserEmail = "hf_challenge_123456@hf123456.com";
    private final String validUserFullName = "Joe Black";
    String existingUserPasswd = "12345678";
    String invalidUserPassword = "hack123";

    @Test
    public void loginSuccess() {
        // action
        LoginPage loginPage = new LoginPage(driver, wait);
        MyAccountPage myAccountPage = loginPage.open(urlBase + urlLogin)
                .submitLogin(existingUserEmail, existingUserPasswd);

        // validation
        boolean valid = myAccountPage.isValid(validUserFullName);
        ExtentTestManager.getTest().log(Status.INFO, "Then should show account page");
        assertTrue(valid);
    }

    @Test
    public void loginFail() {
        // action
        LoginPage loginPage = new LoginPage(driver, wait);
        MyAccountPage myAccountPage = loginPage.open(urlBase + urlLogin)
                .submitLogin(existingUserEmail, invalidUserPassword);

        // validation
        boolean valid = myAccountPage.isValid(validUserFullName);
        ExtentTestManager.getTest().log(Status.INFO, "Then should not show account page");
        Assert.assertFalse(valid);
    }

}
