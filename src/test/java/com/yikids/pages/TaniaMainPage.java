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
public class TaniaMainPage extends Page {


    // TODO: find real locator
    //Find Links

    @FindBy(xpath ="//div[@id='logout-container']/a")
    //"http://admin.yikids.com/logout")
    WebElement logOutLink;

    /* Hospital->Add Hospital */
    @FindBy(xpath="//li[@id='nav_benefits']/a)[13]")
    // "http://admin.yikids.com/hospital/add")
    WebElement addHospitalLink;

    /* Hospital */
    @FindBy(xpath="//li[@id='nav_benefits']/a)[10]")
    // " http://admin.yikids.com/admin/hospital-overview")
    WebElement hospitalLink;





    public TaniaMainPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/";
        PageFactory.initElements(driver, this);
    }


    public TaniaMainPage openAdminAddHospitalPage() {
        //Log.info("Opening SignUp page");
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fields


    public TaniaMainPage goToAddHospital() {
        //Log.info("Clicking Add Hospital");
        moveMouseOverElement(hospitalLink);
        moveMouseOverElement(addHospitalLink);
        clickElement(addHospitalLink);

        return this;
    }

    public TaniaMainPage goToAddHospitalLink() {
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
