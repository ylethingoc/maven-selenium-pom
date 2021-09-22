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
        loginPage = homePage.clickOnLoginLinkText();
    }

    @Test
    public void verifyLoginByGithubAccount() {
        loginPage.selectContinueWithGitHub();
        loginPage.inputLoginInfo();
        loginPage.clickOnSigninButton();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("The url did not match", "https://dev.to/?signin=true", currentUrl);
    }

    @Test
    public void verifyRelatedInfo() {
        settingsPage = loginPage.navigateToSettingPage();
        String[] attributes = settingsPage.getRelatedInfo();
        assertEquals("The Name did not match", getObjectRepos("loginUser"), attributes[0]);
        assertEquals("The Username did not match", getObjectRepos("loginUser"), attributes[1]);
        assertEquals("The Email did not match", getObjectRepos("loginEmail"), attributes[2]);
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
