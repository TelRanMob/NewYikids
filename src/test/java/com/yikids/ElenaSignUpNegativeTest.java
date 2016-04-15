package com.yikids;

import com.yikids.pages.ElenaSignUPPage;
import com.yikids.util.ElenaDataProviders;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

//@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class ElenaSignUpNegativeTest {
    //static String driverPath = "D:\\Tel_Ran\\Java\\webDrivers\\";
    public ElenaSignUPPage elenaSignUPPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
       // driver = new ChromeDriver();
       driver = new FirefoxDriver();
        elenaSignUPPage = PageFactory.initElements(driver, ElenaSignUPPage.class);


    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp(){elenaSignUPPage.openElenaSignUPPage();
    }


    @Test(dataProviderClass = ElenaDataProviders.class, dataProvider = "loadInvalidSingUpFromFile")
    public void SingUppNegativeTest(String Firstname, String lastname, String email, String Zip1, String Zip2, String nubmer, String message) throws IOException, InterruptedException {
        elenaSignUPPage
        .fillFirstnameField(Firstname)
        .fillLastNameField(lastname)
                .fillemailField(email)
        .fillzipcodeField(Zip1)
        .fillzipCode2Field(Zip2)
                .buttoncontinueButton();

       // System.out.println(elenaSignUPPage.gettext());
        //assertTrue("Check warning message the first name feld is ampty ",elenaSignUPPage.CheckWarningMessageFirstName());
        Assert.assertEquals(elenaSignUPPage.waitAndGetTextofSelectedMessage(nubmer), message, "Message is nor correct");

    }


    /* @AfterMethod(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }*/

   @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}