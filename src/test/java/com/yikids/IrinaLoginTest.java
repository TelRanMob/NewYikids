package com.yikids;

import com.yikids.pages.IrinaLoginPage;
import com.yikids.pages.IrinaSignUPPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Irina Primak on 29-Mar-16.
 */
public class IrinaLoginTest {
  //  static String driverPath = "Z:\\Tel-RAN\\aQA\\BrowserDrivers";
    public IrinaLoginPage loginI;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        //System.setProperty("webdriver.crome.driver", driverPath+"chromedriver.exe");
        //driver = new ChromeDriver();
        //System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
        //driver = new InternetExplorerDriver();
        driver = new FirefoxDriver();
        loginI = PageFactory.initElements(driver, IrinaLoginPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        loginI.openLoginPage();
       // signUPPageI.checkPageOpen();
    }


    @Test
    public void PositivLogin() {
        loginI.FillLodInFieldsPozitive();

    }
   /* @Test
    public void fillFildesNegativFirstNameEmpty(){
        signUPPageI
                .fillFirstnameField(" ")
                .fillLastNameField("LastName")
                .fillemailField("email@yopmail.com")
                .fillzipCodeField("4562")
                .fillcompanyField("Compani")
                .fillzipCod2Field("111");
        signUPPageI.clickElemToContinue();
                signUPPageI.checkfirstNameEmptyFieldMessage();
            }
    @Test
    public void fillFildesNegativLastNameEmpty(){
        signUPPageI
                .fillFirstnameField("FirstName")
                .fillLastNameField(" ")
                .fillemailField("email@yopmail.com")
                .fillcompanyField("Compani")
                .fillzipCodeField("4562")
                .fillzipCod2Field("111");
        signUPPageI.clickElemToContinue();
                signUPPageI.checkLastNameEmptyFieldMessage();
    }
    @Test
    public void fillFildesNegativEmailEmpty(){
        signUPPageI
                .fillFirstnameField("FirstName")
                .fillLastNameField("LastName")
                .fillemailField(" ")
                .fillcompanyField("Compani")
                .fillzipCodeField("4562")
                .fillzipCod2Field("111")
                .clickElemToContinue()
                .checkEmailEmptyFieldMessage();
    }
    @Test
    public void fillFildesNegativZipCodeEmpty(){
        signUPPageI
                .fillFirstnameField("FirstName")
                .fillLastNameField("LastName")
                .fillemailField("email@yopmail.com")
                .fillcompanyField("Compani")
                .fillzipCod2Field("111")
                .clickElemToContinue()
                .checkZipEmptyFieldMessage();
    }
    @Test
    public void fillFildesInvalidEmailZipCode(){
        signUPPageI
                .fillFirstnameField("FirstName")
                .fillLastNameField("LastName")
                .fillemailField("email")
                .fillcompanyField("Compani")
                .fillzipCodeField("gffdh")
                .clickElemToContinue()
                .checkEmailInvalidFieldMessage();
        signUPPageI.checkZipInvalidFieldMessage();

    }



    // test of clicking on Registration link are written in another class

   @AfterClass(alwaysRun = true)
   public void tearDown() {
        this.driver.quit();
    }*/
}


