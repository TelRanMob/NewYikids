package com.yikids.util;

import com.yikids.pages.ElenaHospitalOwnerManagementPage;
import com.yikids.pages.ElenaLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ElenaHospitalOwnerManagementTest {

    public ElenaHospitalOwnerManagementPage elenaHOMtPage;
    public ElenaLoginPage mainPage;
    public WebDriver driver;
    //public String email = "admin@erdocfinder.com";
    //public String password = "Test123";

    @BeforeClass(alwaysRun = true)
    public void setup() {
       // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        mainPage = PageFactory.initElements(driver, ElenaLoginPage.class);
        mainPage.openLoginPage();
        mainPage.Login();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {

       // elenaHOMtPage.openAdminPage();
        driver.get("http://admin.yikids.com/admin/hospital_owner_management");
    }


        @Test
        public void LoginTest() {

          //  System.out.println("Text element ="+ elenaHOMtPage.gettext());}
elenaHOMtPage.CheckTextOfElementLogOut();}


   @AfterClass(alwaysRun = true)
   public void tearDown() {
        this.driver.quit();
    }
}



