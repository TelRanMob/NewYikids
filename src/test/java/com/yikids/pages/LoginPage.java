package com.yikids.pages;

/**
 * Created by Iakov Volf on 4/01/2016.
 */
//import com.telran.LogLog4j;
//import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

/**
 * Created by Iakov Volf
 */
public class LoginPage extends Page {
    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static Random rnd = new Random();

    //fields
    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id='login-form']/div/button")
    WebElement logInLink;


    //System messages
    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement CaptchaMessage;

    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement ErrorCaptcha;


    //Labels
    @FindBy(xpath = "//*[@id='section-account']/div[1]/div/label")
    WebElement FirstNameLabel;

    public LoginPage(WebDriver driver) {
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

    public LoginPage openLoginPage() {
        //Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }


    public boolean isOnLoginPage() {
        //Log.info("Filling username field");
        return exists(emailField);
    }

    public LoginPage fillEmailField(String lastname) {
        //Log.info("Filling username field");
        setElementText(emailField, lastname);
        return this;
    }


}