package com.yikids.pages;

/**
 * Created by Tania Pereminski on 3/22/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Tania Pereminski
 */

//import com.telran.LogLog4j;
//import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.Random;


public class TaniaSignUPPage extends Page {
    //private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static Random rnd = new Random();

    //System messages
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The first name field is required.']")
    WebElement firstNameEmptyFieldMessage;
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The first name may only contain letters and numbers.']")
    WebElement firstNameWrongFieldMessage;
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The first name must be at least 3 characters.']")
    WebElement firstNameOneNumbFieldMessage;

    /* fields */
    @FindBy(id = "firstname")
    WebElement firstNameField;

    @FindBy(id = "lastname")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "zipcode")
    WebElement zipCodeField;

    @FindBy(id = "zip-plus")
    WebElement zipCode2Field;

    @FindBy(id = "company")
    WebElement companyField;

    /* buttons */
    @FindBy(id = "create-account")
    WebElement continueButton;


    /* Labels */
    @FindBy(xpath = "//*[@id='section-account']/div[5]//label")
    WebElement companyLabel;

    @FindBy(xpath = "//*[@id='section-account']/div[4]//label")
    WebElement zipCodeLabel;

    @FindBy(xpath = "//*[@id='section-account']/div[3]//label")
    WebElement emailLabel;

    @FindBy(xpath = "//*[@id='section-account']/div[2]//label")
    WebElement lastNameLabel;

    @FindBy(xpath = "//*[@id='section-account']/div[1]//label")
    WebElement firstNameLabel;

    /* ERROR Messages */
    @FindBy(xpath = "//form[@id='section-account']/div[1]//div/span")
    WebElement firstNameMessage;

    @FindBy(xpath = "//form[@id='section-account']/div[2]//div/span")
    WebElement lastNameMessage;

    @FindBy(xpath = "//form[@id='section-account']/div[3]//div/span")
    WebElement emailMessage;

    @FindBy(xpath = "//form[@id='section-account']/div[4]//div[2]/span[1]")
    WebElement zipCodeMessage;

    @FindBy(xpath = "//form[@id='section-account']/div[4]//div[2]/span[2]")
    WebElement zipPlusMessage;

    /* ErrorCaptcha */
    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement ErrorCaptcha;

    /* Title */
    @FindBy(xpath = "//div[@id='contentContainer']/p[1]")
    WebElement pageTitle;


    /* Methods */

    public TaniaSignUPPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
        PageFactory.initElements(driver, this);
    }

    public TaniaSignUPPage openTaniaSignUPPage() {
        //Log.info("Opening TaniaSignUPPage page");
        driver.get(PAGE_URL);
        return this;
    }

    private static String getRandomString(final int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return buf.toString();
    }

    public String generateEmail() {
        String rand = getRandomString(5);
        String username = rand + "@yopmail.com";
        // Log.info("Doctor's Username generated is <" + username + ">");
        return username;
    }

    /* verification methods */
    public boolean checkPageOpen() {
        return super.verifyTextBoolean(pageTitle, "Step one of finding your physicians");
    }

    public boolean isOnSignUpPage() {
        // Log.info(");
        return exists(continueButton);
    }

    /* Fill the fields */

    public TaniaSignUPPage opentaniaSignUPPage() {
        //Log.info("Opening SignUp page");
        driver.get(PAGE_URL);
        return this;
    }

    public TaniaSignUPPage fillFirstnameField(String username) {
        //Log.info("Filling username field");
        setElementText(firstNameField, username);
        return this;
    }

    public TaniaSignUPPage fillLastNameField(String lastname) {
        //Log.info("Filling username field");
        setElementText(lastNameField, lastname);
        return this;
    }

    public TaniaSignUPPage fillemailField(String email) {
        //Log.info("Filling username field");
        setElementText(emailField, email);
        return this;
    }

    public TaniaSignUPPage fillzipcodeField(String zipcode) {
        //Log.info("Filling username field");
        setElementText(zipCodeField, zipcode);
        return this;
    }

    public TaniaSignUPPage fillzipPlusField(String zipcode2) {
        //Log.info("Filling username field");
        setElementText(zipCode2Field, zipcode2);
        return this;
    }

    public TaniaSignUPPage fillcompanyField(String companyName) {
        //Log.info("Filling username field");
        setElementText(companyField, companyName);
        return this;
    }

    /* Click  'Continue'  Button */
    public TaniaSignUPPage clickToContinue() {
        //Log.info("Filling username field");
        clickElement(continueButton);
        return this;
    }

    public TaniaSignUPPage FillsignUPFields() {
        //Log.info("Filling all fields");
        opentaniaSignUPPage();
        fillFirstnameField("username");
        fillLastNameField("lastname");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("0011");
        fillzipPlusField("12");
        fillcompanyField("company");

        return this;
    }

    public TaniaSignUPPage NoFillUsernameFields() {
        //Log.info("Filling all fields");
        openTaniaSignUPPage();
        fillFirstnameField("");
        fillLastNameField("lastname");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("00801");
        fillzipPlusField("0080");
        fillcompanyField("company");
        return this;
    }

    public TaniaSignUPPage WrongFillUsernameFields() {
        //Log.info("Filling all fields");
        openTaniaSignUPPage();
        fillFirstnameField("wewr-324");
        fillLastNameField("lastname");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("00801");
        fillzipPlusField("0080");
        fillcompanyField("company");
        return this;
    }

    public TaniaSignUPPage NoFillLastnameFields() {
        //Log.info("Filling all fields");
        openTaniaSignUPPage();
        fillFirstnameField("username");
        fillLastNameField("");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("00801");
        fillzipPlusField("0080");
        fillcompanyField("company");
        return this;
    }

    /*  Implicity waits -method on SignUpPage */
    public void waitForWarningFirstNameEmpty() {
        waitUntilIsLoaded(firstNameMessage);
    }

    public void waitForWarningLastNameEmpty() {
        waitUntilIsLoaded(lastNameMessage);
    }

    public void waitForWarningEmailEmpty() {
        waitUntilIsLoaded(emailMessage);
    }

    public void waitForWarningCapchaMessage() {
        waitUntilIsLoaded(ErrorCaptcha);
    }

    public void waitForWarningZipCodeMessageEmpty() {
        waitUntilIsLoaded(zipCodeMessage);
    }

    public void waitForWarningPlusCodeEmpty() {
        waitUntilIsLoaded(zipPlusMessage);
    }


    /* check your field is valid */

    public String gettext() {
        return getTextElement(firstNameMessage);
    }


    public boolean CheckWarningMessageFirstName() {
        return verifyTextBoolean(firstNameEmptyFieldMessage,"The first name field is required.");
    }

    public boolean CheckWarningMessageFirstNameisSimbols() {
        return verifyTextBoolean(firstNameWrongFieldMessage,"The first name may only contain letters and numbers.");
    }

    public boolean CheckWarningMessageFirstNameisOneNumber() {
        return verifyTextBoolean(firstNameOneNumbFieldMessage, "The first name must be at least 3 characters.");
    }



    public boolean checkFirstNameErrorMessage() {return verifyTextBoolean(firstNameMessage, "The first name field is required.");
    }
    public boolean checkLastNameErrorMessage() {return verifyTextBoolean(lastNameMessage, "The last name field is required.");
    }
    public boolean checkEmailInvalidErrorMessage() {return verifyTextBoolean(emailMessage, "The email format is invalid.");
    }
    public boolean checkEmailRequiredErrorMessage() {return verifyTextBoolean(emailMessage, "The email field is required.");
    }


    public boolean checkZipCodeInvalidMessage(){return verifyTextBoolean(zipCodeMessage, "Zipcode is invalid");}
    public boolean checkZipCodeEmptyMessage(){return verifyTextBoolean(zipCodeMessage, "The zipcode field is required.");}
    public boolean checkZipPlusMessage(){return verifyTextBoolean(zipPlusMessage, "The zipcode must be a number.");}
    public boolean CheckPageForCapthcaMessage() {
        return verifyTextBoolean(ErrorCaptcha,"Please check Captcha!");
    }

    /* check text on labels*/
    public boolean checkFirstNameLabel() {
        return verifyTextBoolean(firstNameLabel, "First name*");
    }
    public boolean checkLastNameLabel() {
        return verifyTextBoolean(lastNameLabel, "Last name*");
    }
    public boolean checkEmailLabel() {
        return verifyTextBoolean(emailLabel, "Email*");
    }
    public boolean checkZipCodeLabel() {return verifyTextBoolean(zipCodeLabel, "Zip code*");}
    public boolean checkCompanyLabel() {return verifyTextBoolean(companyLabel, "Company");}


    public TaniaSignUPPage checkelement(String error){
        verifyText(ErrorCaptcha, error);
        return this;
    }

    public String waitAndGetTextofSelectedMessage(String number) throws IOException, InterruptedException {
        String locator = "//*[@id='section-account']/div[" + number + "]//div[2]/span[1]";
        WebElement m = driver.findElement(By.xpath(locator));
        waitUntilElementIsLoaded(m);
        return m.getText();
    }
}