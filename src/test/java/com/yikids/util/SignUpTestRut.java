package com.yikids.util;

import com.yikids.pages.SignUPPage;
import com.yikids.pages.SignUPPageRut;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

/**
 * Created by rutga on 29.03.2016.
 */
public class SignUpTestRut {
    public SignUPPageRut signUPPageRut;
    public WebDriver driver;
    static String driverPath = "C:\\Telran\\browserDriver\\";

    @BeforeClass
    public void setup() {
//        driver = new FirefoxDriver();
//        System.setProperty("webdriver.ie.driver", driverPath + "chromedriver.exe");
//        driver = new ChromeDriver();

        System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        signUPPageRut = PageFactory.initElements(driver, SignUPPageRut.class);
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        signUPPageRut.openSignUpPage();
    }
    @Test
    public void fillSignUPFields(){
        signUPPageRut
                .fillFirstnameField("firstname")
                .fillLastNameField("lastname")
                .fillEmailField("email@yopmail.com")
                .fillZip1CodeField("111111")
                .fillZip2CodeField("222")
                .fillCompanyField("company")
                .clickContinueButton();
    }
    //@AfterClass(alwaysRun = true)
    public void tearDown(){
        this.driver.quit();
    }
}
