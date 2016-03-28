package com.yikids;

import com.yikids.pages.ElenaSignUPPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


//@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class ElenaSignUpTest {
    // private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    // public static String registered_username = "3339Doctor";
    // public static String registered_password = "LinkCare!!11";
   static String driverPath = "D:\\Tel_Ran\\Java\\webDrivers\\";

    public ElenaSignUPPage elenaSignUPPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
       System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
       driver = new ChromeDriver();
      //System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
       // driver = new InternetExplorerDriver();

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

    }


    // test of clicking on Registration link are written in another class

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}