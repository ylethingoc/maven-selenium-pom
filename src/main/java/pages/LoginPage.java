package pages;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;

import static common.TestBase.getObjectRepos;


public class LoginPage extends AbstractPage {
    private final String emailTextBox = getObjectRepos("emailTextBox");
    private final String passwdTextBox = getObjectRepos("passwdTextBox");
    private final String signinButton = getObjectRepos("signinButton");
    private final String settingsLinkText = getObjectRepos("settingsLinkText");
    private final String logoutButton = getObjectRepos("logoutButton");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputLoginInfo() {
        inputIntoTextBox(driver, emailTextBox, getObjectRepos("loginEmail"));
        inputIntoTextBox(driver, passwdTextBox, getObjectRepos("loginPassword"));
    }

    public void clickOnSigninButton() {
        clickOnElement(driver, signinButton);
    }

    public void waitForNavigationCompleted() {
        elementToBeClickable(driver, logoutButton);
    }

    public SettingsPage navigateToSettingPage() {
        clickOnElement(driver, settingsLinkText);
        return new SettingsPage(driver);
    }
}
