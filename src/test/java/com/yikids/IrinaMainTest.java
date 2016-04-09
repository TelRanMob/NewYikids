package com.yikids;

import com.yikids.pages.IrinaLoginPage;
import com.yikids.pages.IrinaMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Irina Primak on 29-Mar-16.
 */
public class IrinaMainTest {
  //  static String driverPath = "Z:\\Tel-RAN\\aQA\\BrowserDrivers";
    public IrinaMainPage mainI;
    //public IrinaLoginPage loginI;
    public WebDriver driver;
    public String email = "admin@erdocfinder.com";
    public String password = "Test123";

    @BeforeClass(alwaysRun = true)
    public void setup() {
        //System.setProperty("webdriver.crome.driver", driverPath+"chromedriver.exe");
        //driver = new ChromeDriver();
        //System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
        //driver = new InternetExplorerDriver();
        driver = new FirefoxDriver();
        mainI = PageFactory.initElements(driver, IrinaMainPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        mainI.openAdminMainPage();
        //mainI.fillLodInFieldsPozitive();
        //verification
        //assertTrue("loginButtom not appeare",loginI.isOnLoginPage());
    }

        @Test
    public void goToAddHospitalPositiv() {
       mainI.goToAddHospital();

        }

    // test of clicking on Registration link are written in another class

   @AfterClass(alwaysRun = true)
   public void tearDown() {
        this.driver.quit();
    }
}



