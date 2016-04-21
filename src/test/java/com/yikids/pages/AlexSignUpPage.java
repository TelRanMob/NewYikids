package com.yikids.pages;

/*
 * Created by Alexandr on 03.04.2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Random;

/***
 * CLASS STARTS
 ***/

public class AlexSignUpPage extends Page {

    private static Random rnd = new Random();

    /* Fields */

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

    /* Buttons */

    @FindBy(id = "create-account")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id='topMenuNavigation']//a")
    WebElement logInButton;

    /* System messages */

    @FindBy(xpath = "//*[@class='error error-first_name']")
    WebElement firstnameEmptyFieldMessage;

    @FindBy(xpath = "//*[@class='error error-last_name']")
    WebElement lastnameEmptyFieldMessage;

    @FindBy(xpath = "//*[@class='error error-email']")
    WebElement emailEmptyORInvalidFieldMessage;

    @FindBy(xpath = "//*[@class='error error-zipcode']")
    WebElement zipcodeEmptyORInvalidFieldMessage;

    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement captchaErrorMessage;

    //Wrong - for DataDriven tests
    @FindBy(xpath = "//*[@id='section-account']/div[1]//div[2]/span[1]") WebElement firstnameWrongMessage;

    @FindBy(xpath = "//*[@id='section-account']/div[2]//div[2]/span[1]") WebElement lastnameWrongMessage;

    @FindBy(xpath = "//*[@id='section-account']/div[3]//div[2]/span[1]") WebElement emailWrongMessage;

    @FindBy(xpath = "//*[@id='section-account']/div[4]//div[2]/span[1]") WebElement zipcodeWrongMessage;

    /* Field labels */

    @FindBy(xpath = "//*[@id='section-account']/div[1]//label")
    WebElement firstNameLabel;

    @FindBy(xpath = "//*[@id='section-account']/div[2]//label")
    WebElement lastNameLabel;

    @FindBy(xpath = "//*[@id='section-account']/div[3]//label")
    WebElement emailLabel;

    @FindBy(xpath = "//*[@id='section-account']/div[4]//label")
    WebElement zipCodeLabel;

    @FindBy(xpath = "//*[@id='section-account']/div[5]//label")
    WebElement companyLabel;

    @FindBy(xpath = "//*[@id='recaptcha-anchor-label']")
    WebElement reCaptchaLabel;

    /* Methods */

    // Constructor and OpenPage.
    public AlexSignUpPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
        PageFactory.initElements(driver, this);
    }

    // Generate random emails.
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

    /* Fill the fields */

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

    // Manually for realisation in test class.
    public AlexSignUpPage FillSignUpPageFields() {
        String rndEmail = generateEmail();
        openSignUpPage();
        fillFirstnameField("testnameone");
        fillLastNameField("testsurnameone");
        fillEmailField(rndEmail);
        fillZip1Field("12341");
        fillZip21Field("5646");
        fillCompany1Field("testcompany");
        return this;
    }

    public String waitforWrongDataMessages(String number) throws IOException, InterruptedException {
        String locator = "//*[@id='section-account']/div["+number+"]//div[2]/span[1]";
        WebElement element = driver.findElement(By.xpath(locator));
        waitUntilElementIsLoaded(element);
        return element.getText();
    }

    /* Checks */

    // Empty Field messages. Captcha error message.
    public boolean checkforFirstNameEmptyFieldMessage() {
        return verifyTextBoolean(firstnameEmptyFieldMessage, "The first name field is required.");
    }

    public boolean checkforLastNameEmptyFieldMessage() {
        return verifyTextBoolean(lastnameEmptyFieldMessage, "The last name field is required.");
    }

    public boolean checkforEmailEmptyFieldMessage() {
        return verifyTextBoolean(emailEmptyORInvalidFieldMessage, "The email field is required.");
    }

    public boolean checkforEmailWrongFormatMessage() {
        return verifyTextBoolean(emailEmptyORInvalidFieldMessage, "The email format is invalid.");
    }

    public boolean checkforZipCodeEmptyFieldMessage() {
        return verifyTextBoolean(zipcodeEmptyORInvalidFieldMessage, "The zipcode field is required.");
    }

    public boolean checkforZipCodeInvalidFieldMessage() {
        return verifyTextBoolean(zipcodeEmptyORInvalidFieldMessage, "Zipcode is invalid");
    }

    public boolean checkforZipCodeWrongFormatMessage() {
        return verifyTextBoolean(zipcodeEmptyORInvalidFieldMessage, "The zipcode must be a number.");
    }

    public boolean checkforCapchaErrorMessage() {
        return verifyTextBoolean(captchaErrorMessage, "Please check Captcha!");
    }

    public void isOnSignUpPage() {
        exists(reCaptchaLabel);
    }

    // Page labels.
    public boolean checkforFirstNameLabel() {
        return verifyTextBoolean(firstNameLabel, "First name*");
    }

    public boolean checkforLastNameLabel() {
        return verifyTextBoolean(lastNameLabel, "Last name*");
    }

    public boolean checkforEmailLabel() {
        return verifyTextBoolean(emailLabel, "Email*");
    }

    public boolean checkforZipCodeLabel() {
        return verifyTextBoolean(zipCodeLabel, "Zip code*");
    }

    public boolean checkforCompanyLabel() {
        return verifyTextBoolean(companyLabel, "Company");
    }

    // Waiting.
    public void waitforFirstNameWarning() {
        waitUntilIsLoaded(firstnameEmptyFieldMessage);
    }

    public void waitforLastNameWarning() {
        waitUntilIsLoaded(lastnameEmptyFieldMessage);
    }

    public void waitforEmailWarning() {
        waitUntilIsLoaded(emailEmptyORInvalidFieldMessage);
    }

    public void waitforZipCodeWarning() {
        waitUntilIsLoaded(zipcodeEmptyORInvalidFieldMessage);
    }

    public void waitforCaptchaWarning() {
        waitUntilIsLoaded(captchaErrorMessage);
    }

    /*** CLASS ENDS ***/

}
