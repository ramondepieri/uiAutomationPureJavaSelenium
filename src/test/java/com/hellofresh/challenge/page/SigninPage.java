package com.hellofresh.challenge.page;

import com.aventstack.extentreports.Status;
import com.hellofresh.challenge.core.report.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SigninPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Elements of page
    private By textTitle = By.cssSelector("h1");
    private By fieldGender = By.id("id_gender2");
    private By fieldCustomerFirstName = By.id("customer_firstname");
    private By fieldCustomerLastName = By.id("customer_lastname");
    private By fieldCustomerPasswd = By.id("passwd");
    private By fieldDay = By.id("days");
    private By fieldMonths = By.id("months");
    private By fieldYears = By.id("years");
    private By fieldCompany = By.id("company");
    private By fieldAddress1 = By.id("address1");
    private By fieldAddress2 = By.id("address2");
    private By fieldCity = By.id("city");
    private By fieldState = By.id("id_state");
    private By fieldPostCode = By.id("postcode");
    private By fieldOther = By.id("other");
    private By fieldPhone = By.id("phone");
    private By fieldPhoneMobile = By.id("phone_mobile");
    private By fieldAlias = By.id("alias");
    private By buttonSubimitAccount = By.id("submitAccount");

    public SigninPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public MyAccountPage sigIn(String firstName, String lastName, String passwd,
                               String day, String month, String year,
                               String company, String address1, String address2, String city,
                               String state, String postCode, String other, String phone,
                               String phoneMobile, String alias) {

        selecetGender();
        typeFirstName(firstName);
        typeLastName(lastName);
        typePasswd(passwd);
        selectBirthDay(day);
        selectBirthMonth(month);
        selectYear(year);
        typeCompany(company);
        typeAddress1(address1);
        typeAdress2(address2);
        typeCity(city);
        selectState(state);
        typePostCode(postCode);
        typeOther(other);
        typePhone(phone);
        typeMobilePhone(phoneMobile);
        typeAlias(alias);
        clickRegister();
        return new MyAccountPage(driver, wait);
    }

    private void clickRegister() {
        ExtentTestManager.getTest().log(Status.INFO, "And click on 'Register' button ");
        driver.findElement(buttonSubimitAccount).click();
    }

    private void typeAlias(String alias) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the alias " + alias + " on alis field");
        WebElement elementAliasField = driver.findElement(fieldAlias);
        elementAliasField.clear();
        elementAliasField.sendKeys(alias);
    }

    private void typeMobilePhone(String phoneMobile) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the mobile phone " + phoneMobile + " on phone_mobile field");
        driver.findElement(fieldPhoneMobile).sendKeys(phoneMobile);
    }

    private void typePhone(String phone) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the phone " + phone + " on phone field");
        driver.findElement(fieldPhone).sendKeys(phone);
    }

    private void typeOther(String other) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the other " + other + " on other field");
        driver.findElement(fieldOther).sendKeys(other);
    }

    private void typePostCode(String postCode) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the value " + postCode + " on postcode field");
        driver.findElement(fieldPostCode).sendKeys(postCode);
    }

    private void selectState(String state) {
        ExtentTestManager.getTest().log(Status.INFO, "And select the state " + state + " on state field");
        Select select4 = new Select(driver.findElement(fieldState));
        select4.selectByVisibleText(state);
    }

    private void typeCity(String city) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the value " + city + " on city field");
        driver.findElement(fieldCity).sendKeys(city);
    }

    private void typeAdress2(String address2) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the value " + address2 + " on address2 field");
        driver.findElement(fieldAddress2).sendKeys(address2);
    }

    private void typeAddress1(String address1) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the value " + address1 + " on address1 field");
        driver.findElement(fieldAddress1).sendKeys(address1);
    }

    private void typeCompany(String company) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the value " + company + " on company field");
        driver.findElement(fieldCompany).sendKeys(company);
    }

    private void selectBirthMonth(String month) {
        ExtentTestManager.getTest().log(Status.INFO, "And select the month " + month + " on date of birth field");
        Select select2 = new Select(driver.findElement(fieldMonths));
        select2.selectByValue(month);
    }

    private void selectBirthDay(String day) {
        ExtentTestManager.getTest().log(Status.INFO, "And select the day " + day + " on date of birth field");
        Select select = new Select(driver.findElement(fieldDay));
        select.selectByValue(day);
    }

    private void typePasswd(String passwd) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the value " + passwd + " on passwd field");
        driver.findElement(fieldCustomerPasswd).sendKeys(passwd);
    }

    private void typeLastName(String lastName) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the value " + lastName + " on customer_lastname field");
        driver.findElement(fieldCustomerLastName).sendKeys(lastName);
    }

    private void typeFirstName(String firstName) {
        ExtentTestManager.getTest().log(Status.INFO, "And type the value " + firstName + " on customer_firstname field");
        driver.findElement(fieldCustomerFirstName).sendKeys(firstName);
    }

    private void selecetGender() {
        ExtentTestManager.getTest().log(Status.INFO, "And wait gender field be visible");
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldGender)).click();
    }

    private void selectYear(String year) {
        ExtentTestManager.getTest().log(Status.INFO, "And select the year " + year + " on date of birth field");
        Select select3 = new Select(driver.findElement(fieldYears));
        select3.selectByValue(year);
    }

}
