package com.yikids.util;

import com.yikids.pages.TaniaHospitalOwnerManagementPage;
import com.yikids.pages.TaniaLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Tania on 4/13/2016.
 */
//public String email = "admin@erdocfinder.com";
//public String password = "Test123";

public class TaniaHospitalOwnerManagementTest {

    public TaniaHospitalOwnerManagementPage taniaHospOwnerManagPage;
    public TaniaLoginPage tanialLoginPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        taniaHospOwnerManagPage = PageFactory.initElements(driver, TaniaHospitalOwnerManagementPage.class);
        tanialLoginPage.openLoginPage();
        tanialLoginPage.fillLoginFieldsPozitive();

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {
        taniaHospOwnerManagPage.openAdminPage();
        driver.get("http://admin.yikids.com/admin/hospital_owner_management");
    }

    @Test
    public void HospitalOwnTest() {

        System.out.println("Text element ="+ taniaHospOwnerManagPage.gettext());
        taniaHospOwnerManagPage.checkTextOfElementLogOut();

    }


}
