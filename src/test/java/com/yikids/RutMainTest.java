package com.yikids;

import com.yikids.pages.HomePage;
import com.yikids.pages.RutLoginPage;
import com.yikids.pages.RutMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by rut on 06.05.2016.
 */
public class RutMainTest extends TestNgTestBase{
    public WebDriver driver;
    public RutMainPage mainPage;
    public RutLoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void testInit() {
        driver = new FirefoxDriver();
        mainPage = PageFactory.initElements(driver, RutMainPage.class);
        loginPage = PageFactory.initElements(driver, RutLoginPage.class);
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp(){
        driver.get("http://admin.yikids.com");
        loginPage.isOnLoginPage();
        loginPage.login();
        mainPage.isOnMainPage();
    }
    @Test
    public void goToAddHospitalPagePositive() throws InterruptedException {
        mainPage
                .clickHospitalButton()
                .clickAddHospitalButton();
                Thread.sleep(3000);
        assertFalse(mainPage.isOnMainPage(),"We are on AddHospital page");
    }
}
