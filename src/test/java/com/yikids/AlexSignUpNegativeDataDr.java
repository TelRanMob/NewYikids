package com.yikids;

/*
 * Created by Alexandr on 20.04.2016.
 */

import com.yikids.pages.AlexSignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

/***
 * CLASS STARTS
 ***/

public class AlexSignUpNegativeDataDr {

    /* Building */

    public AlexSignUpPage alexsignuppage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        alexsignuppage = PageFactory.initElements(driver, AlexSignUpPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetup() {
        alexsignuppage.openSignUpPage();
    }

    /* Tests */

    @Test(dataProviderClass = DataProvider.class, dataProvider = "Invalid Data From Resources")
    public void signUpNegativeTest(String name, String surname, String email, String zip1, String zip2, String message) {
        alexsignuppage.fillFirstnameField(name)
                .fillLastNameField(surname)
                .fillEmailField(email)
                .fillZip1Field(zip1)
                .fillZip21Field(zip2)
                .clickToContinue();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    /*** CLASS ENDS ***/

}
