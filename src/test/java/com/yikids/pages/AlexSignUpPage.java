package com.yikids.pages;

/*
 * Created by Alexandr on 03.04.2016.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class AlexSignUpPage extends Page {


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

/* System messages */

    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement CaptchaErrorMessage;

/* Field labels */

    @FindBy(xpath = "//*[@id='section-account']/div[5]//label")
    WebElement CompanyLabel;

/* methods */

    public AlexSignUpPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
        PageFactory.initElements(driver, this);
    }

    private static String getRandomString(int length) {

        String letters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(letters.charAt(rnd.nextInt(letters.length())));
        }

        return buf.toString();
    }

    public AlexSignUpPage openSignUpPage() {
        driver.get(PAGE_URL);
        return this;
    }

    private String generateEmail() {

        String rand = getRandomString(5);
        String mail = rand + "@yopmail.com";
        return mail;

    }

/* fill the fields */


    public AlexSignUpPage fillFirstnameField(String firstname) {
        setElementText(firstNameField, firstname);
        return this;
    }

    public AlexSignUpPage fillLastNameField(String lastname) {
        setElementText(lastNameField, lastname);
        return this;
    }

    public AlexSignUpPage fillEmailField(String email) {
        setElementText(emailField, email);
        return this;
    }

    public AlexSignUpPage fillZip1Field(String Zipone) {
        setElementText(zipCodeField, Zipone);
        return this;
    }

    public AlexSignUpPage fillZip21Field(String Ziptwo) {
        setElementText(zipCode2Field, Ziptwo);
        return this;
    }

    public AlexSignUpPage fillCompany1Field(String company) {
        setElementText(companyField, company);
        return this;
    }

    public AlexSignUpPage clickToContinue() {
        clickElement(continueButton);
        return this;
    }

    public AlexSignUpPage FillSignUp() {

        String rndEmail = generateEmail();
        openSignUpPage();
        fillFirstnameField("testnameone");
        fillLastNameField("testsurnameone");
        fillEmailField(rndEmail);
        fillZip1Field("0011");
        fillZip21Field("12");
        fillCompany1Field("testcompany");
        return this;

    }

    public boolean CheckForCapchaMessage() {
        return verifyTextBoolean(CaptchaErrorMessage, "Please check Captcha!");
    }

    public boolean CheckForCompanyLabel() {
        return verifyTextBoolean(CompanyLabel, "Company");
    }

}
