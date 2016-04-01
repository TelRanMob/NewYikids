package com.yikids.pages;

/**
 * Created by Tania Pereminski on 3/22/2016.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Tania Pereminski
 */


//import com.telran.LogLog4j;
//import org.apache.log4j.Logger;


import java.util.Random;


public class TaniaSignUPPage extends Page {
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

    //ErrorCaptcha
    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement ErrorCaptcha;


    //Labels
    @FindBy(xpath = "//*[@id='section-account']/div[1]/div/label")
    WebElement FirstNameLabel;

    public TaniaSignUPPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
        PageFactory.initElements(driver, this);
    }

    public TaniaSignUPPage openTaniaSignUPPage() {
        //Log.info("Opening TaniaSignUPPage page");
        driver.get(PAGE_URL);
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

    //Fill the fields
    public TaniaSignUPPage opentaniaSignUPPage() {
        //Log.info("Opening SignUp page");
        driver.get(PAGE_URL);
        return this;
    }


    public TaniaSignUPPage fillFirstnameField(String username) {
        //Log.info("Filling username field");
        setElementText(firstNameField, username);
        return this;
    }

    public TaniaSignUPPage fillLastNameField(String lastname) {
        //Log.info("Filling username field");
        setElementText(lastNameField, lastname);
        return this;
    }
    public TaniaSignUPPage fillemailField(String email) {
        //Log.info("Filling username field");
        setElementText(emailField, email);
        return this;
    }
    public TaniaSignUPPage fillzipcodeField(String zipcode) {
        //Log.info("Filling username field");
        setElementText(zipCodeField, zipcode);
        return this;
    }
    public TaniaSignUPPage fillzipCode2Field(String zipcode2) {
        //Log.info("Filling username field");
        setElementText(zipCode2Field, zipcode2);
        return this;
    }
    public TaniaSignUPPage fillcompanyField(String companyName) {
        //Log.info("Filling username field");
        setElementText(companyField, companyName);
        return this;
    }

    public TaniaSignUPPage clickToContinue() {
        //Log.info("Filling username field");
        clickElement(continueButton);
        return this;
    }

    public TaniaSignUPPage FillsignUPFields() {
        //Log.info("Filling all fields");
        opentaniaSignUPPage();
        fillFirstnameField("username");
        fillLastNameField("lastname");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("0011");
        fillzipCode2Field("12");
        fillcompanyField("company");
        return this;
    }

    public String generateEmail() {
        String rand = getRandomString(5);
        String username = rand + "@yopmail.com";
        // Log.info("Doctor's Username generated is <" + username + ">");
        return username;
    }

    public boolean CheckPageForCapthcaMessage() {
        return verifyTextBoolean(ErrorCaptcha, "Please check Captcha!");
    }

    public boolean CheckFirstNameLabel() {
        return verifyTextBoolean(FirstNameLabel, "First name");
    }

    //click button
    public TaniaSignUPPage buttoncontinueButton( ) {
        //Log.info("Filling username field");
        clickElement(continueButton);
        return this;
    }
    public TaniaSignUPPage checkelement(String error){
        verifyText(ErrorCaptcha, error);
        return this;
    }
}