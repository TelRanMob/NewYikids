package com.yikids.pages;


//import com.telran.LogLog4j;
//import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ElenaSignUPPage extends Page {
    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


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
}