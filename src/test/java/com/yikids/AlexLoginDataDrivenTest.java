package com.yikids;

/*
 * Created by Alexandr on 21.04.2016.
 */

import com.yikids.pages.AlexLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;

public class AlexLoginDataDrivenTest {

    public AlexLoginPage alexloginpage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        alexloginpage = PageFactory.initElements(driver, AlexLoginPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetup() {
        alexloginpage.OpenLoginPage();
    }

    /* Tests */

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loadInvalidLoginFromFile")
    public void loginNeganiveTest(String login, String pass) {
        alexloginpage.fillEmailField(login)
                .fillPasswordField(pass)
                .clickLoginButton();

        assertTrue(alexloginpage.checkforForgotPasswordEmailLabel(), "Negative login failed");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
