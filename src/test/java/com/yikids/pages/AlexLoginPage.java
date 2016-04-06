package com.yikids.pages;

/*
 * Created by Alexandr on 03.04.2016.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class AlexLoginPage extends Page {

    public static Random rnd;

    /* Fields */

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id='login-form']/div[1]")
    WebElement emailNotInBase;

    /* Buttons */

    @FindBy(xpath = "//*[@id='login-form']/div/button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id='login-form']/div/a[1]")
    WebElement signUpButton;

    @FindBy(xpath = "//*[@id='login-form']/div/a[2]")
    WebElement forgotPasswordButton;

    public AlexLoginPage(WebDriver driver) {

        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/";
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

    /* Methods */

    public AlexLoginPage OpenLoginPage() {

        driver.get(PAGE_URL);
        return this;

    }

    private String generateEmail() {

        String rand = getRandomString(5);
        String mail = rand + "@yopmail.com";
        return mail;

    }

    /* Fill Fields */

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

    public AlexLoginPage clickSignUpButton() {

        clickElement(signUpButton);
        return this;

    }

    public AlexLoginPage clickForgotPasswordButton() {

        clickElement(forgotPasswordButton);
        return this;

    }

    public AlexLoginPage fillLogin() {

        OpenLoginPage();
        String rndEmail = generateEmail();
        fillEmailField(rndEmail);
        fillPasswordField("TestPassword");
        return this;

    }

    /* Check */

    public boolean checkforEmailErrorText() {
        return verifyElementIsPresent(emailNotInBase);
    }

    public boolean checkforStillOnLoginPage() {
        return verifyElementIsPresent(loginButton)
                && verifyElementIsPresent(forgotPasswordButton)
                && verifyElementIsPresent(signUpButton);

    }

}
