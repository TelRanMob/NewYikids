package com.yikids;

/*
 * Created by Alexandr on 03.04.2016.
 */

import com.yikids.pages.AlexSignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/***
 * CLASS STARTS
 ***/

public class AlexSignUpTest {

    public AlexSignUpPage alexsignuppage;
    public WebDriver driver = new FirefoxDriver();

    @BeforeClass(alwaysRun = true)
    public void setup() {
        alexsignuppage = PageFactory.initElements(driver, AlexSignUpPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void openSetUp() {
        alexsignuppage.openSignUpPage();
    }

    /* Positive tests */

    @Test(groups = {"Alex"})
    public void signUpPositiveTest() {
        alexsignuppage
                .fillFirstnameField("TestName")
                .fillLastNameField("TestSurname")
                .fillEmailField("TestMail@youpmail.com")
                .fillZip1Field("12341")
                .fillZip21Field("5646")
                .fillCompany1Field("TestCompany");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alexsignuppage.clickToContinue();
        assertTrue("First Name isn't confirmed", alexsignuppage.checkforFirstNameLabel());
        assertTrue("Last Name isn't confirmed", alexsignuppage.checkforLastNameLabel());
        assertTrue("Email isn't confirmed", alexsignuppage.checkforEmailLabel());
        assertTrue("ZipCode isn't confirmed", alexsignuppage.checkforZipCodeLabel());
        assertTrue("Company isn't confirmed", alexsignuppage.checkforCompanyLabel());
    }

    /* Negative tests */

    @Test(groups = {"Alex"})
    public void signUpNegativeFIrstNameTest() throws InterruptedException {
        alexsignuppage
                .fillFirstnameField(" ")
                .fillLastNameField("TestSurname")
                .fillEmailField("TestMail@youpmail.com")
                .fillZip1Field("12341")
                .fillZip21Field("5646")
                .fillCompany1Field("TestCompany")
                .clickToContinue()
                .waitforFirstNameWarning();
        assertTrue("No first name empty warning", alexsignuppage.checkforFirstNameEmptyFieldMessage());
    }

    @Test(groups = {"Alex"})
    public void signUpNegativeLastNameTest() {
        alexsignuppage
                .fillFirstnameField("TestName")
                .fillLastNameField(" ")
                .fillEmailField("TestMail@youpmail.com")
                .fillZip1Field("12341")
                .fillZip21Field("5646")
                .fillCompany1Field("TestCompany")
                .clickToContinue()
                .waitforLastNameWarning();
        assertTrue("No last name empty warning", alexsignuppage.checkforLastNameEmptyFieldMessage());
    }

    @Test(groups = {"Alex"})
    public void signUpNegativeEmailEmptyTest() {
        alexsignuppage
                .fillFirstnameField("TestName")
                .fillLastNameField("TestSurname")
                .fillEmailField(" ")
                .fillZip1Field("12341")
                .fillZip21Field("5646")
                .fillCompany1Field("TestCompany")
                .clickToContinue()
                .waitforEmailWarning();
        assertTrue("No email empty warning", alexsignuppage.checkforEmailEmptyFieldMessage());
    }

    @Test(groups = {"Alex"})
    public void signUpNegativeEmailWrongFormatTest() {
        alexsignuppage
                .fillFirstnameField("TestName")
                .fillLastNameField("TestSurname")
                .fillEmailField("123343@44444")
                .fillZip1Field("12341")
                .fillZip21Field("5646")
                .fillCompany1Field("TestCompany")
                .clickToContinue()
                .waitforEmailWarning();
        assertTrue("No email wrong format warning", alexsignuppage.checkforEmailWrongFormatMessage());
    }

    @Test(groups = {"Alex"})
    public void signUpNegativeZipCodeWrongTest() {
        alexsignuppage
                .fillFirstnameField("TestName")
                .fillLastNameField("TestSurname")
                .fillEmailField("TestMail@youpmail.com")
                .fillZip1Field("342")
                .fillZip21Field("5646")
                .fillCompany1Field("TestCompany")
                .clickToContinue()
                .waitforZipCodeWarning();
        assertTrue("No zipcode invalid warning", alexsignuppage.checkforZipCodeInvalidFieldMessage());
    }

    @Test(groups = {"Alex"})
    public void signUpNegativeZipCodeEmptyTest() {
        alexsignuppage
                .fillFirstnameField("TestName")
                .fillLastNameField("TestSurname")
                .fillEmailField("TestMail@youpmail.com")
                .fillZip1Field(" ")
                .fillZip21Field(" ")
                .fillCompany1Field("TestCompany")
                .clickToContinue()
                .waitforZipCodeWarning();
        assertTrue("No zipcode empty warning", alexsignuppage.checkforZipCodeEmptyFieldMessage());
    }

    @Test(groups = {"Alex"})
    public void signUpNegativeZipCodeWrongFormatTest() {
        alexsignuppage
                .fillFirstnameField("TestName")
                .fillLastNameField("TestSurname")
                .fillEmailField("TestMail@youpmail.com")
                .fillZip1Field("dfgdf")
                .fillZip21Field("dfgdf")
                .fillCompany1Field("TestCompany")
                .clickToContinue()
                .waitforZipCodeWarning();
        assertTrue("No zipcode wrong format warning", alexsignuppage.checkforZipCodeWrongFormatMessage());
    }

    @Test(groups = {"Alex"})
    public void signUpNegativeCaptchaTest() {
        alexsignuppage
                .fillFirstnameField("TestName")
                .fillLastNameField("TestSurname")
                .fillEmailField("TestMail@youpmail.com")
                .fillZip1Field("342")
                .fillZip21Field("5646")
                .fillCompany1Field("TestCompany")
                .clickToContinue()
                .waitforCaptchaWarning();
        assertTrue("No captcha warning", alexsignuppage.checkforCapchaErrorMessage());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    /*** CLASS ENDS ***/

}
