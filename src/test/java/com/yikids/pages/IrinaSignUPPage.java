package com.yikids.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Irina Primak
 */
public class IrinaSignUPPage extends Page {
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
    WebElement captchaMessage;


    //buttons
    @FindBy(id = "create-account")
    WebElement continueButton;


    public IrinaSignUPPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
        PageFactory.initElements(driver, this);
    }


    public IrinaSignUPPage openSignUpPage() {
        //Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fields


    public IrinaSignUPPage fillFirstnameField(String username) {
        //Log.info("Filling username field");
        setElementText(firstNameField, username);
        return this;
    }

    public IrinaSignUPPage fillLastNameField(String lastname) {
        //Log.info("Filling username field");
        setElementText(lastNameField, lastname);
        return this;
    }

    public IrinaSignUPPage fillemailField(String email) {
        //Log.info("Filling username field");
        setElementText(emailField, email);
        return this;
    }

    public IrinaSignUPPage fillzipCodeField(String zipCode) {
        //Log.info("Filling username field");
        setElementText(zipCodeField, zipCode);
        return this;
    }

    public IrinaSignUPPage fillzipCod2Field(String zipCode2) {
        //Log.info("Filling username field");
        setElementText(zipCode2Field, zipCode2);
        return this;
    }

    public IrinaSignUPPage fillcompanyField(String company) {
        //Log.info("Filling username field");
        setElementText(companyField, company);
        return this;
    }

    public IrinaSignUPPage clickElemToContinue() {
        clickElement(continueButton);
        return this;
    }
    //fill all fields in one method
/*
    public IrinaSignUPPage fillSignUp() {
        fillFirstnameField("FirstName");
        fillLastNameField("LastName");
        fillcompanyField("Company");
        fillzipCodeField("1234");
        fillzipCod2Field("555");
        generateEmail();
        return this;
    }
*/
    // filling all fields in one place
    public IrinaSignUPPage fillSignUp() {
        setElementText(firstNameField, "FirstName");
        setElementText(lastNameField, "LastName");
        setElementText(zipCodeField, "1234");
        setElementText(zipCode2Field, "325");
        setElementText(companyField, "Company");
        setElementText(emailField, generateEmail());
        return this;
}
    //emailGeneration
    public String generateEmail() {
        String rand = getRandomString(5);
        String randEmail = rand + "@yopmail.com";
        return randEmail;
    }

    private static String getRandomString(Integer length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(chars);
        }
        return buf.toString();
    }

}