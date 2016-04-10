package com.yikids.pages;

/*
 * Created by Alexandr on 08.04.2016.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/***
 * CLASS STARTS
 ***/

public class AlexMainPage extends Page {

    /* Links - Starts */

    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement logoutLink;

    // Menu bar - main.
    @FindBy(xpath = "")
    WebElement aaa;
    @FindBy(xpath = "")
    WebElement bbb;
    @FindBy(xpath = "")
    WebElement ccc;
    @FindBy(xpath = "")
    WebElement ddd;
    @FindBy(xpath = "")
    WebElement eee;
    @FindBy(xpath = "")
    WebElement fff;
    @FindBy(xpath = "")
    WebElement ggg;
    @FindBy(xpath = "")
    WebElement hhh;

    // Menu bar - Overview.
    @FindBy(xpath = "")
    WebElement aaa0;

    // Menu bar - Physician.
    @FindBy(xpath = "")
    WebElement aaa1;
    @FindBy(xpath = "")
    WebElement bbb1;
    @FindBy(xpath = "")
    WebElement ccc1;
    @FindBy(xpath = "")
    WebElement ddd1;
    @FindBy(xpath = "")
    WebElement eee1;

    // Menu bar - Recruiter.
    @FindBy(xpath = "")
    WebElement aaa00;

    // Menu bar - Hospital.
    @FindBy(xpath = "")
    WebElement aaa2;
    @FindBy(xpath = "")
    WebElement bbb3;
    @FindBy(xpath = "")
    WebElement ccc4;
    @FindBy(xpath = "")
    WebElement ddd5;
    @FindBy(xpath = "")
    WebElement eee6;
    @FindBy(xpath = "")
    WebElement fff7;
    @FindBy(xpath = "")
    WebElement ggg8;

    // Menu bar - Messages.
    @FindBy(xpath = "")
    WebElement a0aa;

    // Menu bar - Accounting.
    @FindBy(xpath = "")
    WebElement aaa2a;
    @FindBy(xpath = "")
    WebElement bbb3a;
    @FindBy(xpath = "")
    WebElement ccc4a;
    @FindBy(xpath = "")
    WebElement ddd5a;

    // Menu bar - Web Tracking.
    @FindBy(xpath = "")
    WebElement aaa2aa;
    @FindBy(xpath = "")
    WebElement bbb3aa;
    @FindBy(xpath = "")
    WebElement ccc4aa;
    @FindBy(xpath = "")
    WebElement ddd5aa;

    // Menu bar - Jobs.
    @FindBy(xpath = "")
    WebElement aaa22aa;
    @FindBy(xpath = "")
    WebElement bbb23aa;

    /* Links - Ends */

    /* Methods */

    // Constructor and OpenPage.
    public AlexMainPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/admin/overview";
        PageFactory.initElements(driver, this);
    }

    public AlexMainPage OpenMainPage() {
        driver.get(PAGE_URL);
        return this;
    }

     /* Checks */

    public boolean isOnMainPage() {
        waitforLogOutLink();
        return exists(logoutLink);
    }

    // Waiting.

    public void waitforLogOutLink() {
        waitUntilIsLoaded(logoutLink);
    }

    /*** CLASS ENDS ***/
}
