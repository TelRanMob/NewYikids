package com.yikids;


import com.yikids.pages.RutSignUPPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by rut on 29.03.2016.
 */
public class RutSignUpTest {
//    static String driverPath = "C:\\Telran\\browserDriver\\";
    public RutSignUPPage rutSignUPPage;
    public WebDriver driver;
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
//        System.setProperty("webdriver.ie.driver", driverPath + "chromedriver.exe");
//        driver = new ChromeDriver();

//        System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
//        driver = new InternetExplorerDriver();
        rutSignUPPage = PageFactory.initElements(driver, RutSignUPPage.class);
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        rutSignUPPage.openSignUpPage();
    }

    @Test
    public void signUpPositive() {
//        Log.info("Test LoginWithExtData was started....");
        rutSignUPPage
                .fillFirstnameField("firstname")
                .fillLastNameField("lastname")
                .fillEmailField("email1@yopmail.com")
                .fillZipCode1Field("111111")
                .fillZipCode2Field("222")
                .fillCompanyField("company");
//        rutSignUPPage.clickToContinue();
    }
    @Test(dataProviderClass = RutDataProviders.class, dataProvider = "loadInvalidSignInFromFile")
    public void fillFieldsNegative(String fn, String lastName, String email, String zipCode1, String zipCode2,
                                   String company, String nubmer,String message) throws InterruptedException, IOException {
        rutSignUPPage
                .fillFirstnameField(fn)
                .fillLastNameField(lastName)
                .fillEmailField(email)
                .fillZipCode1Field(zipCode1)
                .fillZipCode2Field(zipCode2)
                .fillCompanyField(company)
                .clickToContinue();
                Thread.sleep(3000);
        Assert.assertEquals(rutSignUPPage.waitAndGetTextofSelectedMessage(nubmer), message, "Message is not correct");
    }
    @Test
    public void fillFieldsNegativeFirstNameEmpty() throws InterruptedException {
        rutSignUPPage
                .fillFirstnameField("")
                .fillLastNameField("lastname")
                .fillEmailField("email@yopmail.com")
                .fillZipCode1Field("00501")
                .fillZipCode2Field("11")
                .fillCompanyField("company")
                .clickToContinue()
                .waitForFirstNameWarning();
        assertTrue("No First name empty warning", rutSignUPPage.checkFirstNameEmptyFieldMessage());
        Thread.sleep(3000);
    }
    @Test
    public void fillFieldsNegativeLastNameEmpty() throws InterruptedException {
        rutSignUPPage
                .fillFirstnameField("firstname")
                .fillLastNameField("")
                .fillEmailField("email@yopmail.com")
                .fillZipCode1Field("00501")
                .fillZipCode2Field("11")
                .fillCompanyField("company")
                .clickToContinue()
                .waitForLastNameWarning();
        assertTrue("No Lastname empty warning", rutSignUPPage.checkLastNameEmptyFieldMessage());
        Thread.sleep(3000);
    }
    @Test
    public void fillFieldsNegativeEmailEmpty() throws InterruptedException {
        rutSignUPPage
                .fillFirstnameField("firstname")
                .fillLastNameField("lastname")
                .fillEmailField("")
                .fillZipCode1Field("00501")
                .fillZipCode2Field("11")
                .fillCompanyField("company")
                .clickToContinue()
                .waitForEmailWarning();
        assertTrue("No Email empty warning", rutSignUPPage.checkEmailEmptyFieldMessage());
        Thread.sleep(3000);
    }
    @Test
    public void fillFieldsNegativeEmailNotValid() throws InterruptedException {
        rutSignUPPage
                .fillFirstnameField("firstname")
                .fillLastNameField("lastname")
                .fillEmailField("aaa")
                .fillZipCode1Field("00501")
                .fillZipCode2Field("11")
                .fillCompanyField("company")
                .clickToContinue()
                .waitForEmailWarning();
        assertTrue("No Email not valid warning", rutSignUPPage.checkEmailNotValidFieldMessage());
        Thread.sleep(3000);
    }
    @Test
    public void fillFieldsNegativeZipCode1Empty() throws InterruptedException {
        rutSignUPPage
                .fillFirstnameField("firstname")
                .fillLastNameField("lastname")
                .fillEmailField("email@yopmail.com")
                .fillZipCode1Field("")
                .fillZipCode2Field("11")
                .fillCompanyField("company")
                .clickToContinue()
                .waitForZipCodeWarning();
        assertTrue("No Zip code empty warning", rutSignUPPage.checkZipCodeEmptyFieldMessage());
        Thread.sleep(3000);
    }
    @Test
    public void fillFieldsNegativeZipCode1NotValid() throws InterruptedException {
        rutSignUPPage
                .fillFirstnameField("firstname")
                .fillLastNameField("lastname")
                .fillEmailField("email@yopmail.com")
                .fillZipCode1Field("00000")
                .fillZipCode2Field("11")
                .fillCompanyField("company")
                .clickToContinue()
                .waitForZipCodeWarning();
        assertTrue("No Zip code not valid warning", rutSignUPPage.checkZipCodeNotValidFieldMessage());
        Thread.sleep(3000);
    }
    @Test
    public void signUpNegativeCapchaMessage() throws InterruptedException {
        rutSignUPPage
                .fillFirstnameField("firstname")
                .fillLastNameField("lastname")
                .fillEmailField("email@yopmail.com")
                .fillZipCode1Field("00501")
                .fillZipCode2Field("11")
                .fillCompanyField("company")
                .clickToContinue()
                .waitForCapchaWarning();
        assertTrue("No Capcha message warning", rutSignUPPage.checkPageForCaptchaMessage());
        Thread.sleep(3000);
    }
    @Test
    public void fillSignUpManual(){
        rutSignUPPage.fillSignUPFields();
    }
//    @AfterClass(alwaysRun = true)
//    public void tearDown(){
//        this.driver.quit();
//    }
}
