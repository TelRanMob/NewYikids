package com.yikids;

/*
 * Created by Alexandr on 20.04.2016.
 */

import com.yikids.pages.AlexHospOwnerMangmntPage;
import com.yikids.pages.AlexLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/***
 * CLASS STARTS
 ***/

public class AlexHospOwnerMangmntPageTest {

    public AlexHospOwnerMangmntPage alexhospownermangmntpage;
    public AlexLoginPage alexloginpage;
    public WebDriver driver = new FirefoxDriver();

    @BeforeClass(alwaysRun = true)
    public void setup() {
        alexloginpage = PageFactory.initElements(driver, AlexLoginPage.class);
        alexhospownermangmntpage = PageFactory.initElements(driver, AlexHospOwnerMangmntPage.class);
        alexloginpage.OpenLoginPage();
        alexloginpage.positiveLogIn();
        alexloginpage.clickLoginButton();
    }

    @BeforeMethod(alwaysRun = true)
    public void openSetUp() {
        alexhospownermangmntpage.OpenPage();
    }


    @Test(groups = {"Alex"})
    public void checkingBoxesStatus() {
        alexhospownermangmntpage.checkCheckBoxes(10);
    }

    //@Test
    public void checkingNotAllBoxesStatus() {
        alexhospownermangmntpage.checkForNotAllCheckBoxes(10, "Owned");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    /*** CLASS ENDS ***/

}
