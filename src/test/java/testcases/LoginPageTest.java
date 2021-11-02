package testcases;

import common.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SettingsPage;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    SettingsPage settingsPage;

    @BeforeClass
    public void beforeMethod() {
        InitialBrowser();
        homePage = new HomePage(driver);
        loginPage = homePage.clickOnLoginButton();
    }

    @Test
    public void verifyLoginByGithubAccount() {
        loginPage.inputLoginInfo();
        loginPage.clickOnSigninButton();
        loginPage.waitForNavigationCompleted();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("The url did not match", "https://my-learning.w3schools.com/", currentUrl);
    }

    @Test
    public void verifyRelatedInfo() {
        settingsPage = loginPage.navigateToSettingPage();
        String[] attributes = settingsPage.getRelatedInfo();
        assertEquals("The First Name did not match", getObjectRepos("firstName"), attributes[0]);
        assertEquals("The Last Name did not match", getObjectRepos("lastName"), attributes[1]);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
