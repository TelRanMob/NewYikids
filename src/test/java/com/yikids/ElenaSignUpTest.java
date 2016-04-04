package com.yikids;

import com.yikids.pages.ElenaSignUPPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


//@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class ElenaSignUpTest {

  //static String driverPath = "D:\\Tel_Ran\\Java\\webDrivers\\";
    public ElenaSignUPPage elenaSignUPPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
      //System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
        driver = new ChromeDriver();

        //driver = new FirefoxDriver();
        elenaSignUPPage = PageFactory.initElements(driver, ElenaSignUPPage.class);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp(){
            elenaSignUPPage.openElenaSignUPPage();
    }

    @Test
    public void fillSignUPFileds() {
        //  Log.info("TestLoginWithExtData was started....");
        elenaSignUPPage
                .fillcompanyField("company")
                .fillemailField("sem@yuopmail.com")
                .fillFirstnameField("firstname")
                .fillLastNameField("last")
                .fillzipcodeField("110000")
                .fillzipCode2Field("55")
               .buttoncontinueButton()
                .checkelement("Please check Captcha!");


        System.out.println("Page title is: " + driver.getTitle());
       System.out.println("Text element ="+elenaSignUPPage.gettext());

       assertTrue( "First Name text is confirmed", elenaSignUPPage.CheckFirstNameLabel());
        assertTrue( "Last Name text is confirmed", elenaSignUPPage.CheckLastNameLabel());
        assertTrue( "Email text is confirmed", elenaSignUPPage.CheckEmailLabel());
        assertTrue( "Zip Code text is confirmed", elenaSignUPPage.CheckZipCodeLabel());
        assertTrue( "Company  text is confirmed", elenaSignUPPage.CheckCompanyNameLabel());
        assertTrue("Check kapcha",elenaSignUPPage.CheckPageForCapthcaMessage());

    }


    // test of clicking on Registration link are written in another class

     @AfterMethod(alwaysRun = true)
    public void tearDown() {
       this.driver.quit();
    }

   /* @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }*/
}