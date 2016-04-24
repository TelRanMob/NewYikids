package com.yikids.pages;

/*
 * Created by Alexandr on 03.04.2016.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

/***
 * CLASS STARTS
 ***/

public class AlexLoginPage extends Page {

    private static Random rnd = new Random();
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "password")
    WebElement passwordField;

    /* Fields */
    @FindBy(xpath = "//*[@class='container']/form[@action='reset']/input[@id='email']")
    WebElement forgotpasswordEmailField;
    @FindBy(xpath = "//*[@id='login-form']/a[2]")
    WebElement forgotpasswordEmailLabel;
    @FindBy(xpath = "//*[@id='login-form']//button")
    WebElement loginButton;
    @FindBy(xpath = "//*[@id='login-form']/div/a[1]")
    WebElement signUpLink;

    /* Buttons and links */
    @FindBy(xpath = "//*[@id='login-form']/div/a[2]")
    WebElement forgotPasswordLink;
    @FindBy(xpath = "//*[@id='login-form']/div[1]/a")
    WebElement wrongPasswordForgotPasswordLink;
    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement mainpageLogOutLink;
    @FindBy(xpath = "//*[@id='zipcode']")
    WebElement signuppageZipCodeField;
    @FindBy(xpath = "html/body/div[2]/form/button")
    WebElement forgotpasswordpageResetButton;
    @FindBy(xpath = "//*[@id='login-form']/div[1]")
    WebElement titleEmailPasswordWarningMessage;
    private String login = "admin@erdocfinder.com";

    /* System messages */
    private String pass = "Test123";

    /* Methods */

    // Constructor and OpenPage.
    public AlexLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/";
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

    public AlexLoginPage OpenLoginPage() {
        driver.get(PAGE_URL);
        return this;
    }

    private String generateEmail() {
        String rand = getRandomString(5);
        String mail = rand + "@yopmail.com";
        return mail;
    }

    /* Fill the fields */

    public AlexLoginPage fillEmailField(String email) {
        setElementText(emailField, email);
        return this;
    }

    public AlexLoginPage fillPasswordField(String password) {
        setElementText(passwordField, password);
        return this;
    }

    public AlexLoginPage clickLoginButton() {
        clickElement(loginButton);
        return this;
    }

    public AlexLoginPage clickSignUpLink() {
        clickElement(signUpLink);
        return this;
    }

    public AlexLoginPage clickForgotPasswordLink() {
        clickElement(forgotPasswordLink);
        return this;
    }

    public AlexLoginPage clickForgotPasswordAfterPasswordWarning() {
        clickElement(wrongPasswordForgotPasswordLink);
        return this;
    }

    public AlexLoginPage fillLoginPageFields() {
        OpenLoginPage();
        String rndEmail = generateEmail();
        fillEmailField(rndEmail);
        fillPasswordField("TestPassword");
        return this;
    }

    public AlexLoginPage positiveLogIn() {
        OpenLoginPage();
        fillEmailField(login);
        fillPasswordField(pass);
        return this;
    }

    /* Check */

    // Wrong field messages.
    public boolean checkforWrongEmail() {
        return verifyTextBoolean(titleEmailPasswordWarningMessage,
                "Please sign up because your email does not exist in our system.");
    }

    public boolean checkforWrongPassword() {
        return verifyTextBoolean(titleEmailPasswordWarningMessage,
                "Your passwordField is not correct. Please try again. Forgot passwordField?");
    }

    public boolean checkforForgotPasswordEmailLabel() {
        return verifyTextBoolean(forgotpasswordEmailLabel,
                "Enter your email");
    }


    // Going on relation pages.
    public boolean isOnLoginPage() {
        exists(loginButton);
        return true;
    }

    public boolean isOnMainPage() {
        exists(mainpageLogOutLink);
        return true;
    }

    public boolean isOnSignUpPage() {
        exists(signuppageZipCodeField);
        return true;
    }

    public boolean isOnForgotPasswordPage() {
        exists(forgotpasswordpageResetButton);
        return true;
    }

    // Waiting.
    public void waitforPasswordWarningMessage() {
        waitUntilIsLoaded(titleEmailPasswordWarningMessage);
    }

    public void waitforLogOutLink() {
        waitUntilIsLoaded(mainpageLogOutLink);
    }

    public void waitforZipCodeField() {
        waitUntilIsLoaded(signuppageZipCodeField);
    }

    public void waitforResetButton() {
        waitUntilIsLoaded(forgotpasswordpageResetButton);
    }

    /*** CLASS ENDS ***/

}
