package pages;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;

import static common.TestBase.getObjectRepos;

public class HomePage extends AbstractPage {
    private final String loginButton = getObjectRepos("loginButton");
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void gotoW3SchoolHomePage() {
        openUrl(driver, getObjectRepos("url"));
    }

    public LoginPage clickOnLoginButton() {
        clickOnElement(driver, loginButton);
        return new LoginPage(driver);
    }
}
