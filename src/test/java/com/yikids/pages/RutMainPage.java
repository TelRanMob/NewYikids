package com.yikids.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by rutga on 08.04.2016.
 */
public class RutMainPage extends Page{

    //buttons
    @FindBy(xpath = "//*[@class='nav']/li[4]/a")
    WebElement hospitalButton;

    @FindBy(xpath = "//*[contains(text(),'Add Hospital')]")
    WebElement addHospitalButton;

    //*[contains(text(),'Your password is not correct. Please try again.')]
    //div[@class='err'][contains(text),'Your password is not correct. Please try again.']
    public RutMainPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/admin/overview";
        PageFactory.initElements(driver, this);
    }
    public RutMainPage openLoginPage() {
        //Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }

    public RutMainPage clickHospitalButton() {
        //Log.info("Click signUp button");
        clickElement(hospitalButton);
        return this;
    }
    public RutMainPage clickAddHospitalButton() {
        //Log.info("Click signUp button");
        clickElement(addHospitalButton);
        return this;
    }

}
