package com.yikids.pages;


//import com.telran.LogLog4j;
//import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;


public class ElenaSignUPPage extends Page {
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
    WebElement ErrorCaptcha;
    //Labels
    @FindBy(xpath = "//*[@id='section-account']/div[1]/div/label")
    WebElement FirstNameLabel;
    @FindBy(xpath = "//*[@id='section-account']/div[2]/div/label")
    WebElement LastNameLabel;
    @FindBy(xpath = "//*[@id='section-account']/div[3]/div/label")
    WebElement EmailLabel;
    @FindBy(xpath = "//*[@id='section-account']/div[4]/div/label")
    WebElement ZipCodLabel;
    @FindBy(xpath = "//*[@id='section-account']/div[5]/div/label")
    WebElement CompanyLabel;


    public ElenaSignUPPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
        PageFactory.initElements(driver, this);
    }

    public ElenaSignUPPage openElenaSignUPPage() {
        //Log.info("Opening ElenaSignUPPage page");
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


    public ElenaSignUPPage fillFirstnameField(String username) {
        //Log.info("Filling username field");
        setElementText(firstNameField, username);
        return this;
    }

    public ElenaSignUPPage fillLastNameField(String lastname) {
        //Log.info("Filling username field");
        setElementText(lastNameField, lastname);
        return this;
    }
    public ElenaSignUPPage fillemailField(String email) {
        //Log.info("Filling username field");
        setElementText(emailField, email);
        return this;
    }
    public ElenaSignUPPage fillzipcodeField(String zipcode) {
        //Log.info("Filling username field");
        setElementText(zipCodeField, zipcode);
        return this;
    }
    public ElenaSignUPPage fillzipCode2Field(String zipcode2) {
        //Log.info("Filling username field");
        setElementText(zipCode2Field, zipcode2);
        return this;
    }
    public ElenaSignUPPage fillcompanyField(String companyName) {
        //Log.info("Filling username field");
        setElementText(companyField, companyName);
        return this;
    }
//click button
    public ElenaSignUPPage buttoncontinueButton( ) {
        //Log.info("Filling username field");
        clickElement(continueButton);
        return this;
    }
    public ElenaSignUPPage checkelement(String error){
        verifyText(ErrorCaptcha, error);
        return this;
    }
    public String generateEmail() {
        String rand = getRandomString(5);
        String username = rand + "@yopmail.com";
        // Log.info("Doctor's Username generated is <" + username + ">");
        return username;
    }
    public ElenaSignUPPage FillsignUPFields() {
        //Log.info("Filling all fields");
        openElenaSignUPPage();
        fillFirstnameField("username");
        fillLastNameField("lastname");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("0011");
        fillzipCode2Field("12");
        fillcompanyField("company");
        return this;
    }

    public boolean CheckPageForCapthcaMessage() {
        return verifyElementIsPresent(ErrorCaptcha);
    }

    public boolean CheckFirstNameLabel() {
        return verifyTextBoolean(FirstNameLabel, "First name*");
    }
    public boolean CheckLastNameLabel() {
        return verifyTextBoolean(LastNameLabel, "Last name*");
    }
    public boolean CheckEmailLabel() {
        return verifyTextBoolean(EmailLabel, "Email*");
    }
    public boolean CheckZipCodeLabel() {
        return verifyTextBoolean(ZipCodLabel, "Zip code*");
    }
    public boolean CheckCompanyNameLabel() {
        return verifyTextBoolean(CompanyLabel, "Company");
    }
    public String gettext() {
        return getTextElement(CompanyLabel);
    }

}