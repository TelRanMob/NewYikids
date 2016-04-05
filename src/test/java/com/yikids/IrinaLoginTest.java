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

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Irina Primak on 29-Mar-16.
 */
public class IrinaLoginTest {
  //  static String driverPath = "Z:\\Tel-RAN\\aQA\\BrowserDrivers";
    public IrinaLoginPage loginI;
    public WebDriver driver;
    public String email = "admin@erdocfinder.com";
    public String password = "Test123";

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
        //verification
        //assertTrue("loginButtom not appeare",loginI.isOnLoginPage());
    }

    @Test
    public void positivLogin() {
        loginI.fillLodInFieldsPozitive();

        loginI.clickToLoginButton();
        // verification
        assertTrue("logOutButtom desappeare", loginI.isAfterLoginPage());
    }
     @Test
    public void negativEmptyEmailLogin(){
       loginI.fillEmailField(" ")
               .fillPasswordField(password);
       loginI.clickToLoginButton();
       //verufication
       assertTrue("loginButtom desappeare",loginI.isOnLoginPage());

   }
    @Test
    public void negativEmptyPasswordLogin(){
        loginI.fillEmailField(email)
                .fillPasswordField(" ");
        loginI.clickToLoginButton();
        //verufication
        assertTrue("loginButtom disappeare",loginI.isOnLoginPage());

    }
    @Test
    public void EmptyEdLogin(){
        loginI.fillEmailField(email)
                .fillPasswordField("password");
        loginI.clickToLoginButton();
           //verufication
        assertTrue("UncorrectPasswordMessage desapeare", loginI.passwordNotCorrect());
        assertTrue("loginButtom disappeare",loginI.isOnLoginPage());

    }

    @Test
    public void signUp(){
        loginI.clickToSignUpButton();
        //verufication
         assertTrue("SignUp Page Title desappear",loginI.checkPageSignUpOpen());

    }
    @Test
    public void forgotPassword(){
        loginI.clickToForgotPasswordButton();
        //verufication
        assertTrue("ResetPasswordPage desapeare",loginI.checkPageResetPassword());

    }


    // test of clicking on Registration link are written in another class

   @AfterClass(alwaysRun = true)
   public void tearDown() {
        this.driver.quit();
    }
}



