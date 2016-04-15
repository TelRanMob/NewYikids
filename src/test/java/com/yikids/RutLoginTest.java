package com.yikids;

import com.yikids.pages.RutLoginPage;
import com.yikids.pages.RutSignUPPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by rutga on 05.04.2016.
 */
public class RutLoginTest {
    // static String driverPath = "C:\\Telran\\browserDriver\\";
    public RutLoginPage rutLoginPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
//        System.setProperty("webdriver.ie.driver", driverPath + "chromedriver.exe");
//      driver = new ChromeDriver();

//        System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
//        driver = new InternetExplorerDriver();
        rutLoginPage = PageFactory.initElements(driver, RutLoginPage.class);
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        rutLoginPage.openLoginPage();
    }
    @Test
    public void logInPositive() throws InterruptedException {
        rutLoginPage
                .fillEmailField("admin@erdocfinder.com")
                .fillPasswordField("Test123")
                .clickLoginButton();
        assertTrue("We are on Log In page", rutLoginPage.isOnOverviewPage());
        Thread.sleep(3000);
    }
    @Test (dataProviderClass = RutDataProviders.class, dataProvider = "loadInvalidLogInFromFile")
    public void logInNegative(String login, String pass) throws InterruptedException {
        rutLoginPage
                .fillEmailField(login)
                .fillPasswordField(pass)
                .clickLoginButton();
//        String assertText = "rutLoginPage."+method+";";

        assertTrue("We are not on the Log In page", rutLoginPage.isOnLoginPage());
//        assertTrue("No Email error message", rutLoginPage.checkEmailNotValidMessage());
//        assertTrue("No Email error message", rutLoginPage.checkEmailNotValidMessage());
//        assertTrue("No Password error message", rutLoginPage.checkPasswordNotValidMessage());
//        assertTrue("No Forgot password button", rutLoginPage.checkForgotPasswordMessage());
        Thread.sleep(3000);
    }
    @Test
    public void goToSignUpPage() throws InterruptedException {
        rutLoginPage
                .clickSignUpButton();
        assertTrue("We are on the Log In page", rutLoginPage.isOnSignUpPage());
        Thread.sleep(3000);
    }
    @Test
    public void goToForgotPasswordPage() throws InterruptedException {
        rutLoginPage
                .clickForgotPasswordButton();
        assertTrue("We are on the Log In page", rutLoginPage.isOnForgotPasswordPage());
        Thread.sleep(3000);
    }
}