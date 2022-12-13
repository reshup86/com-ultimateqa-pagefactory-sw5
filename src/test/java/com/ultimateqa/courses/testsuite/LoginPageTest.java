package com.ultimateqa.courses.testsuite;

import com.ultimateqa.courses.pages.HomePage;
import com.ultimateqa.courses.pages.LoginPage;
import com.ultimateqa.courses.testbase.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    public LoginPageTest() {
        PageFactory.initElements(driver, this);
    }
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnSignIn();
        String expectedTextMessage = "Welcome Back!";
        Assert.assertEquals(loginPage.getTextMessage(), expectedTextMessage, "Welcome Back Message is not Displayed");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyTheErrorMessage() {
        homePage.clickOnSignIn();
        loginPage.enterInvalidEmail("admin1234@example.com");
        loginPage.enterInvalidPassword("admin1234");
        loginPage.clickOnSignInButton();
        String expectedErrorMessage = "Invalid email or password.";
        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage, "Invalid credential text is not displayed");
    }
}
