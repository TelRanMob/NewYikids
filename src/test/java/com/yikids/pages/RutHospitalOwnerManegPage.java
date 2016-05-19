package com.yikids.pages;

import com.sun.org.apache.xpath.internal.operations.String;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by rutga on 12.04.2016.
 */
public class RutHospitalOwnerManegPage extends Page{
    //buttons
    @FindBy(xpath = "//*[@class='nav']/li[4]/a")
    WebElement hospitalButton;

    @FindBy(xpath = "//*[@class='nav']/li[1]/a")
    WebElement overViewButton;

    @FindBy(xpath = "//*[contains(text(),'Add Hospital')]")
    WebElement addHospitalButton;

    @FindBy(xpath = "//*[contains(text(),'Hospital Overview')]")
    WebElement hospitalOverviewButton;

    @FindBy(xpath = "//*[contains(text(),'Hospital Owner Management')]")
    WebElement hospitalOwnerManagementButton;

    public RutHospitalOwnerManegPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/admin/overview";
        PageFactory.initElements(driver, this);
    }
    public RutHospitalOwnerManegPage openLoginPage() {
        //Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }
    public RutHospitalOwnerManegPage openMenu() {
        moveMouseOverElement(hospitalButton);
        return this;
    }
    //генерация локаторов чекбоксов разных строк
    public void  checkCheckboxes(int check){
        int rowNumber;
        for(rowNumber = 0; rowNumber <= check; rowNumber++) {
            java.lang.String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
            WebElement box = driver.findElement(By.xpath(locator));
            box.click();
        }
    }
//Chekkong only checkboxes of rows with selected status
    //Todo Create method
    public void  checkNotAllCheckboxes(int check, String status){
        int rowNumber = 0;
        java.lang.String locatorStatus = "//*[@id='row" + rowNumber + "']/td[9]";
        WebElement statusCell = driver.findElement(By.xpath(locatorStatus));
        java.lang.String statusText = statusCell.getText();
//        for(rowNumber = 0; rowNumber <= check; rowNumber++) {
//            java.lang.String locator = "//*[@id='row" + rowNumber + "']/td[1]/input";
//            WebElement box = driver.findElement(By.xpath(locator));
//            box.click();
//        }
    }
}
