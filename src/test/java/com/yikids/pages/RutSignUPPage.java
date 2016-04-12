package com.yikids.pages;

/**
 * Created by rutga on 29.03.2016.
 */

//import com.telran.LogLog4j;
//import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class RutSignUPPage extends Page {
    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static Random rnd = new Random();

    //fields
    @FindBy(id = "firstname")
    WebElement firstNameField;

    @FindBy(id = "lastname")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "zipcode")
    WebElement zipCode1Field;

    @FindBy(id = "zip-plus")
    WebElement zipCode2Field;

    @FindBy(id = "company")
    WebElement companyField;

    //buttons
    @FindBy(id = "create-account")
    WebElement continueButton;

    //System messages
    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement captchaMessage;

    @FindBy(xpath = "//span[@class='error error-first_name']")
    WebElement firstNameEmptyFieldMessage;

    @FindBy(xpath = "//span[@class='error error-last_name']")
    WebElement lastNameEmptyFieldMessage;

    @FindBy(xpath = "//*[contains(text(),'The email field is required.')]")
    WebElement emailEmptyFieldMessage;

    @FindBy(xpath = "//*[contains(text(),'The email format is invalid.')]")
    WebElement emailNotValidFieldMessage;

//    @FindBy(xpath = "//*[@id='hints[]']")
//    WebElement emailNotBeSharredMessage;

    @FindBy(xpath = "//*[contains(text(),'The zipcode field is required.')]")
    WebElement zipCodeEmptyFieldMessage;

    @FindBy(xpath = "//*[contains(text(),'Zipcode is invalid')]")
    WebElement zipCodeNotValidFieldMessage;

    //Labels
    @FindBy(xpath = "//*[@id='section-account']/div[1]//label")
    WebElement firstNameLabel;

//    @FindBy(xpath = "//*[@id='section-account']/div[2]//label")
//    WebElement lastNameLabel;
//
//    @FindBy(xpath = "//*[@id='section-account']/div[3]//label")
//    WebElement emailLabel;
//
//    @FindBy(xpath = "//*[@id='section-account']/div[4]/div/label")
//    WebElement zipCodeLabel;
//
//    @FindBy(xpath = "//*[@id='section-account']/div[5]/div/label")
//    WebElement companyLabel;

    public RutSignUPPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup/";
        PageFactory.initElements(driver, this);
    }
    public RutSignUPPage openSignUpPage() {
        //Log.info("Opening SignUp page");
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fields
    public RutSignUPPage fillFirstnameField(String firstname) {
        //Log.info("Filling firstname field");
        setElementText(firstNameField, firstname);
        return this;
    }
    public RutSignUPPage fillLastNameField(String lastname) {
        //Log.info("Filling lastname field");
        setElementText(lastNameField, lastname);
        return this;
    }
    public RutSignUPPage fillEmailField(String email) {
        //Log.info("Filling email field");
        setElementText(emailField, email);
        return this;
    }
    public RutSignUPPage fillZipCode1Field(String zipcode1) {
        //Log.info("Filling zipcode field");
        setElementText(zipCode1Field, zipcode1);
        return this;
    }
    public RutSignUPPage fillZipCode2Field(String zipcode2) {
        //Log.info("Filling zipplus field");
        setElementText(zipCode2Field, zipcode2);
        return this;
    }
    public RutSignUPPage fillCompanyField(String company) {
        //Log.info("Filling company field");
        setElementText(companyField, company);
        return this;
    }

    //Click the buttons
    public RutSignUPPage clickToContinue() {
        //Log.info("Filling continueButton field");
        clickElement(continueButton);
        return this;
    }
    public RutSignUPPage fillSignUPFields() {
        //Log.info("Filling all fields");
        openSignUpPage();
        fillFirstnameField("firstname");
        fillLastNameField("lastname");
        String email = generateEmail();
        fillEmailField(email);
        fillZipCode1Field("00501");
        fillZipCode2Field("11");
        fillCompanyField("company");
        return this;
    }
    private static String getRandomString(final int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return buf.toString();
    }
    public String generateEmail() {
        String rand = getRandomString(5);
        String username = rand + "@yopmail.com";
        // Log.info("User's Email generated is <" + username + ">");
        return username;
    }
//  check page for message
    public boolean checkFirstNameLabel() {
        return verifyTextBoolean(firstNameLabel, "First name");
    }
    public boolean checkFirstNameEmptyFieldMessage() {
        return verifyTextBoolean(firstNameEmptyFieldMessage, "The first name field is required.");
    }
    public boolean checkLastNameEmptyFieldMessage() {
        return verifyTextBoolean(lastNameEmptyFieldMessage, "The last name field is required.");
    }
    public boolean checkEmailEmptyFieldMessage() {
        return exists(emailEmptyFieldMessage);
    }
    public boolean checkEmailNotValidFieldMessage() {
        return exists(emailNotValidFieldMessage);
    }
    public boolean checkZipCodeEmptyFieldMessage() {
        return exists(zipCodeEmptyFieldMessage);
    }
    public boolean checkZipCodeNotValidFieldMessage() {
        return exists(zipCodeNotValidFieldMessage);
    }
    public boolean checkPageForCaptchaMessage() {
        return verifyTextBoolean(captchaMessage, "Please check Captcha!");
    }
//  wait for warning
    public void waitForFirstNameWarning() {
        waitUntilIsLoaded(firstNameEmptyFieldMessage);
    }
    public void waitForLastNameWarning() {
        waitUntilIsLoaded(lastNameEmptyFieldMessage);
    }
    public void waitForEmailWarning() {
        waitUntilIsLoaded(emailEmptyFieldMessage);
    }
    public void waitForZipCodeWarning() {
        waitUntilIsLoaded(zipCodeEmptyFieldMessage);
    }
    public void waitForCapchaWarning() {
        waitUntilIsLoaded(captchaMessage);
    }

}
