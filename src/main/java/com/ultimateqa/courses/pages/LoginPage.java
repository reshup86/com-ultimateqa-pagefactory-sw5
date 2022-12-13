package com.ultimateqa.courses.pages;

import com.ultimateqa.courses.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome Back!')]")
    WebElement textMessage;
    @CacheLookup
    @FindBy(id="user[email]")
    WebElement emailField;
    @CacheLookup
    @FindBy(id ="user[password]")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//body[1]/main[1]/div[1]/div[1]/article[1]/form[1]/div[5]/button[1]")
    WebElement signInButton;
    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),\"Invalid email or password.\")]")
    WebElement errorMessage;

    public String getTextMessage() {
        Reporter.log("Error Message is displayed");
        return getTextFromElement(textMessage);
    }

    public void enterInvalidEmail(String email) {
        Reporter.log("Enter email " + email + " to email field " + emailField.toString());
        sendTextToElement(emailField, email);
    }

    public void enterInvalidPassword(String password) {
        Reporter.log("Enter password to password field");
        sendTextToElement(passwordField, password);
    }

    public void clickOnSignInButton() {
        Reporter.log("Click on sign in button");
        clickOnElement(signInButton);
    }

    public String getErrorMessage() {
        Reporter.log("Error message display");
        return getTextFromElement(errorMessage);
    }
}
