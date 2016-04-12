package com.yikids.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


/**
 * Created by IrinaPrimak on 10-Apr-16.
 */
public class IrinaHospOwnerManagPage extends Page {
    public String PAGE_URL;

    //buttons
    @FindBy(xpath = "//*[@id='hospital-rewrite']/div[1]/a[1]")
    WebElement approveButton;

    @FindBy(xpath = "//*[@id='hospital-rewrite']/div[1]/a[2]")
    WebElement deattachButton;

    @FindBy(id = "show-all")
    WebElement showAllButton;

    @FindBy(xpath = "//*[@class='with-sub active']/a")
    WebElement hospitalLink;

    @FindBy(xpath = "//div[@class='text-center'][contains (text(), 'Hospital Owner Management Page')]")
    WebElement hospitalOwnerManagementPageTitle;

    @FindBy(xpath = "//*[@class='with-sub active']//*[contains(text(),'Hospital Owner Managemen')]")
    WebElement hospitalOwnerManagementLink;

    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement logOutButton;
    //http://admin.yikids.com/admin/hospital_owner_management


    public IrinaHospOwnerManagPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/admin/hospital_owner_management";
        PageFactory.initElements(driver, this);
    }

    public IrinaHospOwnerManagPage goToHospitalOwnerManagment() {
        //Log.info("Clicking Add Hospital");
       // moveMouseOverElement(hospitalLink);
        //moveMouseOverElement(hospitalOwnerManagementLink);
        //clickElement(hospitalOwnerManagementLink);
        driver.get((PAGE_URL));
        return this;
    }
    public IrinaHospOwnerManagPage showAll(){
        //log/
        clickElement(showAllButton);
        return this;
    }
    /*public void waitForMainPageLoad() throws IOException, InterruptedException {
        waitUntilElementIsLoaded(hospitalLink);

    }*/
    public void waitForhospitalOwnerManagementPageTitle()   {
        waitUntilIsLoaded(hospitalOwnerManagementPageTitle);
    }

    public boolean checkPageHospOwnerManagOpen() {
        return verifyTextBoolean(hospitalOwnerManagementPageTitle,
                "Hospital Owner Management Page");
    }
}
