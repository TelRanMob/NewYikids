package com.yikids;

import com.yikids.pages.IrinaLoginPage;
import org.apache.log4j.Logger;
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
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
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
        Log.info("Opening login page");
        loginI.openLoginPage()
                .waitForloginButton();
        //verification
        //assertTrue("loginButtom not appeare",loginI.isOnLoginPage());
    }

    @Test(groups = {"automatic", "negative", "Irina"})
    public void negativEmptyEmailLoginEmptyPassword(){
        Log.info("Negativ test");
        loginI.clickToLoginButton()
              .waitForloginButton();
        //verufication
        assertTrue("No login Buttom ",loginI.isOnLoginPage());

    }

       @Test
    public void negativEmptyEmail(){
           Log.info("negativ test");
       loginI.fillEmailField(" ")
               .fillPasswordField(password)
               .clickToLoginButton()
               .waitForloginButton();
       //verufication
       assertTrue("No login Buttom",loginI.isOnLoginPage());

   }

    @Test(groups = {"automatic", "negative", "Irina"}, dataProviderClass = DataProviders.class, dataProvider = "loadInvalidLoginFromFile")
    public void negativEmptyPasswordLogin(String login, String password){
        Log.info("Negativ test with data provider");
        loginI.fillEmailField(login)
                .fillPasswordField(password)
                .clickToLoginButton()
                .waitForloginButton();
                //verufication

        assertTrue("No login Buttom",loginI.isOnLoginPage());

    }
    @Test
    public void negativNotCorrectPasswordLogin(){
        loginI.fillEmailField(email)
                .fillPasswordField("passwordField")
                .clickToLoginButton()
                .waitForErrorPasswordMessage();
        //verufication
        assertTrue("No Error PasswordMessage ", loginI.passwordNotCorrect());
        assertTrue("No login Buttom",loginI.isOnLoginPage());

    }
    @Test
    public void positivForForgotPasswordPage(){
        loginI.fillEmailField(email)
                .fillPasswordField("passwordField")
                .clickToLoginButton()
                .clickNotCorrectPasswordForgotPasswordButton()
                .waitForResetPasswordButtom();
        //verufication
        assertTrue("No ResetPassord Buttom", loginI.isOnResetPasswordPage());
        assertTrue("Not on resetPassword Page",loginI.checkPageResetPassword());
        assertTrue("loginButtom disappeare",loginI.isOnLoginPage());

    }

    @Test
    public void positivLogin() {
        Log.info("Pozitive test ");
        loginI.fillLodInFieldsPozitive()
                .clickToLoginButton()
                .waitForlogOutButton();
        // verification
        assertTrue("No logOut Buttom ", loginI.isOnMainPage());
    }
    @Test
    public void negativ5TimesNotCorrectPasswordLogin(){
        loginI.fillEmailField(email)
                .fillPasswordField("passwordField")
                .clickToLoginButton()
                .waitForErrorPasswordMessage();
        //verufication
        assertTrue("No No Error PasswordMessage1 ", loginI.passwordNotCorrect());
        assertTrue("No login Buttom",loginI.isOnLoginPage());
        loginI.fillEmailField(email)
                .fillPasswordField("passwordField")
                .clickToLoginButton()
                .waitForErrorPasswordMessage();
        //verufication
        assertTrue("No No Error PasswordMessage2 ", loginI.passwordNotCorrect());
        assertTrue("No login Buttom",loginI.isOnLoginPage());
        loginI.fillEmailField(email)
                .fillPasswordField("passwordField")
                .clickToLoginButton()
                .waitForErrorPasswordMessage();
        //verufication
        assertTrue("No No Error PasswordMessage3 ", loginI.passwordNotCorrect());
        assertTrue("No login Buttom",loginI.isOnLoginPage());
        loginI.fillEmailField(email)
                .fillPasswordField("passwordField")
                .clickToLoginButton()
                .waitForErrorPasswordMessage();
        //verufication
        assertTrue("No Error PasswordMessage4 ", loginI.passwordNotCorrect());
        assertTrue("No login Buttom",loginI.isOnLoginPage());
        loginI.fillEmailField(email)
                .fillPasswordField("passwordField")
                .clickToLoginButton();

        loginI.waitForWarningLoginMessage();
        assertTrue("No Warning LoginMessage", loginI.checkWarningLoginMessage());
    }

    /*@Test
    public void negativ5TimesNotCorrectPasswordLogin2() {
        Integer i;
        for (i = 1; i < 4; i++) {
            loginI.fillEmailField(email)
                    .fillPasswordField("passwordField")
                    .clickToLoginButton()
                    .waitForErrorPasswordMessage();
            //verufication
            assertTrue("No Error PasswordMessage ", loginI.passwordNotCorrect());
            assertTrue("No login Buttom", loginI.isOnLoginPage());
        }
        loginI.fillEmailField(email)
                .fillPasswordField("passwordField")
                .clickToLoginButton();
        loginI.waitForWarningLoginMessage();
        assertTrue("No Warning LoginMessage", loginI.checkWarningLoginMessage());
    }

*/


    @Test
    public void signUp(){
        Log.info("Go to SingUp Page");
        loginI.clickToSignUpButton()
                .waitForcontinueButtonOnSignUp();
        //verufication
         assertTrue("SignUp Page Title desappear",loginI.checkPageSignUpOpen());
         assertTrue("No Continue Buttom",loginI.isOnSingUpPage());

    }
    @Test
    public void forgotPassword(){
        Log.info("Go to forgot Password");
        loginI.clickToForgotPasswordButton()
                .waitForResetPasswordButtom();
        //verufication
        assertTrue("No ResetPassord Buttom", loginI.isOnResetPasswordPage());
        assertTrue("Not on resetPassword Page",loginI.checkPageResetPassword());

    }

    // test of clicking on Registration link are written in another class

   @AfterClass(alwaysRun = true)
   public void tearDown() {
        this.driver.quit();
    }
}



