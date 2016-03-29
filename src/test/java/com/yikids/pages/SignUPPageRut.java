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

public class SignUPPageRut extends Page {
    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

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

    public SignUPPageRut(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
        PageFactory.initElements(driver, this);
    }

    public SignUPPageRut openSignUpPage() {
        //Log.info("Opening SignUp page");
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fields
    public SignUPPageRut fillFirstnameField(String firstname) {
        //Log.info("Filling firstname field");
        setElementText(firstNameField, firstname);
        return this;
    }
    public SignUPPageRut fillLastNameField(String lastname) {
        //Log.info("Filling lastname field");
        setElementText(lastNameField, lastname);
        return this;
    }
    public SignUPPageRut fillEmailField(String email) {
        //Log.info("Filling email field");
        setElementText(emailField, email);
        return this;
    }
    public SignUPPageRut fillZip1CodeField(String zipcode) {
        //Log.info("Filling zipcode field");
        setElementText(zip1CodeField, zipcode);
        return this;
    }
    public SignUPPageRut fillZip2CodeField(String zipplus) {
        //Log.info("Filling zipplus field");
        setElementText(zipCode2Field, zipplus);
        return this;
    }
    public SignUPPageRut fillCompanyField(String company) {
        //Log.info("Filling company field");
        setElementText(companyField, company);
        return this;
    }
    //Fill the buttons
    public SignUPPageRut clickContinueButton() {
        //Log.info("Filling continueButton field");
        clickElement(continueButton);
        return this;
    }

}
