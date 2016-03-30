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
 * Created by Irina Primak on 29-Mar-16.
 */
public class SignUpTestIrina {
    static String driverPath = "Z:\\Tel-RAN\\Drivers\\";
    public SignUPPageIrina signUPPageI;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        System.setProperty("webdriver.crome.driver", driverPath+"chromedriver.exe");
        driver = new ChromeDriver();
        //System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
        //driver = new InternetExplorerDriver();
        signUPPageI = PageFactory.initElements(driver, SignUPPageIrina.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        signUPPageI.openSignUpPage();
    }

    @Test
    public void fillFildes() {
        signUPPageI.fillSignUp();


        signUPPageI.clickElemToContinue();
    }




}
