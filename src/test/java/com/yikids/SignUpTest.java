package com.yikids;

import com.yikids.pages.SignUPPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class SignUpTest {
    // private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    // public static String registered_username = "3339Doctor";
    // public static String registered_password = "LinkCare!!11";
    public SignUPPage signUPPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {

        driver = new InternetExplorerDriver();//ChromeDriver(); //
        signUPPage = PageFactory.initElements(driver, SignUPPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        signUPPage.openSignUpPage();
    }

    @Test
    public void fillSignUPFileds() {
        //  Log.info("TestLoginWithExtData was started....");
        signUPPage
                .fillCompany1Field("company")
                .fillEmsilField("ss@yuopmail.com")
                .fillFirstnameField("firstname")
                .fillLastNameField("last")
                .fillZip1Field("110000")
                .fillZip21Field("55")
                .clickToContinue();
    }


    // test of clicking on Registration link are written in another class

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}