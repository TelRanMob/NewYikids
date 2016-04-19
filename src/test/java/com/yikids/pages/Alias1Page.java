/*
All the code that follow is
Copyright (c) 2016, Iakov Volf. All Rights Reserved.
Not for reuse without permission.
*/

package com.yikids.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class Alias1Page extends Page {
    public final String pageLoadedText = "He lay on his armour-like back, and if he lifted his head a little he could see his brown belly, slightly domed and divided by arches into stiff sections";
    public final String pageUrl = "/recruiter/signup/username";
    public Map<String, String> data;
    public WebDriver driver;
    public int timeout = 15;

    @FindBy(css = "#footerNavigation1 ul.nav.navbar-nav li:nth-of-type(1) a")
    public WebElement aboutUs;

    @FindBy(id = "username")
    public WebElement aliasField;

    @FindBy(css = "#footerNavigation1 ul.nav.navbar-nav li:nth-of-type(2) a")

    public WebElement benefits;
    @FindBy(css = "#footerNavigation1 ul.nav.navbar-nav li:nth-of-type(5) a")

    public WebElement contactUs;
    @FindBy(id = "create-username")

    public WebElement continueButton;
    @FindBy(css = "#footerNavigation1 ul.nav.navbar-nav li:nth-of-type(4) a")

    public WebElement faq;

    @FindBy(id = "showPassword")
    public WebElement showPasswordCheckBox;
    @FindBy(name = "agree")
    public WebElement iAgreeCheckBox;

    @FindBy(css = "a.LogoutText")
    public WebElement logIn;
    @FindBy(css = "#footerNavigation2 ul.nav.navbar-nav li:nth-of-type(4) a")

    public WebElement partners;

    @FindBy(id = "passwordField")
    public WebElement passwordField;

    @FindBy(css = "#footerNavigation2 ul.nav.navbar-nav li:nth-of-type(3) a")
    public WebElement press;

    @FindBy(css = "#footerNavigation1 ul.nav.navbar-nav li:nth-of-type(3) a")

    public WebElement pricing;

    @FindBy(css = "#footerNavigation2 ul.nav.navbar-nav li:nth-of-type(2) a")

    public WebElement privacyPolicy;

    @FindBy(id = "password_confirmation")
    public WebElement retypePasswordField;

    @FindBy(id = "term")

    public WebElement termsAndConditions;

    @FindBy(css = "#footerNavigation2 ul.nav.navbar-nav li:nth-of-type(1) a")

    public WebElement yiMedicalInc2016;


    public Alias1Page(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup/username";
        PageFactory.initElements(driver, this);
    }

    public Alias1Page(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public Alias1Page(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on About Us Link.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page clickAboutUsLink() {
        aboutUs.click();
        return this;
    }

    /**
     * Click on Benefits Link.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page clickBenefitsLink() {
        benefits.click();
        return this;
    }

    /**
     * Click on Contact Us Link.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page clickContactUsLink() {
        contactUs.click();
        return this;
    }

    /**
     * Click on Continue Link.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page clickContinueLink() {
        continueButton.click();
        return this;
    }

    /**
     * Click on Faq Link.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page clickFaqLink() {
        faq.click();
        return this;
    }

    /**
     * Click on Log In Link.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page clickLogInLink() {
        logIn.click();
        return this;
    }

    /**
     * Click on Partners Link.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page clickPartnersLink() {
        partners.click();
        return this;
    }

    /**
     * Click on Press Link.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page clickPressLink() {
        press.click();
        return this;
    }

    /**
     * Click on Pricing Link.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page clickPricingLink() {
        pricing.click();
        return this;
    }

    /**
     * Click on Privacy Policy Link.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page clickPrivacyPolicyLink() {
        privacyPolicy.click();
        return this;
    }

    /**
     * Click on 2016 Yi Medical Inc. Link.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page clickYiMedicalIncLink2016() {
        yiMedicalInc2016.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page fillAlias(String aliasText, String passwordText, String retypePasswordText) {
        setAliasTextField(aliasText);
        setPasswordPasswordField(passwordText);
        setShowPasswordCheckboxField();
        setRetypePasswordPasswordField(retypePasswordText);
        setIAgreeCheckboxField();
        return this;
    }

    /**
     * Set default value to Alias Text field.
     *
     * @return the Alias1Page class instance.
     */


    /**
     * Set value to Alias Text field.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page setAliasTextField(String aliasValue) {
        setElementText(aliasField, aliasValue);
        return this;
    }

    /**
     * Set I Agree To The Erdocfinder Terms And Conditions Checkbox field.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page setShowPasswordCheckboxField() {
        if (!showPasswordCheckBox.isSelected()) {
            showPasswordCheckBox.click();
        }
        return this;
    }

    /**
     * Set I Agree To The Erdocfinder Terms And Conditions Checkbox field.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page setIAgreeCheckboxField() {
        if (!iAgreeCheckBox.isSelected()) {
            iAgreeCheckBox.click();
        }
        return this;
    }

    /**
     * Set default value to Password Password field.
     *
     * @return the Alias1Page class instance.
     */


    /**
     * Set value to Password Password field.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page setPasswordPasswordField(String passwordValue) {
        setElementText(passwordField, passwordValue);
        return this;
    }


    /**
     * Set value to Retype Password Password field.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page setRetypePasswordPasswordField(String retypePasswordValue) {
        setElementText(retypePasswordField, retypePasswordValue);
        return this;
    }


    /**
     * Set value to Terms And Conditions Textarea field.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page setTermsAndConditionsTextareaField(String termsAndConditionsValue) {
        termsAndConditions.sendKeys(termsAndConditionsValue);
        return this;
    }

    /**
     * Unset I Agree To The Erdocfinder Terms And Conditions Checkbox field.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page unsetIAgreeToTheErdocfinderTerms1CheckboxField() {
        if (showPasswordCheckBox.isSelected()) {
            showPasswordCheckBox.click();
        }
        return this;
    }

    /**
     * Unset I Agree To The Erdocfinder Terms And Conditions Checkbox field.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page unsetIAgreeToTheErdocfinderTerms2CheckboxField() {
        if (iAgreeCheckBox.isSelected()) {
            iAgreeCheckBox.click();
        }
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the Alias1Page class instance.
     */
    public Alias1Page verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
