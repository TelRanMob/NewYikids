package com.yikids.pages;

/*
 * Created by Alexandr on 03.04.2016.
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlexLoginPage extends Page {

    /* Fields */

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    /* Buttons */

    @FindBy(xpath = "//*[@id='login-form']/div/button")
    WebElement loginButton;

    public AlexLoginPage(WebDriver driver) {

        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/";
        PageFactory.initElements(driver, this);

    }

    public AlexLoginPage OpenLoginPage() {

        driver.get(PAGE_URL);
        return this;

    }

    /* Methods */

    public AlexLoginPage FillEmailField(String email) {

        setElementText(emailField, email);
        return this;

    }

}
