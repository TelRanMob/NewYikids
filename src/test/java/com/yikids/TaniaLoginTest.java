package com.yikids;
import com.yikids.pages.TaniaLoginPage;
import com.yikids.pages.TaniaMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;


import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

//@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class TaniaLoginTest {
    // private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
        // static String driverPath = "C:\\Development\\browserDriver\\";
    public TaniaLoginPage taniaLoginPage;
    public TaniaMainPage taniaMainPage;
    public WebDriver driver;
    public static String  email = "admin@erdocfinder.com";
    public static String  password = "Test123";
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
    public void loginPositiveTest() {
        //  Log.info("TestLoginWithExtData was started....");
        taniaLoginPage
                .fillEmailField(email)
                .fillpasswordField(password)
                .clickLogInLinkButton();

        // Log.info("negative test - email not exist- sign up...");
      //  assertTrue("No warning about wrong login data appears", taniaLoginPage.CheckPageForNotLogIn());
       // assertTrue("WE are not on login page", taniaLoginPage.isOnLoginPage());
        assertFalse("WE are still on login page", taniaLoginPage.isOnLoginPage());
        assertTrue("WE are still on login page", taniaMainPage.isOnMainPage());
    }

    @Test
    public void loginNegativeTest() {
        //  Log.info("TestLoginWithExtData was started....");
        taniaLoginPage
                .fillEmailField("")
                .fillpasswordField("Test123")
                .clickLogInLinkButton();
        assertFalse("WE are still on login page", taniaMainPage.isOnMainPage());
        // Log.info("negative test - email not exist- sign up...");
     //   assertFalse("WE are still on login page", taniaLoginPage.isOnLoginPage());


    }

  /*  @Test
    public void positivLogin() {
        loginI.fillLodInFieldsPozitive()
                .clickToLoginButton()
                .waitForlogOutButton();
        // verification
        assertTrue("No logOut Buttom ", loginI.isOnMainPage());
    }*/

    @Test
    public void FillLogInFields() {
        taniaLoginPage.FillWrongLogInFields();
        taniaLoginPage.clickLogInLinkButton();
        // Log.info("negative test - email not exist- sign up...");
        assertTrue("No Log in  confirmed", taniaLoginPage.CheckPageForNotLogIn());
    }



    // test of clicking on Registration link are written in another class

    //@AfterClass(alwaysRun = true)
    //    public void tearDown() {
     //   driver.quit();
  //  }
}