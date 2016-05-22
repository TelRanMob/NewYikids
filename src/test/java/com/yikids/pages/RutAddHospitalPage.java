package com.yikids.pages;

import com.yikids.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by rut on 04.05.2016.
 */
public class RutAddHospitalPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    //fields
    @FindBy(id = "name")
    WebElement nameField;

    @FindBy(id = "address")
    WebElement addressField;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "county")
    WebElement countryField;

    @FindBy(id = "zip")
    WebElement zipCodeField;

    @FindBy(id = "phnnum")
    WebElement phoneNumberField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "type")
    WebElement typeOfFacilityField;

    @FindBy(id = "otherinfo")
    WebElement otherInfoField;

    //dropdowns

    @FindBy(id = "state")
    WebElement stateFieldDropdown;

    @FindBy(id = "er")
    WebElement haveAnERDropdown;

    //checkboxes

    @FindBy(id = "recstatus")
    WebElement recrutingStatusCheckbox;

    @FindBy(id = "tier1or2")
    WebElement tierCheckbox;

    @FindBy(id = "academic")
    WebElement academicCheckbox;

    @FindBy(id = "cmpsn200plus")
    WebElement cmpsn200PlusCheckbox;

    @FindBy(id = "cme")
    WebElement cmeCompensationCheckbox;

    @FindBy(id = "mjdblcvg")
    WebElement majorDoubleCoverageCheckbox;

    @FindBy(id = "mdlvlcvg")
    WebElement mdlvlcvgCheckbox;

    @FindBy(id = "emr")
    WebElement emrCheckbox;

    @FindBy(id = "noihcdcvg")
    WebElement noihcdcvgCheckbox;

    @FindBy(id = "noadmordrs")
    WebElement noadmordrsCheckbox;

    @FindBy(id = "prisnglcvg")
    WebElement prisnglcvgCheckbox;

    @FindBy(id = "anystlic")
    WebElement anystlicCheckbox;

    @FindBy(id = "reprentation")
    WebElement reprentationCheckbox;

    //messages

    @FindBy(xpath = "//span[@class='help-block form-error']")
    WebElement errorZipMessage;

    //buttons

    @FindBy(xpath = "//input[@type='submit']")
    WebElement saveButton;

    public RutAddHospitalPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/hospital/add";
        PageFactory.initElements(driver, this);
    }

    public RutAddHospitalPage openAddHospitalPage() {
        Log.info("Opening AddHospitalPage page");
        driver.get(PAGE_URL);
        return this;
    }

    //Fill the fields

    public RutAddHospitalPage fillNameField(String name) {
        Log.info("Filling name field");
        setElementText(nameField, name);
        return this;
    }
    public RutAddHospitalPage fillAddresssField(String address) {
        Log.info("Filling address field");
        setElementText(addressField, address);
        return this;
    }
    public RutAddHospitalPage fillCityField(String city) {
        Log.info("Filling city field");
        setElementText(cityField, city);
        return this;
    }
    public RutAddHospitalPage fillCountryField(String country) {
        Log.info("Filling country field");
        setElementText(countryField, country);
        return this;
    }
    public RutAddHospitalPage fillZipCodeField(String zipCode) {
        Log.info("Filling zipCode field");
        setElementText(zipCodeField, zipCode);
        return this;
    }
    public RutAddHospitalPage fillPhoneNumberField(String phoneNumber) {
        Log.info("Filling phoneNumber field");
        setElementText(phoneNumberField, phoneNumber);
        return this;
    }
    public RutAddHospitalPage fillEmailField(String email) {
        Log.info("Filling email field");
        setElementText(emailField, email);
        return this;
    }
    public RutAddHospitalPage fillTypeOfFacilityField(String typeOfFacility) {
        Log.info("Filling typeOfFacility field");
        setElementText(typeOfFacilityField, typeOfFacility);
        return this;
    }
    public RutAddHospitalPage fillOtherInfoField(String otherInfo) {
        Log.info("Filling otherInfo field");
        setElementText(otherInfoField, otherInfo);
        return this;
    }

    //Select in Dropdown

    public RutAddHospitalPage selectStateInDropdown(String state){
        Log.info("Selecting state in dropdown");
        selectValueInDropdownbyText(stateFieldDropdown,state);
        return this;
    }
    public RutAddHospitalPage selectHaveAnERInDropdown(String haveAnER){
        Log.info("Selecting haveAnER in dropdown");
        selectValueInDropdownbyText(haveAnERDropdown,haveAnER);
        return this;
    }

    //Check the checkboxes

    public RutAddHospitalPage checkRecrutingStatusCheckbox(){
        Log.info("Clicking on recrutingStatusCheckbox");
        clickElement(recrutingStatusCheckbox);
        return this;
    }
    public RutAddHospitalPage checkTierCheckbox(){
        Log.info("Clicking on tierCheckbox");
        clickElement(tierCheckbox);
        return this;
    }
    public RutAddHospitalPage checkAcademicCheckbox(){
        Log.info("Clicking on academicCheckbox");
        clickElement(academicCheckbox);
        return this;
    }
    public RutAddHospitalPage checkCmpsn200PlusCheckbox(){
        Log.info("Clicking on cmpsn200PlusCheckbox");
        clickElement(cmpsn200PlusCheckbox);
        return this;
    }
    public RutAddHospitalPage checkCmeCompensationCheckbox(){
        Log.info("Clicking on cmeCompensationCheckbox");
//        clickElement(cmeCompensationCheckbox);
        return this;
    }
    public RutAddHospitalPage checkMajorDoubleCoverageCheckbox(){
        Log.info("Clicking on majorDoubleCoverageCheckbox");
        clickElement(majorDoubleCoverageCheckbox);
        return this;
    }
    public RutAddHospitalPage checkMdlvlcvgCheckbox(){
        Log.info("Clicking on mdlvlcvgCheckbox");
        clickElement(mdlvlcvgCheckbox);
        return this;
    }
    public RutAddHospitalPage checkEmrCheckbox(){
        Log.info("Clicking on emrCheckbox");
        clickElement(emrCheckbox);
        return this;
    }
    public RutAddHospitalPage checkNoihcdcvgCheckbox(){
        Log.info("Clicking on noihcdcvgCheckbox");
        clickElement(noihcdcvgCheckbox);
        return this;
    }
    public RutAddHospitalPage checkNoadmordrsCheckbox(){
        Log.info("Clicking on noadmordrsCheckbox");
        clickElement(noadmordrsCheckbox);
        return this;
    }
    public RutAddHospitalPage checkPrisnglcvgCheckbox(){
        //Log.info("Clicking on prisnglcvgCheckbox");
        clickElement(prisnglcvgCheckbox);
        return this;
    }
    public RutAddHospitalPage checkAnystlicCheckbox(){
        Log.info("Clicking on anystlicCheckbox");
        clickElement(anystlicCheckbox);
        return this;
    }
    public RutAddHospitalPage checkReprentationCheckbox(){
        Log.info("Clicking on reprentationCheckbox");
        clickElement(reprentationCheckbox);
        return this;
    }

    public RutAddHospitalPage clickToSave(){
        Log.info("Clicking on saveButton");
        clickElement(saveButton);
        return this;
    }

    //Check error message

    public boolean checkErrorZipMessage() {
        return verifyTextBoolean(errorZipMessage, "Please enter a valid zipcode");
    }

    public boolean isRecrutingCheckboxExsists(){
        return exists(recrutingStatusCheckbox);
    }

    public RutAddHospitalPage fillAddHospitalProfile(){
        Log.info("Filling all fields");
        isRecrutingCheckboxExsists();
        checkRecrutingStatusCheckbox();
        fillNameField("name");
        fillAddresssField("address");
        fillCityField("city");
        fillCountryField("country");
        fillZipCodeField("11111");
        fillPhoneNumberField("1111111111");
        fillEmailField("www@yopmail.com");
        fillTypeOfFacilityField("type");
        fillOtherInfoField("text text");
        selectStateInDropdown("Alabama");
        selectHaveAnERInDropdown("True");
        clickToSave();
        Log.info("Save Hospital");
        return this;
    }
}