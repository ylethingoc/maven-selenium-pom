package pages;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;

import static common.TestBase.getObjectRepos;

public class HomePage extends AbstractPage {
    private final String loginLinkText = getObjectRepos("loginLinkText");
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickOnLoginLinkText() {
        clickOnElement(driver, loginLinkText);
        return new LoginPage(driver);
    }
}
