package com.hellofresh.challenge.testcase;

import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import com.hellofresh.challenge.core.suite.MotherTest;
import com.hellofresh.challenge.core.utils.RandomDataGenerator;
import com.hellofresh.challenge.page.LoginPage;
import com.hellofresh.challenge.page.MyAccountPage;
import com.hellofresh.challenge.page.SigninPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignInTest extends MotherTest {

    //test data
    private String urlLogin = "/index.php";
    private String emalCreate = RandomDataGenerator.getRandomEmail();
    private String firstName = "Firstname";
    private String lastName = "Lastname";
    private String passwd = "Qwerty";
    private String dayB = "1";
    private String monthB = "1";
    private String yearB = "2000";
    private String company = "Company";
    private String address1 = "Qwertt, 123";
    private String address2 = "zxcvb";
    private String city = "Criciuma";
    private String stateName = "Colorado";
    private String postCode = "12345";
    private String other = "Qwerty";
    private String phone = "12345123123";
    private String phoneMobile = "12345123123";
    private String alias = "hf";

    @Test
    public void signInTest() {
        // action
        LoginPage loginPage = new LoginPage(driver, wait);
        MyAccountPage myAccountPage = loginPage.open(urlBase + urlLogin)
                .submitCreate(emalCreate).sigIn(firstName, lastName, passwd,
                        dayB, monthB, yearB, company, address1, address2,
                        city, stateName, postCode, other, phone,
                        phoneMobile, alias);

        // validation
        boolean valid = myAccountPage.isValid(firstName + " " + lastName);
        ExtentTestManager.getTest().log(Status.INFO, "Then should show account page");
        assertTrue(valid);
    }

}
