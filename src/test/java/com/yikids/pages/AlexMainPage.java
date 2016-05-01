package com.yikids.pages;

/*
 * Created by Alexandr on 08.04.2016.
 */

import com.yikids.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/***
 * CLASS STARTS
 ***/

public class AlexMainPage extends Page {

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    /* Verify tags */

    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement logoutLink;

    @FindBy(xpath = "html/body/div[2]//div[1]/h4")
    WebElement PhysicianOverviewColumn;
    @FindBy(xpath = "html/body/div[2]//div[2]/h4")
    WebElement RecruiterOverviewColumn;
    @FindBy(xpath = "html/body/div[2]//div[3]/h4")
    WebElement RecruiterOverviewColumnTwo;

    /* Methods */

    // Constructor and OpenPage.
    public AlexMainPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/admin/overview";
        PageFactory.initElements(driver, this);
    }

    public AlexMainPage OpenMainPage() {
        driver.get(PAGE_URL);
        return this;
    }

    /* Go to... */

    // Overview.
    public AlexMainPage gotoOverview() {
        driver.get("http://admin.yikids.com/admin/overview");
        return this;
    }

    // Physician.
    public AlexMainPage gotoPhysicianOverview() {
        driver.get("http://admin.yikids.com/admin/physician-overview");
        return this;
    }

    public AlexMainPage gotoPhysicianProfileTracking() {
        driver.get("http://admin.yikids.com/admin/physician-profile-tracking");
        return this;
    }

    public AlexMainPage gotoFilesOnBox() {
        driver.get("http://admin.yikids.com/admin/boxfiles");
        return this;
    }

    public AlexMainPage gotoPhysicianReferral() {
        driver.get("http://admin.yikids.com/admin/physicianreferralsummary");
        return this;
    }

    public AlexMainPage gotoPlacements() {
        driver.get("http://admin.yikids.com/admin/placement_summary");
        return this;
    }

    // Recruiter.
    public AlexMainPage gotoRecruiter() {
        driver.get("http://admin.yikids.com/admin/recruiter-overview");
        return this;
    }

    // Hospital.
    public AlexMainPage gotoHospitalOverview() {
        driver.get("http://admin.yikids.com/admin/hospital-overview");
        return this;
    }

    public AlexMainPage gotoHospitalOwnerManagement() {
        driver.get("http://admin.yikids.com/admin/hospital_owner_management");
        return this;
    }

    public AlexMainPage gotoAddHospital() {
        driver.get("http://admin.yikids.com/hospital/add");
        return this;
    }

    public AlexMainPage gotoOrphanHospitalManagement() {
        driver.get("http://admin.yikids.com/admin/orphan_hospital_management");
        return this;
    }

    public AlexMainPage gotoHospitalReferral() {
        driver.get("http://admin.yikids.com/admin/hospreferralsummary");
        return this;
    }

    public AlexMainPage gotoPremiumAd() {
        driver.get("http://admin.yikids.com/admin/premium_ad");
        return this;
    }

    public AlexMainPage gotoCmtAppr() {
        driver.get("http://admin.yikids.com/admin/cmtappr");
        return this;
    }

    // Messages.
    public AlexMainPage gotoManageMandrillTemplates() {
        driver.get("http://admin.yikids.com/admin/manage-mandrill-templates");
        return this;
    }

    // Accounting.
    public AlexMainPage gotoAccMonthlyAllCustomers() {
        driver.get("http://admin.yikids.com/admin/accountingmonthlyallcustomers");
        return this;
    }

    public AlexMainPage gotoAccountingOverview() {
        driver.get("http://admin.yikids.com/admin/accountingoverviewpercustomer");
        return this;
    }

    public AlexMainPage gotoAccountingMonthly() {
        driver.get("http://admin.yikids.com/admin/accountingmonthlypercustomer");
        return this;
    }

    public AlexMainPage gotoAccOverviewAllCustomers() {
        driver.get("http://admin.yikids.com/admin/accountingoverviewallcustomers");
        return this;
    }

    // Web Tracking.
    public AlexMainPage gotoUserDump() {
        driver.get("http://admin.yikids.com/admin/user-dump");
        return this;
    }

    public AlexMainPage gotoUserLogTask() {
        driver.get("http://admin.yikids.com/admin/user-log-task");
        return this;
    }

    public AlexMainPage gotoUserActivity() {
        driver.get("http://admin.yikids.com/admin/user-activity");
        return this;
    }

    public AlexMainPage gotoPotentialCustomer() {
        driver.get("http://admin.yikids.com/admin/potential-customer");
        return this;
    }

    // Jobs.
    public AlexMainPage gotoRewrite() {
        driver.get("http://admin.yikids.com/rewrite");
        return this;
    }

    public AlexMainPage gotoJobFilter() {
        driver.get("http://admin.yikids.com/job/jobfilter");

        return this;
    }

     /* Checks */

    public boolean isOnMainPage() {
        waitforLogOutLink();
        return exists(logoutLink);
    }

    public void checkforOverviewPage() {
        verifyElementIsPresent(PhysicianOverviewColumn);
        verifyElementIsPresent(RecruiterOverviewColumn);
        verifyElementIsPresent(RecruiterOverviewColumnTwo);
    }

    // Waiting.

    public void waitforLogOutLink() {
        waitUntilIsLoaded(logoutLink);
    }

    /*** CLASS ENDS ***/
}
