package com.yikids.pages;

/*
 * Created by Alexandr on 11.04.2016.
 */

import com.yikids.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/***
 * CLASS STARTS
 ***/

public class AlexAddHospitalPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    /* Elements */

    // Fields
    @FindBy(xpath = "//*[@id='name']")
    WebElement nameField;
    @FindBy(xpath = "//*[@id='adress']")
    WebElement adressField;
    @FindBy(xpath = "//*[@id='city']")
    WebElement cityField;
    @FindBy(xpath = "//*[@id='country']")
    WebElement countryField;
    @FindBy(xpath = "//*[@id='zip']")
    WebElement zipField;
    @FindBy(xpath = "//*[@id='phnnum']")
    WebElement phnnumField;
    @FindBy(xpath = "//*[@id='email']")
    WebElement emailFieldAddHosp;
    @FindBy(xpath = "//*[@id='type']")
    WebElement typeField;
    @FindBy(xpath = "//*[@id='otherinfo']")
    WebElement otherinfoField;

    @FindBy(xpath = "//*[@id='state']")
    WebElement stateField;
    @FindBy(xpath = "//*[@id='er']")
    WebElement erField;

    // Checks
    @FindBy(id = "recstatus")
    WebElement recruitingStatus;
    @FindBy(id = "tier1or2")
    WebElement tierHalfFaciliaty;
    @FindBy(id = "academic")
    WebElement academicFaciliaty;
    @FindBy(id = "cmpsn200plus")
    WebElement compensation200Salary;
    @FindBy(id = "cme")
    WebElement CMECompensation;
    @FindBy(id = "mjdblcvg")
    WebElement majorDoubleCoverage;
    @FindBy(id = "mdlvlcvg")
    WebElement mdlvlcvg;
    @FindBy(id = "emr")
    WebElement emr;
    @FindBy(id = "noihcdcvg")
    WebElement noihcdcvg;
    @FindBy(id = "noadmordrs")
    WebElement noadmordrs;
    @FindBy(id = "prisnglcvg")
    WebElement prisnglcvg;
    @FindBy(id = "anystlic")
    WebElement anystlic;
    @FindBy(id = "reprentation")
    WebElement reprentation;

    // Buttons
    @FindBy(xpath = "//*[@id='add_hospital_form']/input[16]")
    WebElement saveButton;

    /* Methods */

    // Constructor & OpenPage
    public AlexAddHospitalPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/hospital/add";
        PageFactory.initElements(driver, this);
    }

    public AlexAddHospitalPage OpenAlexAddHospPage() {
        driver.get(PAGE_URL);
        return this;
    }

    /* Fill fields */


    /*** CLASS ENDS ***/

}
