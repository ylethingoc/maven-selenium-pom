package testcases;

import common.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SettingsPage;

import static org.testng.AssertJUnit.assertEquals;

public class SettingsPageTest extends TestBase {
    LoginPage loginPage;
    SettingsPage settingsPage;

    @BeforeClass
    public void beforeMethod() {
        InitialBrowser();
        loginPage = new LoginPage(driver);
        settingsPage = loginPage.navigateToSettingPage();
    }

    @Test
    public void verifyRelatedInfo() {
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
