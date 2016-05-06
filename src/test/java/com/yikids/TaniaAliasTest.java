package com.yikids;


import com.yikids.pages.TaniaAlias1Page;
import com.yikids.pages.TaniaSignUPPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

//@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class TaniaAliasTest {
    //static String driverPath = "D:\\Tel_Ran\\Java\\webDrivers\\";
    public TaniaAlias1Page taniaAlias1Page;
    public TaniaSignUPPage taniaSignUPPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
        // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        taniaAlias1Page = PageFactory.initElements(driver, TaniaAlias1Page.class);
        taniaSignUPPage = PageFactory.initElements(driver, TaniaSignUPPage.class);


    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() throws InterruptedException {
        taniaSignUPPage.FillsignUPFields();
        taniaAlias1Page.openTaniaAlias1Page();
        Thread.sleep(3000);
    }

    @Test(groups = {"automatic", "negative", "Tania"}, dataProviderClass = DataProviders.class, dataProvider = "aliasNegativeTests")
    public void aliasNegativeTest(String aliasText, String passwordText, String retypePasswordText) {
        taniaAlias1Page.fillAlias(aliasText, passwordText, retypePasswordText);


        /* try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }


    @Test(groups = {"manual", "negative", "Tania"})
    public void fillSignUPFiledsPositive() throws InterruptedException {
        //  Log.info("TestLoginWithExtData was started....");
        taniaSignUPPage
                .fillcompanyField("company")
                .fillemailField("sem@yuopmail.com")
                .fillFirstnameField("firstname")
                .fillLastNameField("last")
                .fillzipcodeField("110000")
                .fillzipPlusField("55");
        //pass the captcha manually
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        taniaSignUPPage.clickToContinue();

    }

    @Test //negative
    public void WorningNoFillFirstName() {
        taniaSignUPPage
                .NoFillUsernameFields()
                .clickToContinue()
                .waitForWarningFirstNameEmpty();
        System.out.println(taniaSignUPPage.gettext());
        assertTrue("Check warning message the first name feld is empty ", taniaSignUPPage.CheckWarningMessageFirstName());

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