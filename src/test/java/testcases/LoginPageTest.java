package testcases;

import common.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    public void beforeMethod() {
        InitialBrowser();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void BeforeMethod() {
        homePage.gotoW3SchoolHomePage();
        loginPage = homePage.clickOnLoginButton();
    }

    @Test(enabled = true)
    public void loginWithEmptyEmailPassword() {
        loginPage.clickOnSigninButton();
        assertTrue(loginPage.isWarningDisplayed());
        String warningMessage = loginPage.getWarningMessage();
        assertEquals(warningMessage, "Please enter an email");
    }

    @Test(enabled = true)
    public void loginWithInvalidEmail() {
        loginPage.inputIntoEmailTextBox("invalid_email_format");
        loginPage.clickOnSigninButton();
        assertTrue(loginPage.isWarningDisplayed());
        String warningMessage = loginPage.getWarningMessage();
        assertEquals(warningMessage , "Looks like you forgot something");
    }

    @Test(enabled = true)
    public void loginWithInvalidPassword() {
        loginPage.inputIntoEmailTextBox(getObjectRepos("loginEmail"));
        loginPage.clickOnSigninButton();
        assertTrue(loginPage.isErrorDisplayed());
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "Make sure you type your email and password correctly. Both your password and email are case-sensitive.");
    }

    @Test(enabled = true)
    public void loginWithValidAccount() {
        loginPage.inputIntoEmailTextBox(getObjectRepos("loginEmail"));
        loginPage.inputIntoPasswordTextBox(getObjectRepos("loginPassword"));
        loginPage.clickOnSigninButton();
        loginPage.waitForNavigationCompleted();
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl,"https://my-learning.w3schools.com/");
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
