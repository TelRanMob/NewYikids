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

    /* fields */
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

    /* buttons */
    @FindBy(id = "create-account")
    WebElement continueButton;

    /* ErrorCaptcha */
    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement ErrorCaptcha;

    /* Labels */
    @FindBy(xpath = "//*[@id='section-account']/div[5]//label")
    WebElement companyLabel;

    @FindBy(xpath = "//*[@id='section-account']/div[4]//label")
    WebElement zipCodeLabel;

    @FindBy(xpath = "//*[@id='section-account']/div[3]//label")
    WebElement emailLabel;

    @FindBy(xpath = "//*[@id='section-account']/div[2]//label")
    WebElement lastNameLabel;

    @FindBy(xpath = "//*[@id='section-account']/div[1]//label")
    WebElement firstNameLabel;

    @FindBy(xpath = "//form[@id='section-account']/div[2]//div/span")
    WebElement firstNameSpan;

    /* Methods */

    public TaniaSignUPPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
        PageFactory.initElements(driver,this);
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

    public String generateEmail() {
        String rand = getRandomString(5);
        String username = rand + "@yopmail.com";
        // Log.info("Doctor's Username generated is <" + username + ">");
        return username;
    }

    /* Fill the fields */

    public TaniaSignUPPage opentaniaSignUPPage() {
        //Log.info("Opening SignUp page");
        driver.get(PAGE_URL);
        return this;
    }

    public TaniaSignUPPage fillFirstnameField(String username) {
        //Log.info("Filling username field");
        setElementText(firstNameField,username);
        return this;
    }

    public TaniaSignUPPage fillLastNameField(String lastname) {
        //Log.info("Filling username field");
        setElementText(lastNameField,lastname);
        return this;
    }

    public TaniaSignUPPage fillemailField(String email) {
        //Log.info("Filling username field");
        setElementText(emailField,email);
        return this;
    }

    public TaniaSignUPPage fillzipcodeField(String zipcode) {
        //Log.info("Filling username field");
        setElementText(zipCodeField,zipcode);
        return this;
    }

    public TaniaSignUPPage fillzipCode2Field(String zipcode2) {
        //Log.info("Filling username field");
        setElementText(zipCode2Field,zipcode2);
        return this;
    }

    public TaniaSignUPPage fillcompanyField(String companyName) {
        //Log.info("Filling username field");
        setElementText(companyField,companyName);
        return this;
    }

    /* Click  'Continue'  Button */
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

    public void waitForWarningFirstNameEmpty() {
        waitUntilIsLoaded(firstNameSpan);
    }

    public boolean CheckPageForCapthcaMessage() {
        return verifyTextBoolean(ErrorCaptcha,"Please check Captcha!");
    }


    public boolean checkFirstNameSpan(){return verifyTextBoolean(firstNameSpan, "The first name field is required.");}

    public boolean checkforCompanyLabel() {
        return verifyTextBoolean(companyLabel, "Company");
    }

    public boolean checkforZipCodeLabel() {
        return verifyTextBoolean(zipCodeLabel, "Zip code*");
    }

    public boolean checkforEmailLabel() {
        return verifyTextBoolean(emailLabel, "Email*");
    }

    public boolean checkforLastNameLabel() {
        return verifyTextBoolean(lastNameLabel, "Last name*");
    }

    public boolean checkforFirstNameLabel() {
        return verifyTextBoolean(firstNameLabel, "First name*");
    }


    public TaniaSignUPPage checkelement(String error){
        verifyText(ErrorCaptcha, error);
        return this;
    }
}