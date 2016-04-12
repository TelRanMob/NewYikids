package com.yikids.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Irina Primak on 06-Apr-16.
 */
public class IrinaMainPage extends Page {


    // /fields // TODO: find real locator
    @FindBy(xpath = "//li[@id='nav_benefits']/a][10]")
            // " http://admin.yikids.com/admin/hospital-overview")
    WebElement hospitalLink;

    @FindBy(xpath = "//li[@id='nav_benefits']/a][13]")
             // "http://admin.yikids.com/hospital/add")
    WebElement addHospitalLink;

    // links
    @FindBy(xpath ="//div[@id='logout-container']/a")
            //"http://admin.yikids.com/logout")
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

    public void waitForLogoutSign()
    {
        waitUntilIsLoaded(logOutLink);
    }

    public boolean isOnMainPage() {
        waitForLogoutSign();
        return exists(logOutLink);
    }
}
