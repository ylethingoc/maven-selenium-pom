package pages;

import common.AbstractPage;
import common.Constants;
import org.openqa.selenium.WebDriver;


public class LoginPage extends AbstractPage {
    WebDriver driver;
    private final String githubButton = "//button[contains(text(), 'Github')]";
    private final String userTextBox = "//input[@autocomplete='username']";
    private final String passwdTextBox = "//button[@type='password']";
    private final String signinButton = "//input[@value='Sign in']";
    private final String authorizedButton = "//button[@name='Authorize']";
    private final String avatarImage = "//img[@id='nav-profile-image']";
    private final String settingsLinkText = "/a[@href='/settings'";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectContinueWithGithub() {
        clickOnElement(driver, githubButton);
    }

    public void inputLoginInfo() {
        inputIntoTextBox(driver, userTextBox, Constants.USERNAME);
        inputIntoTextBox(driver, passwdTextBox, Constants.PASSWORD);
    }

    public void clickOnSigninButton() {
        clickOnElement(driver, signinButton);
    }

    public void clickOnAuthorizeButton() {
        clickOnElement(driver, authorizedButton);
    }

    public String verifyLogginSuccess() {
        return getCurrentUrl(driver);
        // https://dev.to/?signin=true
    }

    public SettingsPage navigateToSettingPage() {
        hover(driver, avatarImage);
        clickOnElement(driver, settingsLinkText);
        return new SettingsPage(driver);
    }
}
