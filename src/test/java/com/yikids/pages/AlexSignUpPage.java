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
    WebElement captchaErrorMessage;

/* Field labels */

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

/* methods */

    public AlexSignUpPage(WebDriver driver) {

        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
        PageFactory.initElements(driver, this);

    }

    private static String getRandomString(final int length) {

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

    public boolean checkforCapchaMessage() {
        return verifyTextBoolean(captchaErrorMessage, "Please check Captcha!");
    }

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

}
