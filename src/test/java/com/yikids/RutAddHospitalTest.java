package com.yikids;


import com.yikids.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by rut on 05.05.2016.
 */
public class RutAddHospitalTest extends TestNgTestBase {
    // private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public RutAddHospitalPage addHospitalPage;
    public RutLoginPage loginPage;
    public RutMainPage mainPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        addHospitalPage = PageFactory.initElements(driver, RutAddHospitalPage.class);
        loginPage = PageFactory.initElements(driver, RutLoginPage.class);
        mainPage = PageFactory.initElements(driver, RutMainPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        driver.get("http://admin.yikids.com/");
        loginPage.isOnLoginPage();
        loginPage.login();
        mainPage.isOnMainPage();
        mainPage.goToAddHospitalPage();
    }
    @Test
    public void addHospitalPositive (){
        addHospitalPage.fillAddHospitalProfile();
    }
}
