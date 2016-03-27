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

/**
 * Created by Iakov Volf
 */
public class SignUPPage extends Page {
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

    //System messages
    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement CaptchaMessage;


    public SignUPPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
        PageFactory.initElements(driver, this);
    }

    public SignUPPage openSignUpPage() {
        //Log.info("Opening SignUp page");
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fields


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

    public SignUPPage fillEmsilField(String lastname) {
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

}