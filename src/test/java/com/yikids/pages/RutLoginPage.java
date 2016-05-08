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

public class RutLoginPage extends Page {
    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    //fields
    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    //buttons
    @FindBy(xpath = "//button[@class='btn btn-link']")
    WebElement loginLinkButton;

    @FindBy(xpath = "//*[@id='login-form']/div/a[1]")
    WebElement signUpLinkButton;

    @FindBy(xpath = "//*[@id='login-form']/div/a[2]")
    WebElement forgotPasswordLinkButton;

    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement logOutLinkButton;

    @FindBy(xpath = "//*[@id='login-form']/div[1]/a")
    WebElement forgotPasswordButton;

    //labels
    @FindBy(xpath = "//body/div[2]/h1")
    WebElement titleForgotPasswordPageLabel;

    @FindBy(xpath = "//p[@class='title']")
    WebElement titleSignUpPageLabel;

    //message
    @FindBy(xpath = "//div[@class='err']")
    WebElement emailNotValid;

    @FindBy(xpath = "//div[@class='err'][contains(text(),'Your passwordField is not correct. Please try again.')]")
    WebElement passwordNotValid;

    public RutLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/";
        PageFactory.initElements(driver, this);
    }

    public RutLoginPage openLoginPage() {
        //Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fields
    public RutLoginPage fillEmailField(String email) {
        //Log.info("Filling email field");
        setElementText(emailField, email);
        return this;
    }

    public RutLoginPage fillPasswordField(String password) {
        //Log.info("Filling passwordField field");
        setElementText(passwordField, password);
        return this;
    }

    //Click the buttons
    public RutLoginPage clickLoginButton() {
        //Log.info("Click login button");
        clickElement(loginLinkButton);
        return this;
    }

    public RutLoginPage clickSignUpButton() {
        //Log.info("Click signUp button");
        clickElement(signUpLinkButton);
        return this;
    }

    public RutLoginPage clickForgotPasswordButton() {
        //Log.info("Click forgotPassword button");
        clickElement(forgotPasswordLinkButton);
        return this;
    }

    //check is on page
    public boolean isOnLoginPage() {
        //Log.info("Click forgotPassword button");
        return exists(loginLinkButton);
    }

    public boolean isOnOverviewPage() {
        //Log.info("Click forgotPassword button");
        return exists(logOutLinkButton);
    }

    public boolean isOnSignUpPage() {
        //Log.info("Click forgotPassword button");
        return exists(titleSignUpPageLabel);
    }

    public boolean isOnForgotPasswordPage() {
        //Log.info("Click forgotPassword button");
        return exists(titleForgotPasswordPageLabel);
    }

    //wait
    public void waitForLogOutLinkButton(){
        waitUntilIsLoaded(logOutLinkButton);
    }

    //check error message
    public boolean checkEmailNotValidMessage() {
        return verifyTextBoolean(emailNotValid, "Please sign up because your email does not exist in our system.");
    }

    public boolean checkForgotPasswordMessage() {
        return verifyTextBoolean(forgotPasswordButton, "Forgot passwordField?");
    }

    public boolean checkPasswordNotValidMessage() {
        return exists(passwordNotValid);
    }

    public RutLoginPage login(){
        fillEmailField("admin@erdocfinder.com");
        fillPasswordField("Test123");
        clickLoginButton();
        waitForLogOutLinkButton();
        return this;
    }
    //    wait for warning
//     waitUntilIsLoaded(firstNameEmptyFieldMessage);
//    }
}
