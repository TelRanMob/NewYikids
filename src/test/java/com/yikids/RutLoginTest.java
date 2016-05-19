package com.yikids;

import com.yikids.pages.RutLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by rut on 05.04.2016.
 */
public class RutLoginTest extends TestNgTestBase{
    static String driverPath = "C:\\Telran\\browserDriver\\";
    public RutLoginPage rutLoginPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
//        driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
//      driver = new ChromeDriver();

//        System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
//        driver = new InternetExplorerDriver();
        rutLoginPage = PageFactory.initElements(driver, RutLoginPage.class);
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
//        rutLoginPage.openLoginPage();
        driver.get("http://admin.yikids.com/");
    }

    @Test
    public void loginPositive() throws InterruptedException {
        rutLoginPage
                .fillEmailField("admin@erdocfinder.com")
                .fillPasswordField("Test123")
                .clickLoginButton()
                .waitForLogOutLinkButton();
        assertTrue("We are on Login page", rutLoginPage.isOnOverviewPage());
    }

    @Test (dataProviderClass = RutDataProviders.class, dataProvider = "loadInvalidLogInFromFile")
    public void loginNegative(String login, String pass) throws InterruptedException {
        rutLoginPage
                .fillEmailField(login)
                .fillPasswordField(pass)
                .clickLoginButton();
//        String assertText = "rutLoginPage."+method+";";
        assertTrue("We are not on the Login page", rutLoginPage.isOnLoginPage());
    }

    @Test (dataProviderClass = RutDataProviders.class, dataProvider = "loadLoginMessageFromFile")
    public void loginNegativeMessage(String login, String pass,String message) throws InterruptedException, IOException {
        rutLoginPage
                .fillEmailField(login)
                .fillPasswordField(pass)
                .clickLoginButton();
        Thread.sleep(3000);

        Assert.assertEquals(rutLoginPage.waitAndGetTextofSelectedMessage(), message, "Message is not correct");
        assertTrue("We are not on the Login page", rutLoginPage.isOnLoginPage());
    }

    @Test
    public void goToSignUpPage() throws InterruptedException {
        rutLoginPage
                .clickSignUpButton();
        assertTrue("We are on the Login page", rutLoginPage.isOnSignUpPage());
    }

    @Test
    public void goToForgotPasswordPage() throws InterruptedException {
        rutLoginPage
                .clickForgotPasswordButton();
        assertTrue("We are on the Login page", rutLoginPage.isOnForgotPasswordPage());
    }
        @AfterClass(alwaysRun = true)
    public void tearDown(){
        this.driver.quit();
    }
}