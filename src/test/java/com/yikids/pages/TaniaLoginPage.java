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

    @FindBy(id = "passwordField")
    WebElement passwordField;

  //  @FindBy(xpath="//*[@class='err']")// WebElement ErrorEmailNotExist;

    //Link Buttons
    @FindBy(xpath = "//*[@id='login-form']/div/button")
    WebElement logInLinkButton;

    @FindBy(xpath = "//*[@id='login-form']/div/a[1]")
    WebElement signUpLinkButton;

    @FindBy(xpath = "//*[@id='login-form']/div/a[2]")
    WebElement forgotPasswordLinkButton;

    @FindBy(xpath = "//*[@id='login-form']/div[1]")
    WebElement emailNotExistMessage;

    @FindBy(xpath = "//div[@class='err'][contains(text(),'Your passwordField is not correct. Please try again.')]")
    WebElement errorPasswordMessage;

/******//* On main page *//*********/
    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement LogOutLinkButton;
/*****/

    public TaniaLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/";
        PageFactory.initElements(driver, this);
    }

    //  public boolean CheckFirstNameLabel() {
    //     return verifyTextBoolean(FirstNameLabel, "First name");
    // }

    private static String getRandomString(final int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return buf.toString();
    }
    public boolean exists(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException ignored) {
            return false;
        }
    }
    public boolean CheckPageForNotLogIn() {
        return verifyTextBoolean(emailNotExistMessage, "Please sign up because your email does not exist in our system.");
    }


    public boolean checkWrongPassMessage() {

        return exists(emailNotExistMessage);
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
    public boolean isOnOverviewPage(){
        //Log.info("Filling username field");
        return exists(LogOutLinkButton);
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

    public TaniaLoginPage goToForgotPasswordLink() {
        //Log.info("Go to forgotPassword LinkButton");
        driver.get("http://admin.yikids.com/forgot-passwordField");
        return this;
    }


    public TaniaLoginPage FillWrongLogInFields() {
        //Log.info("Filling all fields");
        openLoginPage();
        String email = generateEmail();
        fillEmailField(email);
        fillpasswordField("307607");

        return this;
    }

    //filling all fields
    public TaniaLoginPage fillLoginFieldsPozitive() {
        fillEmailField("admin@erdocfinder.com");
        fillpasswordField("Test123");
        clickLogInLinkButton();
        return this;
    }


    public String generateEmail() {
        String rand = getRandomString(5);
        String username = rand + "@yopmail.com";
        // Log.info("Doctor's Username generated is <" + username + ">");
        return username;
    }

    public boolean passwordNotCorrect() {
        return exists(errorPasswordMessage);
    }
    public boolean emailNotCorrect(){ return exists(emailNotExistMessage);}

    //Implicity waits -methods on LogInPage

    public void waitForloginButton()    {
        waitUntilIsLoaded(logInLinkButton);
    }
    public void waitForlogOutButton()    {
        waitUntilIsLoaded(LogOutLinkButton);
    }
   /* public void waitForcontinueButtonOnSignUp()    {
        waitUntilIsLoaded(continueButton);
    }
    public void waitForResetPasswordButtom()    {
        waitUntilIsLoaded(resetPasswordButtom);
    }*/
    public void waitForErrorPasswordMessage()    {
        waitUntilIsLoaded(errorPasswordMessage);
    }
  /*  public void waitForPageSignUpTitle(){
       waitUntilIsLoaded(pageSignUpTitle);
    }
    public void waitForResetPasswordTitle()    {
        waitUntilIsLoaded(resetPasswordTitle);
    }
    public void waitForWarningLoginMessage(){
        waitUntilIsLoaded(warningLoginMessage);
    }*/


}