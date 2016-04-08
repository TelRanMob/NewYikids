package com.yikids;

import com.yikids.pages.TaniaSignUPPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertTrue;

public class TaniaSignUpTest {
   // static String driverPath = "C:\\Development\\browserDriver\\";

    public TaniaSignUPPage taniaSignUPPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
      // System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
     //  driver = new ChromeDriver();
      //System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
       // driver = new InternetExplorerDriver();

        driver = new FirefoxDriver();
        taniaSignUPPage = PageFactory.initElements(driver, TaniaSignUPPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp(){
        taniaSignUPPage.openTaniaSignUPPage();
    }

    /* Negative tests */
    @Test
    public void fillSignUPFileds() {
        //  Log.info("TestLoginWithExtData was started....");
        taniaSignUPPage
                .fillcompanyField("company")
                .fillemailField("sem@yuopmail.com")
                .fillFirstnameField("firstname")
                .fillLastNameField("last")
                .fillzipcodeField("00501")
                .fillzipPlusField("55")
                .clickToContinue()
                .waitForWarningCapchaMessage();
        assertTrue(" captha message", taniaSignUPPage.CheckPageForCapthcaMessage());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
              //  .checkelement("Please check Captcha!");
      //  System.out.println("Page title is: " + driver.getTitle());


    @Test
    public void fillFildesNegativFirstNameEmpty() throws InterruptedException {

        taniaSignUPPage
                .fillFirstnameField(" ")
                .fillLastNameField("LastName")
                .fillemailField("email@yopmail.com")
                .fillzipcodeField("4562")
                .fillcompanyField("Compani")
                .fillzipPlusField("111")
                .clickToContinue()
                .waitForWarningFirstNameEmpty();

        assertTrue("Firstname empty warning message", taniaSignUPPage.checkFirstNameErrorMessage());
        Thread.sleep(3000);
    }

    @Test
    public void fillFildesNegativLastNameEmpty() throws InterruptedException {

        taniaSignUPPage
                .fillFirstnameField("Ivan")
                .fillLastNameField("")
                .fillemailField("email@yopmail.com")
                .fillzipcodeField("4562")
                .fillcompanyField("Compani")
                .fillzipPlusField("111")
                .clickToContinue()
                .waitForWarningLastNameEmpty();

        assertTrue("Lastname empty warning message", taniaSignUPPage.checkLastNameErrorMessage());
        Thread.sleep(3000);
    }
    @Test
    public void fillFildesNegativInvalidEmail() throws InterruptedException {

        taniaSignUPPage
                .fillFirstnameField("Inna")
                .fillLastNameField("LastName")
                .fillemailField("emailyopmail.com")
                .fillzipcodeField("4562")
                .fillcompanyField("Compani")
                .fillzipPlusField("111")
                .clickToContinue()
                .waitForWarningEmailEmpty();

        assertTrue("Not valid Email warning message", taniaSignUPPage.checkEmailInvalidErrorMessage());
       // Thread.sleep(3000);
    }
    @Test
    public void fillFildesNegativRequiredEmail() throws InterruptedException {

        taniaSignUPPage
                .fillFirstnameField("Inna")
                .fillLastNameField("LastName")
                .fillemailField("")
                .fillzipcodeField("4562")
                .fillcompanyField("Compani")
                .fillzipPlusField("111")
                .clickToContinue()
                .waitForWarningEmailEmpty();

        assertTrue("Empty Email warning message", taniaSignUPPage.checkEmailRequiredErrorMessage());
        Thread.sleep(3000);
    }

    @Test
    public void fillFildesNegativZipCode() throws InterruptedException {

        taniaSignUPPage
                .fillFirstnameField("Inna")
                .fillLastNameField("LastName")
                .fillemailField("aaa@ggg.gg")
                .fillzipcodeField("")
                .fillcompanyField("Compani")
                .fillzipPlusField("11")
                .clickToContinue()
                .waitForWarningZipCodeMessageEmpty();

        assertTrue("Zip Code Empty warning message", taniaSignUPPage.checkZipCodeEmptyMessage());
        Thread.sleep(3000);
    }

    @Test
    public void fillFildesNegativInvalidZipCode() throws InterruptedException {

        taniaSignUPPage
                .fillFirstnameField("Inna")
                .fillLastNameField("LastName")
                .fillemailField("aaa@ggg.gg")
                .fillzipcodeField("00b")
                .fillcompanyField("Compani")
                .fillzipPlusField("11")
                .clickToContinue()
                .waitForWarningZipCodeMessageEmpty();

        assertTrue("Zip Code Invalid warning message", taniaSignUPPage.checkZipCodeInvalidMessage());
        Thread.sleep(3000);
    }
    @Test
    public void fillFildesNegativInvalidZipPlusCode() throws InterruptedException {

        taniaSignUPPage
                .fillFirstnameField("Inna")
                .fillLastNameField("LastName")
                .fillemailField("aaa@ggg.gg")
                .fillzipcodeField("00501")
                .fillcompanyField("Compani")
                .fillzipPlusField("aaa")
                .clickToContinue()
                .checkZipPlusMessage();

        assertTrue("Zip Plus Invalid warning message", taniaSignUPPage.checkZipPlusMessage());

    }
    //hbh

   // @AfterClass(alwaysRun = true)
  //  public void tearDown() {
   //     this.driver.quit();
  // }
}