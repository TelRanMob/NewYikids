package com.yikids.pages;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement logOutButton;

    @FindBy(xpath = "//*[@class='with-sub active']/a")
    WebElement hospitalLink;

    //title
    @FindBy(xpath = "//div[@class='text-center'][contains (text(),'Hospital Owner Management Page')]")
    WebElement hospitalOwnerManagementPageTitle;


    // Action
    @FindBy(xpath ="//*[@id='row0']/td[1]/input")
    WebElement Checkbox;



    public IrinaHospOwnerManagPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/admin/hospital_owner_management";
        PageFactory.initElements(driver, this);
    }

    public IrinaHospOwnerManagPage goToHospitalOwnerManagment() {
        //Log.info(
       // moveMouseOverElement(hospitalLink);
        //moveMouseOverElement(hospitalOwnerManagementLink);
        //clickElement(hospitalOwnerManagementLink);
        driver.get((PAGE_URL));
        return this;
    }
    public void checkCheckbxes(int chec) {
        int rowNumber;

        for (rowNumber = 0; rowNumber <= chec; rowNumber++) {
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            box.click();
        }
    }
    //Checking only checkboxes of rows with selected status
    //Todo Create method
    public void checkNotAllCheckbxes(int chec, String status) {
        int rowNumber = 0;
        do {
            String locatorStatus = "//*[@id='row" + rowNumber + "']/td[9]";
            WebElement statusCell = driver.findElement(By.xpath(locatorStatus));
            String statusText = statusCell.getText();
            if (statusText.equalsIgnoreCase(status))
                for (rowNumber = 0; rowNumber <= chec; rowNumber++) {
                    String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
                    WebElement box = driver.findElement(By.xpath(locator));
                    box.click();
                }
        } while (rowNumber==chec);
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
