package com.yikids.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by
 * on 3/22/2016.
 */
public class MainPage extends Page {


    // /fields // TODO: find real locator
    @FindBy(id = "hospital")
    WebElement hospitalLink;

    @FindBy(id = "hospital2")
    WebElement addHospitalLink;

    // links
    @FindBy(id = "logout-container")
    WebElement logOutLink;


    public MainPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/";
        PageFactory.initElements(driver, this);
    }


    public MainPage openAdminAddHospitalPage() {
        //Log.info("Opening SignUp page");
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fields


    public MainPage goToAddHospital() {
        //Log.info("Clicking Add Hospital");
        moveMouseOverElement(hospitalLink);
        moveMouseOverElement(addHospitalLink);
        clickElement(addHospitalLink);

        return this;
    }

    public MainPage goToAddHospitalLink() {
        //Log.info("Clicking Add Hospital");
        driver.get("http://admin.yikids.com/hospital/add");
        return this;
    }

    public void waitForMainPageLoad() throws IOException, InterruptedException {
        waitUntilElementIsLoaded(hospitalLink);
    }

    public void WaitForLogoutSign() {
        waitUntilIsLoaded(logOutLink);
    }

    public boolean isOnMainPage() {
        WaitForLogoutSign();
        return exists(logOutLink);
    }


}
