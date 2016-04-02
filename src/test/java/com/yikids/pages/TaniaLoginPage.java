package com.yikids.pages;

/**
 * Created by Tania Pereminski on 4/01/2016.
 */
//import com.telran.LogLog4j;
//import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

/**
 * Created by Tania Pereminski
 */
public class TaniaLoginPage extends Page {
    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static Random rnd = new Random();

    //fields
    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    //Link Buttons
    @FindBy(xpath = "//*[@id=\"login-form\"]/div/button")
    WebElement logInLinkButton;

    @FindBy(xpath = "//*[@id=\"login-form\"]/div/a[1]")
    WebElement signUpLinkButton;

    @FindBy(xpath = "//*[@id=\"login-form\"]/div/a[2]")
    WebElement forgotPasswordLinkButton;

    @FindBy(xpath = "//*[@id=\"login-form\"]/div[1]")
    WebElement emailNotExist;


    public boolean CheckPageForNotLogIn() {
        return verifyTextBoolean(emailNotExist, "Please sign up because your email does not exist in our system.");
    }

  //  public boolean CheckFirstNameLabel() {
   //     return verifyTextBoolean(FirstNameLabel, "First name");
   // }


    public TaniaLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/";
        PageFactory.initElements(driver, this);
    }

    private static String getRandomString(final int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return buf.toString();
    }

    //Fill the fields

    public TaniaLoginPage openLoginPage() {
        //Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }

    public boolean isOnLoginPage(){
        //Log.info("Filling username field");
        return exists(emailField);
    }

    public TaniaLoginPage fillEmailField(String email) {
        //Log.info("Filling username field");
        setElementText(emailField, email);
        return this;
    }

    public TaniaLoginPage fillpasswordField(String password) {
        //Log.info("Filling username field");
        setElementText(passwordField, password);
        return this;
    }


    public TaniaLoginPage clickLogInLinkButton() {
        //Log.info("Click log-In LinkButton");
        clickElement(logInLinkButton);
        return this;
    }

    public TaniaLoginPage clickSignUpLinkButton() {
        //Log.info("Click signUp LinkButton");
        clickElement(signUpLinkButton);
        return this;
    }
    public TaniaLoginPage clickForgotPasswordLinkButton() {
        //Log.info("Click forgotPassword LinkButton");
        clickElement(forgotPasswordLinkButton);
        return this;
    }


    public TaniaLoginPage FillLogInFields() {
        //Log.info("Filling all fields");
        openLoginPage();
        String email = generateEmail();
        fillEmailField(email);
        fillpasswordField("307607");

        return this;
    }

    public String generateEmail() {
        String rand = getRandomString(5);
        String username = rand + "@yopmail.com";
        // Log.info("Doctor's Username generated is <" + username + ">");
        return username;
    }
}