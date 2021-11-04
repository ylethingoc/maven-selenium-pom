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
    private final String warningMessage = getObjectRepos("warningMessage");
    private final String errorMessage = getObjectRepos("errorMessage");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputIntoEmailTextBox(String email) {
        inputIntoTextBox(driver, emailTextBox, email);
    }

    public void inputIntoPasswordTextBox(String password) {
        inputIntoTextBox(driver, passwdTextBox, password);
    }

    public void clickOnSigninButton() {
        clickOnElement(driver, signinButton);
    }

    public void waitForNavigationCompleted() {
        elementToBeClickable(driver, logoutButton);
    }

    public boolean isWarningDisplayed() {
        return isDisplayed(driver, warningMessage);
    }

    public String getWarningMessage() {
        return getTextFromElement(driver, warningMessage);
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(driver, errorMessage);
    }
    public String getErrorMessage() {
        return getTextFromElement(driver, errorMessage);
    }

    public SettingsPage navigateToSettingPage() {
        clickOnElement(driver, settingsLinkText);
        return new SettingsPage(driver);
    }
}
