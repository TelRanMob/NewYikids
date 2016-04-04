package com.yikids;


import com.yikids.pages.TaniaLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

//@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class TaniaLoginTest {
    // private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    // public static String registered_username = "3339Doctor";
    // public static String registered_password = "LinkCare!!11";
    // static String driverPath = "C:\\Development\\browserDriver\\";
    public TaniaLoginPage taniaLoginPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        // System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
        //System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
       // driver = new FirefoxDriver();
        driver =new ChromeDriver();
        taniaLoginPage = PageFactory.initElements(driver,TaniaLoginPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        taniaLoginPage.openLoginPage();
    }

    @Test
    public void loginNegativeTest() {
        //  Log.info("TestLoginWithExtData was started....");
        taniaLoginPage
                .fillEmailField("email333@yuopmail.com")
                .fillpasswordField("307607608")
                .clickLogInLinkButton();


     ;

        // Log.info("negative test - email not exist- sign up...");
        assertTrue("No warning about wrong login data appears", taniaLoginPage.CheckPageForNotLogIn());
        assertTrue("WE are not on login page", taniaLoginPage.isOnLoginPage());

    }

    @Test
    public void loginPositiveTest() {
        //  Log.info("TestLoginWithExtData was started....");
        taniaLoginPage
                .fillEmailField("admin@erdocfinder.com")
                .fillpasswordField("Test123")
                .clickLogInLinkButton();
        assertTrue("WE are on overview page", taniaLoginPage.isOnOverviewPage());
        // Log.info("negative test - email not exist- sign up...");
      //  assertFalse("WE are still on login page", taniaLoginPage.isOnLoginPage());


    }



    @Test
    public void FillLogInFields() {
        taniaLoginPage.FillLogInFields();
        taniaLoginPage.clickLogInLinkButton();
        // Log.info("negative test - email not exist- sign up...");
        assertTrue("First Name text not confirmed", taniaLoginPage.CheckPageForNotLogIn());
    }



    // test of clicking on Registration link are written in another class

    //@AfterClass(alwaysRun = true)
    //    public void tearDown() {
     //   driver.quit();
  //  }
}