package com.yikids.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class TaniaAlias1Page extends Page {

    public final String pageLoadedText = "He lay on his armour-like back, and if he lifted his head a little he could see his brown belly, slightly domed and divided by arches into stiff sections";
    public final String pageUrl = "/recruiter/signup/username";
    public Map<String, String> data;
    public WebDriver driver;
    public int timeout = 15;

    @FindBy(id = "username")
    public WebElement aliasField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "showPassword")
    public WebElement showPasswordCheckBox;

    @FindBy(id="password_confirmation")
    public WebElement passwordConfirmation;

    @FindBy(id = "term")
    public WebElement termsAndConditions;

    @FindBy(name = "agree")
    public WebElement iAgreeCheckBox;


    @FindBy(id = "create-username")
    public WebElement continueButton;

    public TaniaAlias1Page(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup/username";
        PageFactory.initElements(driver, this);
    }

    public TaniaAlias1Page openTaniaAlias1Page() {
        //Log.info("Opening TaniaAlias1Page page");
        driver.get(PAGE_URL);
        return this;
    }



    /**
     * Fill every fields in the page.
     */

    public TaniaAlias1Page fillAlias(String aliasText, String passwordText, String retypePasswordText) {
        setAliasTextField(aliasText);
        setPasswordPasswordField(passwordText);
        setShowPasswordCheckboxField();
        setRetypePasswordPasswordField(retypePasswordText);
        setIAgreeCheckboxField();
        return this;
    }

    /**
     * Set default value to Alias Text field.
     */

    public TaniaAlias1Page setAliasTextField(String aliasValue) {
        setElementText(aliasField, aliasValue);
        return this;
    }

    /**
     * Set I Agree To The Erdocfinder Terms And Conditions Checkbox field.*/

    public TaniaAlias1Page setShowPasswordCheckboxField() {
        if (!showPasswordCheckBox.isSelected()) {
            showPasswordCheckBox.click();
        }
        return this;
    }

    /**
     * Set I Agree To The Erdocfinder Terms And Conditions Checkbox field.*/

    public TaniaAlias1Page setIAgreeCheckboxField() {
        if (!iAgreeCheckBox.isSelected()) {
            iAgreeCheckBox.click();
        }
        return this;
    }

    /**
     * Set value to Password Password field.*/

    public TaniaAlias1Page setPasswordPasswordField(String passwordValue) {
        setElementText(passwordField, passwordValue);
        return this;
    }


    /**
     * Set value to Retype Password Password field.*/

    public TaniaAlias1Page setRetypePasswordPasswordField(String retypePasswordValue) {
        setElementText(passwordConfirmation, retypePasswordValue);
        return this;
    }


    /**
     * Set value to Terms And Conditions Textarea field.*/

    public TaniaAlias1Page setTermsAndConditionsTextareaField(String termsAndConditionsValue) {
        termsAndConditions.sendKeys(termsAndConditionsValue);
        return this;
    }

    /**
     * Unset I Agree To The Erdocfinder Terms And Conditions Checkbox field.*/

    public TaniaAlias1Page unsetIAgreeToTheErdocfinderTerms1CheckboxField() {
        if (showPasswordCheckBox.isSelected()) {
            showPasswordCheckBox.click();
        }
        return this;
    }

    /**
     * Unset I Agree To The Erdocfinder Terms And Conditions Checkbox field.*/

    public TaniaAlias1Page unsetIAgreeToTheErdocfinderTerms2CheckboxField() {
        if (iAgreeCheckBox.isSelected()) {
            iAgreeCheckBox.click();
        }
        return this;
    }

    /**
     * Verify that the page loaded completely.*/

    public TaniaAlias1Page verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.*/

    public TaniaAlias1Page verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}


