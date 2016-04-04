package com.yikids.pages;

/**
 * Created by Irina Primak on 4/01/2016.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class IrinaLoginPage extends Page {
    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static Random rnd = new Random();
    public String PAGE_URL;

    //fields
    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    //buttons
    @FindBy(id = "//*[@id='login-form']/div/button")
    WebElement loginButton;

    @FindBy(id = "//*[@id='logout-container']/a")
    WebElement logOutButton;

    @FindBy(id = "//*[@id='login-form']/div/a[1]")
    WebElement signUpButton;

    @FindBy(id = "//*[@id='login-form']/div/a[2]")
    WebElement forgotPasswordButton;

    //Labels
    @FindBy(xpath = "//*[@id='login-form']/div[1]")
    WebElement errorPasswordMessage;

    @FindBy(xpath = "//*[@id='contentContainer']/p[1]")
    WebElement pageSignUpTitle;

    @FindBy(xpath = "//*[@id='contentContainer']/p")
    WebElement resetPasswordTitle;

    public IrinaLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/";
        PageFactory.initElements(driver, this);
    }

    //Open Page
    public IrinaLoginPage openLoginPage() {
        //Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fields


    public IrinaLoginPage fillEmailField(String email) {
        //Log.info("Filling email field");
        setElementText(emailField, email);
        return this;
    }

    public IrinaLoginPage fillPasswordField(String password) {
        //Log.info("Filling password field");
        setElementText(passwordField, password);
        return this;
    }

    public IrinaLoginPage clickToLoginButton() {
        //Log.info("LogIn");
        clickElement(loginButton);
        return this;
    }

    public IrinaLoginPage clickToSignUpButton() {
        //Log.info("SignUp");
        clickElement(signUpButton);
        return this;
    }

    public IrinaLoginPage clickToForgotPasswordButton() {
        //Log.info("ForgotPassword");
        clickElement(forgotPasswordButton);
        return this;
    }

    //illing all fields
    public IrinaLoginPage fillLodInFieldsPozitive() {
        fillEmailField("admin@erdocfinder.com");
        fillPasswordField("Test123");
        clickToLoginButton();
        return this;
    }

    private static String getRandomString(final int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return buf.toString();
    }

    public String generateEmail() {
        String rand = getRandomString(5);
        String username = rand + "@yopmail.com";
        // Log.info("Doctor's Username generated is <" + username + ">");
        return username;
    }

    //verification methods
    public boolean isOnLoginPage() {
        // Log.info(");
        return exists(loginButton);
    }

    public boolean loginned() {
        // Log.info(");
        return exists(logOutButton);
    }

    public boolean passwordNotCorrect() {
        return verifyTextBoolean(errorPasswordMessage, "Your password is not correct. Please try again. Forgot password?");
    }

    public boolean checkPageSignUpOpen() {
        return verifyTextBoolean(pageSignUpTitle, "Step one of finding your physicians");
    }
    public boolean checkPageResetPassword() {
        return verifyTextBoolean(resetPasswordTitle, "Reset Password");

    }

        // public boolean CheckFirstNameLabel() {return verifyTextBoolean(FirstNameLabel, "First name");
        //}
    }
