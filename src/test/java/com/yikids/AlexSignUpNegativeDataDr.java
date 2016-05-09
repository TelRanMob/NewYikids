package com.yikids;

/*
 * Created by Alexandr on 20.04.2016.
 */

import com.yikids.pages.AlexSignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/***
 * CLASS STARTS
 ***/

public class AlexSignUpNegativeDataDr {

    /* Building */

    public AlexSignUpPage alexsignuppage;
    public WebDriver driver = new FirefoxDriver();

    @BeforeClass(alwaysRun = true)
    public void setup() {
        alexsignuppage = PageFactory.initElements(driver, AlexSignUpPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void openSetUp() {
        alexsignuppage.openSignUpPage();
    }

    /* Tests */


    @Test(groups = {"Alex"}, dataProviderClass = DataProviders.class, dataProvider = "AlexloadProfileDataFromFile")
    public void signUpNegativeTest(String name, String surname, String email, String zip1, String zip2, String number, String message) throws IOException, InterruptedException {
        alexsignuppage.fillFirstnameField(name)
                .fillLastNameField(surname)
                .fillEmailField(email)
                .fillZip1Field(zip1)
                .fillZip21Field(zip2)
                .clickToContinue();

        Assert.assertEquals(alexsignuppage.waitforWrongDataMessages(number), message, "Wrong message is not displayed");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    /*** CLASS ENDS ***/

}
