package com.yikids;

import com.yikids.pages.TaniaSignUPPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;


import java.io.IOException;

//@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class TaniaSignUpNegTest {
    //static String driverPath = "D:\\Tel_Ran\\Java\\webDrivers\\";
    public TaniaSignUPPage taniaSignUPPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
        // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        taniaSignUPPage = PageFactory.initElements(driver, TaniaSignUPPage.class);


    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        taniaSignUPPage.openTaniaSignUPPage();
    }


    @Test(dataProviderClass = TaniaDataProviders.class, dataProvider = "loadInvalidSingUpFromFile")
    public void SingUppNegativeTest(String Firstname, String lastname, String email, String Zip1, String Zip2, String nubmer, String message) throws IOException, InterruptedException {
        taniaSignUPPage
                .fillFirstnameField(Firstname)
                .fillLastNameField(lastname)
                .fillemailField(email)
                .fillzipcodeField(Zip1)
                .fillzipPlusField(Zip2)
                .clickToContinue();

        // System.out.println(taniaSignUPPage.gettext());
        //assertTrue("Check warning message the first name feld is empty ",taniaSignUPPage.CheckWarningMessageFirstName());
        Assert.assertEquals(taniaSignUPPage.waitAndGetTextofSelectedMessage(nubmer), message, "Message is nor correct");

    }


    /* @AfterMethod(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }*/

  //  @AfterClass(alwaysRun = true)
  //  public void tearDown() {
      //  driver.quit();
  //  }
}