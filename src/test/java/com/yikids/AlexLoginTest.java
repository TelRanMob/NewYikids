package com.yikids;

/*
 * Created by Alexandr on 03.04.2016.
 */

import com.yikids.pages.AlexLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AlexLoginTest {

    public AlexLoginPage alexloginpage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {

        driver = new FirefoxDriver();
        alexloginpage = PageFactory.initElements(driver, AlexLoginPage.class);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        alexloginpage.OpenLoginPage();
    }


    @Test
    public void FillLoginFields() {

        alexloginpage
                .fillEmailField("TestEmail@mail.com")
                .fillPasswordField("TestPassword")
                .clickLoginButton();

        assertTrue(alexloginpage.checkforEmailErrorText(),
                "Please sign up because your email does not exist in our system.");
        assertTrue(alexloginpage.checkforStillOnLoginPage());

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }

}
