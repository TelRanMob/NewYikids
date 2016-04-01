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
    WebElement zip1CodeField;

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

    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement errorCaptcha;

    //Labels
    @FindBy(xpath = "//*[@id='section-account']/div[1]/div/label")
    WebElement firstNameLabel;

    public RutSignUPPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
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
    public RutSignUPPage fillZip1CodeField(String zipcode) {
        //Log.info("Filling zipcode field");
        setElementText(zip1CodeField, zipcode);
        return this;
    }
    public RutSignUPPage fillZip2CodeField(String zipplus) {
        //Log.info("Filling zipplus field");
        setElementText(zipCode2Field, zipplus);
        return this;
    }
    public RutSignUPPage fillCompanyField(String company) {
        //Log.info("Filling company field");
        setElementText(companyField, company);
        return this;
    }

    //Fill the buttons
    public RutSignUPPage clickContinueButton() {
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
        fillZip1CodeField("0011");
        fillZip2CodeField("12");
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
    public boolean CheckPageForCapthcaMessage() {
        return verifyTextBoolean(errorCaptcha, "Please check Captcha!");
    }
    public boolean CheckFirstNameLabel() {
        return verifyTextBoolean(firstNameLabel, "First name");
    }
}
