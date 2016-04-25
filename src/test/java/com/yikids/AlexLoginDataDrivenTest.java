package com.yikids;

/*
 * Created by Alexandr on 21.04.2016.
 */

import com.yikids.pages.AlexLoginPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AlexLoginDataDrivenTest extends TestNgTestBase {

    public AlexLoginPage alexloginpage;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        alexloginpage = PageFactory.initElements(driver, AlexLoginPage.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetup() {
        driver.get("http://admin.yikids.com/");
    }

    @DataProvider(name="NegativeLogin")
    public Object[][] LoginDP(){
        return new Object[][]{
                {"admin@erdocfinder.com","Tst123","You are not a physician."},
                {"admin@erdocfinr.com","tt","Please sign up because your email does not exist in our system."}
        };
    }

    /* Tests */

    @Test(dataProvider = "NegativeLogin")
    public void loginNeganiveTest(String login, String pass, String message){
        alexloginpage.fillPasswordField(pass)
                .fillEmailField(login)
                .clickLoginButton();
        assertTrue(alexloginpage.isOnLoginPage());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loadInvalidLoginFromFile")
    public void loginNeganiveTest(String login, String pass) {
        alexloginpage.fillEmailField(login)
                .fillPasswordField(pass)
                .clickLoginButton();
        assertTrue(alexloginpage.isOnLoginPage());
    }

    //@AfterClass(alwaysRun = true)
    //public void tearDown() { driver.quit(); }

}
