package com.yikids.pages;

/*
 * Created by Alexandr on 19.04.2016.
 */

import com.yikids.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/***
 * CLASS STARTS
 ***/

public class AlexHospOwnerMangmntPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    /* Fields and buttons */

    @FindBy(xpath = "//*[@id='hospital-rewrite']/div[1]/a[1]")
    WebElement approveButton;
    @FindBy(xpath = "//*[@id='hospital-rewrite']/div[1]/a[2]")
    WebElement deattachButton;

    @FindBy(xpath = "//*[@id='row0']/td[9]")
    WebElement status;

    /* Methods */

    //Construct and OpenPage
    public AlexHospOwnerMangmntPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/admin/hospital_owner_management";
        PageFactory.initElements(driver, this);
    }

    public AlexHospOwnerMangmntPage OpenPage() {
        Log.info("Opening Page");
        driver.get(PAGE_URL);
        return this;
    }

    //CheckBoxes
    public void checkCheckBoxes(int check) {
        int rowNumber;
        for (rowNumber = 0; rowNumber == check; rowNumber++) {

            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            box.click();
        }
    }

    public void checkForNotAllCheckBoxes(int check, String status) {
        int rowNumber;
        String statusText = null;
        for (rowNumber = 0; rowNumber <= check; rowNumber++) {
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            if (statusText.equalsIgnoreCase(status)) {
                WebElement box = driver.findElement(By.xpath(locator));
                Log.info("Checking box with status " + status + ". Box number " + rowNumber);
                box.click();
            }
        }
    }


    /*** CLASS ENDS ***/

}
