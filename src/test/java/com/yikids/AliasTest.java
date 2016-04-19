package com.yikids;

import com.yikids.pages.Alias1Page;
import com.yikids.pages.ElenaSignUPPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

//@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class AliasTest {
    //static String driverPath = "D:\\Tel_Ran\\Java\\webDrivers\\";
    public Alias1Page alias1Page;
    public ElenaSignUPPage elenaSignUPPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
        // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        alias1Page = PageFactory.initElements(driver, Alias1Page.class);
        elenaSignUPPage = PageFactory.initElements(driver, ElenaSignUPPage.class);


    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() throws InterruptedException {
        elenaSignUPPage.FillsignUPFields();
        Thread.sleep(3000);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "aliasNegativeTests")
    public void aliasNegativeTest(String aliasText, String passwordText, String retypePasswordText) {
        alias1Page.fillAlias(aliasText, passwordText, retypePasswordText);


        /* try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }


    @Test
    public void fillSignUPFiledsPositive() throws InterruptedException {
        //  Log.info("TestLoginWithExtData was started....");
        elenaSignUPPage
                .fillcompanyField("company")
                .fillemailField("sem@yuopmail.com")
                .fillFirstnameField("firstname")
                .fillLastNameField("last")
                .fillzipcodeField("110000")
                .fillzipCode2Field("55");
        //pass the captcha manually
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        elenaSignUPPage.buttoncontinueButton();

    }

    @Test //negative
    public void WorningNoFillFirstName() {
        elenaSignUPPage
                .NoFillUsernameFields()
                .buttoncontinueButton()
                .waitForFirstNameWarning();
        System.out.println(elenaSignUPPage.gettext());
        assertTrue("Check warning message the first name feld is empty ", elenaSignUPPage.CheckWarningMessageFirstName());

    }

    @Test //negative
    public void WorningFieldFirstNameWrong() {
        elenaSignUPPage
                .WrongFillUsernameFields()
                .buttoncontinueButton()
                .waitForFirstNameWarning1();

        assertTrue("Check warning message the first name field is wrongly filled ", elenaSignUPPage.CheckWarningMessageFirstNameisSimbols());

    }

    @Test//negative
    public void WorningFieldFirstNameOneNumber() {
        elenaSignUPPage
                .OneNumbFillFirstName()
                .buttoncontinueButton()
                .waitForFirstNameWarning2();
        assertTrue("Check warning message the first name field is one number ", elenaSignUPPage.CheckWarningMessageFirstNameisOneNumber());

    }

    @Test//negative
    public void WorningNoFillLastNane() {
        elenaSignUPPage
                .NoFillLastnameFields()
                .buttoncontinueButton()
                .waitForLasttNameWarning1();
        assertTrue("Check warning massage the Last name feld is ampty ", elenaSignUPPage.CheckWarningMessageLastName());

    }

    @Test//negative
    public void WorningFieldLastNameWrong() {
        elenaSignUPPage
                .WrongFillLastnameFields()
                .buttoncontinueButton()
                .waitForLasttNameWarning2();
        assertTrue("Check warning message the Last name field is wrongly filled ", elenaSignUPPage.CheckWarningMessageLastNameisSimvols());

    }

    @Test//negative
    public void WorningNoFieldEmail() {
        elenaSignUPPage
                .NoFillEmailFields()
                .buttoncontinueButton()
                .waitForEmailWarning1();
        assertTrue("Check warning message the email field is ampty ", elenaSignUPPage.CheckWarningMessageEmail());

    }

    @Test//negative
    public void WoringNoFillZipCode() {
        elenaSignUPPage
                .NoFillZipCodeFields()
                .buttoncontinueButton()
                .waitForZipCodeWarning1();
        assertTrue("Check warning message the Zip Code field is ampty ", elenaSignUPPage.CheckWarningMessageZipCod());

    }

    @Test//negative
    public void WoringFieldZipCodeWrongNumb() {
        elenaSignUPPage
                .WrongFillZipCodeFields()
                .buttoncontinueButton()
                .waitForZipCodeWarning2();
        assertTrue("Check warning message the Zip Code field is wrongly filled of numbers ", elenaSignUPPage.CheckWarningMessageWrongZipCod());

    }

    @Test//negative
    public void WoringFieldZipCodeWrongLetters() {
        elenaSignUPPage
                .FillZipCodeFieldsofLetters()
                .buttoncontinueButton()
                .waitForZipCodeWarning3();
        assertTrue("Check warning message the Zip Code field is wrongly filled of letters ", elenaSignUPPage.CheckWarningMessageZipCodLetters());

    }

    // test of clicking on Registration link are writtenw in another class

    /* @AfterMethod(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }*/

  /*  @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }*/
}