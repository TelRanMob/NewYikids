package com.yikids;

import com.yikids.pages.RutSignUPPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by rutga on 29.03.2016.
 */
public class RutSignUpTest {
   // static String driverPath = "C:\\Telran\\browserDriver\\";
    public RutSignUPPage rutSignUPPage;
    public WebDriver driver;

    @BeforeClass
    public void setup() {
//        driver = new FirefoxDriver();
//        System.setProperty("webdriver.ie.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();

      //  System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
       // driver = new InternetExplorerDriver();
        rutSignUPPage = PageFactory.initElements(driver, RutSignUPPage.class);
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        rutSignUPPage.openSignUpPage();
    }
    @Test
    public void fillSignUPFields(){
        rutSignUPPage
                .fillFirstnameField("firstname")
                .fillLastNameField("lastname")
                .fillEmailField("email@yopmail.com")
                .fillZip1CodeField("111111")
                .fillZip2CodeField("222")
                .fillCompanyField("company");
        assertTrue("First Name text not confirmed", rutSignUPPage.CheckFirstNameLabel());
        rutSignUPPage.clickContinueButton();
    }
    @Test
    public void fillSignUpManual(){
        rutSignUPPage.fillSignUPFields();
    }
    @AfterClass(alwaysRun = true)
    public void tearDown(){
        this.driver.quit();
    }
}
