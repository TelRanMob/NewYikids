package com.yikids.util;

import com.yikids.pages.ElenaLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

//@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class ElenaLoginTest {

  //static String driverPath = "D:\\Tel_Ran\\Java\\webDrivers\\";
    public ElenaLoginPage elenaLoginPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
      //System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
        driver = new ChromeDriver();

      // driver = new FirefoxDriver();
        elenaLoginPage = PageFactory.initElements(driver, ElenaLoginPage.class);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp(){
        elenaLoginPage.openLoginPage();
    }

    @Test//positive test
    public void PositiveLoginTest() {
        //  Log.info("TestLoginWithExtData was started....");
        elenaLoginPage
                .fillEmailField("admin@erdocfinder.com")
                .fillPasswordField("Test123")
                .ClickLoginButton();


        System.out.println("Page title is: " + driver.getTitle());
      // System.out.println("Text element ="+elenaLoginPage.gettext());

      assertTrue( "The text element LogOut is present on the page", elenaLoginPage.CheckTextOfElementLogOut());

      assertTrue("Check : the element LogOut is present on the page",elenaLoginPage.CheckElementLogOu());

    }
    @Test//negative test
    public void NegstiveLoginTest() {
        //  Log.info("TestLoginWithExtData was started....");
        elenaLoginPage
                .fillEmailField("Login@yoopmail.com")
                .fillPasswordField("Asd1234")
                .ClickLoginButton();


        assertTrue( "The text error email is present on the page", elenaLoginPage.CheckTextErrorEmail());

        assertTrue("Check : the element Login is present on the page",elenaLoginPage.CheckElementLogIn());

    }





  @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}