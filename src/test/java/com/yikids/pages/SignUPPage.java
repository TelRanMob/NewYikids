package com.yikids.pages;

/**
 * Created by Iakov Volf on 3/22/2016.
 */
//import com.telran.LogLog4j;
//import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

/**
 * Created by Iakov Volf
 */
public class SignUPPage extends Page {
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
    WebElement zipCodeField;

    @FindBy(id = "zip-plus")
    WebElement zipCode2Field;

    @FindBy(id = "company")
    WebElement companyField;

    //buttons
    @FindBy(id = "create-account")
    WebElement continueButton;

    //System messages
    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement CaptchaMessage;

    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement ErrorCaptcha;


    //Labels
    @FindBy(xpath = "//*[@id='section-account']/div[1]/div/label")
    WebElement FirstNameLabel;

    @FindBy(xpath = "//span[@class='error error-first_name']")
    WebElement firstNameEmptyFieldMessage;

    @FindBy(xpath = "//*[@id='contentContainer']/p[1]")
    WebElement signupLabelTitle;





    public SignUPPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
        PageFactory.initElements(driver, this);
    }

    private static String getRandomString(final int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return buf.toString();
    }

    //Fill the fields

    public SignUPPage openSignUpPage() {
        //Log.info("Opening SignUp page");
        driver.get(PAGE_URL);
        return this;
    }

    public SignUPPage fillFirstnameField(String username) {
        //Log.info("Filling username field");
        setElementText(firstNameField, username);
        return this;
    }

    public SignUPPage fillLastNameField(String lastname) {
        //Log.info("Filling username field");
        setElementText(lastNameField, lastname);
        return this;
    }

    public SignUPPage fillEmailField(String lastname) {
        //Log.info("Filling username field");
        setElementText(emailField, lastname);
        return this;
    }

    public SignUPPage fillZip1Field(String lastname) {
        //Log.info("Filling username field");
        setElementText(zipCodeField, lastname);
        return this;
    }

    public SignUPPage fillZip21Field(String lastname) {
        //Log.info("Filling username field");
        setElementText(zipCode2Field, lastname);
        return this;
    }

    public SignUPPage fillCompany1Field(String lastname) {
        //Log.info("Filling username field");
        setElementText(companyField, lastname);
        return this;
    }

    public SignUPPage clickToContinue() {
        //Log.info("Filling username field");
        clickElement(continueButton);
        return this;
    }

    public SignUPPage FillsignUPFields() {
        //Log.info("Filling all fields");
        openSignUpPage();
        fillFirstnameField("username");
        fillLastNameField("lastname");
        String email = generateEmail();
        fillEmailField(email);
        fillZip1Field("0011");
        fillZip21Field("12");
        fillCompany1Field("company");
        return this;
    }

    public String generateEmail() {
        String rand = getRandomString(5);
        String username = rand + "@yopmail.com";
        // Log.info("Doctor's Username generated is <" + username + ">");
        return username;
    }

    public boolean isOnSignupPage() {
        return exists(signupLabelTitle);
    }

    public void waitForFirstNameWarning() {
        waitUntilIsLoaded(firstNameEmptyFieldMessage);
    }

    public boolean CheckPageForCapthcaMessage() {
        return verifyTextBoolean(ErrorCaptcha, "Please check Captcha!");
    }

    public boolean CheckFirstNameLabel() {
        return verifyTextBoolean(FirstNameLabel, "First name");
    }


    public boolean checkfirstNameEmptyFieldMessage() {
        return verifyTextBoolean(firstNameEmptyFieldMessage, "The first name field is required.");
    }


}