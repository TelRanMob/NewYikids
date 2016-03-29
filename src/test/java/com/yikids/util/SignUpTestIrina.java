package com.yikids.util;

import com.yikids.pages.SignUPPage;
import com.yikids.pages.SignUPPageIrina;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by saeser on 29-Mar-16.
 */
public class SignUpTestIrina {
    static String driverPath = "Z:\\Tel-RAN\\Drivers\\";
    public SignUPPageIrina signUPPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
        System.setProperty("webdriver.cromDriver.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();
        signUPPage = PageFactory.initElements(driver, SignUPPageIrina.class);
            }
    @Test
    public void fillFildes() {
        signUPPage.fillSignUp();


        signUPPage.clickElemToContinue();
    }




}
