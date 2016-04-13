package com.yikids.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


/**
 * Created by Tania Pereminski on 12-Apr-2016.
 */
public class TaniaHospitalOwnerManagementPage extends Page {

    //Find LogOut button
    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement logOutButton;

    //Find title  "Hospital Owner Management Page"
    @FindBy(xpath = "//div[@class='text-center']/h1")
    WebElement hospitalOwnerManagementTitle;

    //Find sub title  "Enter Recruiter Name, Hospital Name, Company Name to Search:"
    @FindBy(xpath = "//div[@class=/'text-center/']/p[1]")
    WebElement enterRHCNamesToSearch;

    //Find FieldText
    @FindBy(id = "recruiter_name")
    WebElement recruiterName;

    @FindBy(id = "hospital_name")
    WebElement hospitalName;

    @FindBy(id = "company_name")
    WebElement companyName;

    //Find button "Show All"
    @FindBy(id = "show-all")
    WebElement showAll;

    //Find Approve LinkButton
    @FindBy(xpath = "//*[@id='hospital-rewrite']/div[1]/a[1]")
    WebElement approveLinkButton;

    //Find Deattach LinkButton
    @FindBy(xpath = "//*[@id='hospital-rewrite']/div[1]/a[2]")
    WebElement deattachLinkButton;

    //Find all checkboxs in grid
    @FindBy(xpath = ".//*[@id='row0']/td[1]/input")
    WebElement checkbox1;

    @FindBy(xpath = "//*[@id='row180']/td[1]/input")
    WebElement checkbox181;

    //Find Status
    @FindBy(xpath = "//*[@id='row0']/td[9]")
    WebElement notOwnedStatus;

    //constructor
    public TaniaHospitalOwnerManagementPage(WebDriver driver) {
        super(driver);
        //Log.info("Opening Hospital Owner Management Page ");
        this.PAGE_URL = "http://admin.yikids.com/admin/hospital_owner_management";
        PageFactory.initElements(driver,this);
    }

    public TaniaHospitalOwnerManagementPage openAdminPage() {
        //Log.info("Opening SignUp page");
        driver.get(PAGE_URL);
        return this;
    }

    public String getPageTitle() {

        return PAGE_TITLE;
    }

    public void loadPage() {
        driver.get(getPageUrl());
//  Assert.assertEquals(getTitle(), getPageTitle());
    }

    public boolean checkPageHospOwnerManagementOpen() {
        return verifyTextBoolean(hospitalOwnerManagementTitle,"Hospital Owner Management Page");
    }
/**********************************************************************************************************************/

    public void checkCheckboxes(int Chec) {
        int rowNumber;

        for (rowNumber = 0; rowNumber <= Chec; rowNumber++) {
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            box.click();
        }
    }

    //Checking if all selected  checkboxes are checked in order
    public boolean isCheckedCheckboxes(int Chec) {
        int rowNumber, count = 0;
        boolean checked = false;
        for (rowNumber = 0; rowNumber <= Chec; rowNumber++) {
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            if (box.isSelected()) {
                checked = true;
                count++;
            } else {
                checked = false;
                count--;
            }
        }
        if (count == Chec && checked == true) {
            checked= true;
        }
        return checked;
    }

/**********************************************************************************************************************/
    //Checking only checkboxes of rows with selected status
    //Todo Create method
    public void checkNotAllCheckboxes(int Chec,String status) {
        int rowNumber = 0;
        for (rowNumber = 0; rowNumber <= Chec; rowNumber++) {
            String locatorStatus = "//*[@id='row" + rowNumber + "']/td[9]";
            WebElement statusCell = driver.findElement(By.xpath(locatorStatus));
            String statusText = statusCell.getText();
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            if (statusText.equalsIgnoreCase( status)) {
                box.click();
            }
        }
    }


    //Checking only checkboxes of rows with selected status
    //Todo Create method
    public boolean isCheckedNotAllCheckboxes(int Chec,String status) {
        int rowNumber = 0;
        boolean flag=false;
        for (rowNumber = 0; rowNumber <= Chec; rowNumber++) {
            String locatorStatus = "//*[@id='row" + rowNumber + "']/td[9]";
            WebElement statusCell = driver.findElement(By.xpath(locatorStatus));
            String statusText = statusCell.getText();
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            if (status.equalsIgnoreCase(statusText))
            {
                if (box.isSelected()) {
                    flag = true;
                }
                else
                    flag = false;
            }
        }
        return flag;
    }
/**********************************************************************************************************************/



    public String gettext() {
        return getTextElement(notOwnedStatus);
    }

    public boolean checkTextOfElementLogOut() {
        return verifyTextBoolean(deattachLinkButton," Deattach");
    }


    public void waitForFirstNameWarning() {
        try {
            waitUntilElementIsLoaded(deattachLinkButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}