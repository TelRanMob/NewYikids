package com.yikids;

import com.yikids.pages.TaniaHospitalOwnerManagementPage;
import com.yikids.pages.TaniaLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Tania Pereminski on 4/13/2016.
 */
//public String email = "admin@erdocfinder.com";
//public String passwordField = "Test123";

public class TaniaHospitalOwnerManagementTest {

    public TaniaHospitalOwnerManagementPage taniaHospOwnerManagPage;
    public TaniaLoginPage tanialLoginPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = new FirefoxDriver();
        taniaHospOwnerManagPage = PageFactory.initElements(driver, TaniaHospitalOwnerManagementPage.class);
        tanialLoginPage = PageFactory.initElements(driver, TaniaLoginPage.class);
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
    @Test
    public void checkSelectedCheckBoxes(){
        int check=5;
        taniaHospOwnerManagPage.checkCheckboxes(check);
        assertTrue("Not All  Checkboxes are Checked",taniaHospOwnerManagPage.isCheckedCheckboxes(check));

    }

    @Test
    public void checkSelectedCheckBoxesAccordingToStatus(){
        int check=5;
        String status= "Owned";
        taniaHospOwnerManagPage.checkNotAllCheckboxes(check,status);

        assertTrue("Not All Checkboxes with Status are Checked",taniaHospOwnerManagPage.isCheckedNotAllCheckboxes(check,status));

    }

 /*   @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();  }*/



}
