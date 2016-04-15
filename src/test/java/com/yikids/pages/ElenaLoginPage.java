package com.yikids.pages;

/**
 * Created by Elelena Sosnitsky on 01/04/2016.
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;


public class ElenaLoginPage extends Page {
    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static Random rnd = new Random();


    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwordField")
    WebElement psswordField;

    @FindBy(xpath="//*[@class='err']")
    WebElement ErrorEmail;

    @FindBy(xpath = "//div[@class='err'][contains(text(),'Your passwordField is not correct. Please try again.')]")
    WebElement errorPasswordMessage;

    //buttons
    @FindBy(xpath = "//*[@id='login-form']/div/button")
    WebElement LoginButton;
    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement LogOutButton;

    public ElenaLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/";
        PageFactory.initElements(driver, this);
    }



    //Fill the fields

    public ElenaLoginPage openLoginPage() {
        //Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }


    public ElenaLoginPage fillEmailField(String email) {
        //Log.info("Filling username field");
        setElementText(emailField, email);
        return this;
    }
     public ElenaLoginPage Login() {

         fillEmailField("admin@erdocfinder.com");
         fillPasswordField("Test123");
         ClickLoginButton();
         return this;
     }


    public ElenaLoginPage fillPasswordField(String password) {
        //Log.info("Filling username field");
        setElementText(psswordField, password);
        return this;
    }

    public String gettext() {
        return getTextElement(ErrorEmail);
    }

    //click button
    public ElenaLoginPage ClickLoginButton( ) {
        //Log.info("Filling username field");
        clickElement(LoginButton);
        return this;
    }

    public boolean CheckTextOfElementLogOut() {
        return verifyTextBoolean(LogOutButton, "Log Out");
    }
    public boolean CheckElementLogOu() {
        return verifyElementIsPresent(LogOutButton);
    }

    public boolean CheckTextErrorEmail() {
        return verifyTextBoolean(ErrorEmail, "Please sign up because your email does not exist in our system.");
    }

    public boolean CheckElementLogIn() {
        return exists(LoginButton);
        }

    public boolean passwordNotCorrect() {
        return exists(errorPasswordMessage);
    }


    }


