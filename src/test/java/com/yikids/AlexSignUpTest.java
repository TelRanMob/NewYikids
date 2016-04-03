package com.yikids;

/*
 * Created by Alexandr on 03.04.2016.
 */

import com.yikids.pages.AlexSignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlexSignUpTest {


    //static String driverPath = "C:\\Users\\Alexandr\\Documents\\WebDriver\\";
    public AlexSignUpPage alexsignuppage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {

        //System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
        driver = new FirefoxDriver();
        alexsignuppage = PageFactory.initElements(driver, AlexSignUpPage.class);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        alexsignuppage.openSignUpPage();
    }

    @Test
    public void FillSiteFields() {

        alexsignuppage
                .fillFirstnameField("TestName")
                .fillLastNameField("TestSurname")
                .fillEmailField("TestMail@youpmail.com")
                .fillZip1Field("11000")
                .fillZip21Field("55")
                .fillCompany1Field("TestCompany")
                .clickToContinue();

    }

    @Test
    public void FillSignUpManually() {
        alexsignuppage.FillSignUp();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }

}
