package com.hellofresh.challenge.testcase;

import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import com.hellofresh.challenge.core.suite.MotherTest;
import com.hellofresh.challenge.page.ConfirmOrderPage;
import com.hellofresh.challenge.page.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckoutTest extends MotherTest {

    //test data
    private final String urlLogin = "/index.php";
    private final String existingUserEmail = "hf_challenge_123456@hf123456.com";
    private final String categoryName = "Women";
    String existingUserPasswd = "12345678";

    @Parameters({"product-name", "product-size", "product-color"})
    @Test
    public void checkoutTest(String productName, String productSize, String productColor) {
        // action
        LoginPage loginPage = new LoginPage(driver, wait);
        ConfirmOrderPage confirmOrderPage = loginPage.open(urlBase + urlLogin)
                .submitLogin(existingUserEmail, existingUserPasswd)
                .openCategory(categoryName)
                .openProduct(productName)
                .addToCart(productName, productSize, productColor)
                .proceedCheckout()
                .proceedCheckout()
                .proceedAddress()
                .clickAgreeTerms()
                .proceedCheckout()
                .proceedWithBankWire()
                .confirmOrder();

        // validation
        boolean valid = confirmOrderPage.isValid();
        ExtentTestManager.getTest().log(Status.INFO, "Then should show the order information");
        assertTrue(valid);
    }

}
