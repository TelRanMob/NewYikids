package com.yikids.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Tania Pereminski on 12-Apr-2016.
 */
public class TaniaHospitalManagementPage extends Page {

//Find LogOut button
    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement LogOutButton;

//Find title  "Hospital Owner Management Page"
    @FindBy(xpath = "//div[@class='text-center']/h1")
    WebElement HospitalOwnerManagementTitle;

//Find sub title  "Enter Recruiter Name, Hospital Name, Company Name to Search:"
    @FindBy(xpath = "//div[@class=/'text-center/']/p[1]")
    WebElement EnterRHCNamesToSearch;

//Find FieldText
    @FindBy(id="recruiter_name")
    WebElement RecruiterName;

    @FindBy (id="hospital_name")
    WebElement HospitalName;

    @FindBy (id="company_name")
    WebElement CompanyName;

//Find button "Show All"
    @FindBy (id="show-all")
    WebElement ShowAll;

//Find Approve LinkButton
    @FindBy(xpath = "//*[@id='hospital-rewrite']/div[1]/a[1]")
    WebElement ApproveLinkButton;

//Find Deattach LinkButton
    @FindBy(xpath = "//*[@id='hospital-rewrite']/div[1]/a[2]")
    WebElement DeattachLinkButton;

//Find all checkboxs in grid
    @FindBy(xpath = ".//*[@id='row0']/td[1]/input")
    WebElement checkbox1;

    @FindBy(xpath = "//*[@id='row1']/td[1]/input")
    WebElement checkbox2;

    @FindBy(xpath = "//*[@id='row2']/td[1]/input")
    WebElement checkbox3;

    @FindBy(xpath = "//*[@id='row3']/td[1]/input")
    WebElement checkbox4;

    @FindBy(xpath = "//*[@id='row4']/td[1]/input")
    WebElement checkbox5;

    @FindBy(xpath = "//*[@id='row5']/td[1]/input")
    WebElement checkbox6;

    @FindBy(xpath = "//*[@id='row6']/td[1]/input")
    WebElement checkbox7;

    @FindBy(xpath = "//*[@id='row7']/td[1]/input")
    WebElement checkbox8;

    @FindBy(xpath = "//*[@id='row8']/td[1]/input")
    WebElement checkbox9;

    @FindBy(xpath = "//*[@id='row9']/td[1]/input")
    WebElement checkbox10;

    @FindBy(xpath = "//*[@id='row10']/td[1]/input")
    WebElement checkbox11;

    @FindBy(xpath = "//*[@id='row11']/td[1]/input")
    WebElement checkbox12;

    @FindBy(xpath = "//*[@id='row172']/td[1]/input")
    WebElement checkbox173;

    @FindBy(xpath = "//*[@id='row180']/td[1]/input")
    WebElement checkbox181;




    public TaniaHospitalManagementPage(WebDriver driver) {
        super(driver);
        //Log.info("Opening Hospital Owner Management Page ");
        this.PAGE_URL="http://admin.yikids.com/admin/hospital_owner_management";
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {

        return PAGE_TITLE;
    }

    public void loadPage() {
        driver.get(getPageUrl());
//  Assert.assertEquals(getTitle(), getPageTitle());
    }

}
