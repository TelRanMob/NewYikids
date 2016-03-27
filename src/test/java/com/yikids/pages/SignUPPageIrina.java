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
public class SignUPPageIrina extends Page {
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

    //System messages
    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement CaptchaMessage;


    //buttons
    @FindBy(id = "create-account")
    WebElement continueButton;



    public SignUPPageIrina(WebDriver driver) {
            super(driver);
            this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
            PageFactory.initElements(driver, this);
        }


    public SignUPPageIrina openLoginPage() {
        //Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fields


    public SignUPPageIrina fillFirstnameField(String username) {
        //Log.info("Filling username field");
        setElementText(firstNameField, username);
        return this;
    }

    public SignUPPageIrina fillLastNameField(String lastname) {
        //Log.info("Filling username field");
        setElementText(lastNameField, lastname);
        return this;
    }

    public SignUPPageIrina fillemailField(String email) {
        //Log.info("Filling username field");
        setElementText(emailField, email);
        return this;
    }

    public SignUPPageIrina fillzipCodeField(String zipCode) {
        //Log.info("Filling username field");
        setElementText(zipCodeField, zipCode);
        return this;
    }
    public SignUPPageIrina fillzipCod2Field(String zipCode2) {
        //Log.info("Filling username field");
        setElementText(zipCode2Field, zipCode2);
        return this;
    }
    public SignUPPageIrina fillcompanyField(String company) {
        //Log.info("Filling username field");
        setElementText(companyField, company);
        return this;
    }
    public SignUPPageIrina clickCaptcha(){
        clickElement(CaptchaMessage);
        return this;
    }
    public SignUPPageIrina clickElemToContinue (){
        clickElement(continueButton);
        return this;
    }

}