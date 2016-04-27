package com.yikids;

/*
 * Created by Alexandr on 03.04.2016.
 */

import com.yikids.pages.AlexLoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/***
 * CLASS STARTS
 ***/

public class AlexLoginTest extends TestNgTestBase {

    public AlexLoginPage alexloginpage;
    public String adminLogin = "admin@erdocfinder.com";
    public String adminPassword = "Test123";

    @BeforeClass(alwaysRun = true)
    public void setup() {
        alexloginpage = PageFactory.initElements(driver, AlexLoginPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        driver.get("http://admin.yikids.com/");
    }

    /* Positive tests */

    @Test
    public void loginPositiveTest() {

        alexloginpage
                .fillEmailField(adminLogin)
                .fillPasswordField(adminPassword)
                .clickLoginButton();
        assertTrue("Login failed", alexloginpage.isOnMainPage());

    }

    @Test
    public void loginPositiveForgotPasswordTest() {
        alexloginpage
                .fillEmailField(adminLogin)
                .fillPasswordField("wrong")
                .clickLoginButton()
                .waitforPasswordWarningMessage();
        assertTrue("Wrong passwordField accepted", alexloginpage.isOnLoginPage());
        alexloginpage.clickForgotPasswordAfterPasswordWarning()
                .waitforResetButton();
        assertTrue("Forgot passwordField link after wrong passwordField didn't work",
                alexloginpage.checkforForgotPasswordEmailLabel());
        alexloginpage.OpenLoginPage();
        alexloginpage.clickForgotPasswordLink()
                .waitforResetButton();
        assertTrue("Forgot passwordField link on login page didn't work",
                alexloginpage.checkforForgotPasswordEmailLabel());
    }

    @Test
    public void loginPositiveSignUpLink() {
        alexloginpage.clickSignUpLink();
        assertTrue("Going to Sign Up page failed", alexloginpage.isOnSignUpPage());
    }

    /* Negative tests */

    @Test
    public void loginNegativeWrongLoginTest() {
        alexloginpage.fillEmailField("asdasd@youpmail.com")
                .fillPasswordField(adminPassword);
        assertTrue("Wrong login accepted", alexloginpage.isOnLoginPage());
    }

    @Test
    public void loginNegativeEmptyLoginTest() throws InterruptedException {
        alexloginpage.fillEmailField(" ")
                .fillPasswordField(adminPassword)
                .clickLoginButton();
        assertTrue("Empty login accepted", alexloginpage.isOnLoginPage());
    }

    @Test
    public void loginNegativeWrongPasswordTest() {
        alexloginpage.fillEmailField(adminLogin)
                .fillPasswordField("wrong")
                .clickLoginButton();
        assertTrue("Wrong passwordField accepted", alexloginpage.isOnLoginPage());
    }

    @Test
    public void loginNegativeEmptyPasswordTest() {
        alexloginpage.fillEmailField(adminLogin)
                .fillPasswordField("")
                .clickLoginButton();
        assertTrue("Empty passwordField accepted", alexloginpage.isOnLoginPage());
    }

    @Test
    public void loginNegativeEmptyFieldsTest() {
        alexloginpage.fillEmailField("")
                .fillPasswordField("")
                .clickLoginButton();
        assertTrue("Empty fields accepted", alexloginpage.isOnLoginPage());
    }

    /*** CLASS ENDS ***/

}
