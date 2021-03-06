package com.yikids;

import com.yikids.pages.IrinaHospOwnerManagPage;
import com.yikids.pages.IrinaLoginPage;
import com.yikids.pages.IrinaMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Irina Primak on 29-Mar-16.
 */
public class IrinaHospOwnerManagTest {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
  //  static String driverPath = "Z:\\Tel-RAN\\aQA\\BrowserDrivers";
    public IrinaMainPage mainI;
    public IrinaLoginPage loginI;
    public IrinaHospOwnerManagPage hospManagI;
    public WebDriver driver;
    //public String email = "admin@erdocfinder.com";
    //public String passwordField = "Test123";

    @BeforeClass(alwaysRun = true)
    public void setup() {
        Log.info("TestLoginWithExtData was started....");
        //System.setProperty("webdriver.crome.driver", driverPath+"chromedriver.exe");
        //driver = new ChromeDriver();
        //System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
        //driver = new InternetExplorerDriver();
        driver = new FirefoxDriver();
        hospManagI = PageFactory.initElements(driver, IrinaHospOwnerManagPage.class);
        mainI = PageFactory.initElements(driver, IrinaMainPage.class);
        loginI = PageFactory.initElements(driver, IrinaLoginPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() throws IOException, InterruptedException {
        Log.info("Opening page OwnerManagement");
        loginI.openLoginPage()
                .waitForloginButton();
        loginI.fillLodInFieldsPozitive();
        //mainI.waitForMainPageLoad();
        //mainI.waitForLogoutSign();
        hospManagI.goToHospitalOwnerManagment();
        hospManagI.waitForhospitalOwnerManagementPageTitle();
        assertTrue("Not on PageHospitalOwnerManagment",hospManagI.checkPageHospOwnerManagOpen());
    }

   // @Test
   // public void openRecrutersList(){
    //    hospManagI.showAll();
   // }

    @Test
    public void checkBoxesStatus() throws IOException, InterruptedException {
        Log.info("Checking boxes with stutus");
        //hospManagI.showAll();
        hospManagI.waitForTableLoad();
        hospManagI.checkNumCheckbxesWithStususFromAll(20,"Owned");
        //hospManagI.checkNotAllCheckbxes(10,"Owned");
                           }

    // test of clicking on Registration link are written in another class

   @AfterClass(alwaysRun = true)
   public void tearDown() {
        this.driver.quit();
    }

}



