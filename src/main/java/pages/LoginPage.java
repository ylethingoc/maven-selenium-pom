package pages;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;

import static common.TestBase.getObjectRepos;


public class LoginPage extends AbstractPage {
    private final String githubButton = getObjectRepos("githubButton");
    private final String userTextBox = getObjectRepos("userTextBox");
    private final String passwdTextBox = getObjectRepos("passwdTextBox");
    private final String signinButton = getObjectRepos("signinButton");
    private final String avatarImage = getObjectRepos("avatarImage");
    private final String settingsLinkText = getObjectRepos("settingsLinkText");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectContinueWithGitHub() {
        clickOnElement(driver, githubButton);
    }

    public void inputLoginInfo() {
        inputIntoTextBox(driver, userTextBox, getObjectRepos("loginEmail"));
        inputIntoTextBox(driver, passwdTextBox, getObjectRepos("loginPassword"));
    }

    public void clickOnSigninButton() {
        clickOnElement(driver, signinButton);
    }

    public SettingsPage navigateToSettingPage() {
        hover(driver, avatarImage);
        clickOnElement(driver, settingsLinkText);
        return new SettingsPage(driver);
    }
}
