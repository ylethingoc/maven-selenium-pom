package pages;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;

import static common.TestBase.getObjectRepos;

public class HomePage extends AbstractPage {
    WebDriver driver;

    private final String loginLinkText = getObjectRepos("loginLinkText");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickOnLoginLinkText() {
        clickOnElement(driver, loginLinkText);
        return new LoginPage(driver);
    }
}
