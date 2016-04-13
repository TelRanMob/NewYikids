package com.yikids.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class ElenaHospitalOwnerManagementPage extends Page {


    // battons
    @FindBy(xpath="//*[@id='hospital-rewrite']/div[1]/a[1]")
    WebElement ApproveButton;

    @FindBy(xpath="//*[@id='hospital-rewrite']/div[1]/a[2]")
    WebElement DeattachButton;

    // Action
    @FindBy(xpath ="//*[@id='row0']/td[1]/input")
    WebElement Checkbox;

    //Status
    @FindBy(xpath ="//*[@id='row0']/td[9]")
    WebElement Status;
    @FindBy(xpath ="//*[@id='row0']/td[9]")
    WebElement NotOwnedStatus;

    //constructor


    public ElenaHospitalOwnerManagementPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL ="http://admin.yikids.com/admin/hospital_owner_management";
        PageFactory.initElements(driver, this);
    }

    public ElenaHospitalOwnerManagementPage openAdminPage() {
        //Log.info("Opening SignUp page");
        driver.get(PAGE_URL);
        return this;
    }

    public void checkCheckbxes(int Chec) {
        int rowNumber;

        for (rowNumber = 0; rowNumber <= Chec; rowNumber++) {
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            box.click();
        }
    }

    //Checking only checkboxes of rows with selected status
    //Todo Create method
    public void checkNotAllCheckbxes(int Chec, String status) {
        int rowNumber = 0;
        String locatorStatus = "//*[@id='row" + rowNumber + "']/td[9]";
        WebElement statusCell = driver.findElement(By.xpath(locatorStatus));
        String statusText = statusCell.getText();
        for (rowNumber = 0; rowNumber <= Chec; rowNumber++) {
            String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            box.click();
        }
    }

    public String gettext() {
        return getTextElement(NotOwnedStatus);
    }

    public boolean CheckTextOfElementLogOut() {
        return verifyTextBoolean(DeattachButton, " Deattach");
    }
    public boolean CheckElementButton() {
        return verifyElementIsPresent(DeattachButton);
    }

    public void waitForFirstNameWarning() {
        try {
            waitUntilElementIsLoaded(DeattachButton);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkCheckbxesStatus(int Chec, String status ) {

        int rowNumber = 0;
        for (rowNumber = 0; rowNumber <= Chec; rowNumber++) {
            String locatorStatus = "//*[@id='row" + rowNumber + "']/td[9]";

            WebElement statusCell = driver.findElement(By.xpath(locatorStatus));
            String statusText = statusCell.getText();
            if (statusText.equals(status)) {

                String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
                WebElement box = driver.findElement(By.xpath(locator));
                box.click();
            }

        }
    }
    public void EnterButtonClick(){
        driver.findElement(By.id("")).sendKeys(Keys.ENTER);   }
}
