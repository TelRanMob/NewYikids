package com.yikids.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Irina Primak on 06-Apr-16.
 */
public class IrinaMainPage extends Page {


    // /fields // TODO: find real locator
    @FindBy(id = "http://admin.yikids.com/admin/hospital-overview")
    WebElement hospitalLink;

    @FindBy(id = "http://admin.yikids.com/hospital/add")
    WebElement addHospitalLink;

    // links
    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement logOutLink;

    //constructor
    public IrinaMainPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/";
        PageFactory.initElements(driver, this);
    }

    public IrinaMainPage openAdminMainPage() {
        //Log.info("Opening SignUp page");
        driver.get(PAGE_URL);
        return this;
    }

    public IrinaMainPage goToAddHospital() {
        //Log.info("Clicking Add Hospital");
        moveMouseOverElement(hospitalLink);
        moveMouseOverElement(addHospitalLink);
        clickElement(addHospitalLink);

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
