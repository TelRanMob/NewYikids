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

    //fields
    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    //buttons
    @FindBy(id = "//*[@id='login-form']/div/button")
    WebElement loginButton;

    @FindBy(id = "//*[@id='login-form']/div/a[1]")
    WebElement SignUpButton;

    @FindBy(id = "//*[@id='login-form']/div/a[2]")
    WebElement ForgotPasswordButton;

   /* //Labels
    @FindBy(xpath = "//*[@id='section-account']/div[1]/div/label")
    WebElement FirstNameLabel;
*/
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
        clickElement(SignUpButton);
        return this;
    }
    public IrinaLoginPage clickToForgotPasswordButton() {
        //Log.info("ForgotPassword");
        clickElement(ForgotPasswordButton);
        return this;
    }

    //illing all fields
    public IrinaLoginPage FillLodInFieldsPozitive() {
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
    public boolean IsOnLoginPage() {
        // Log.info(");
            return exists(emailField);
        }

    // public boolean CheckFirstNameLabel() {return verifyTextBoolean(FirstNameLabel, "First name");
    //}
}