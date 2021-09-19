package pages;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    WebDriver driver;
    private final String loginLinkText = "/a[@href='/enter'";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickOnLoginLinkText () {
        clickOnElement(driver, loginLinkText);
        return new LoginPage(driver);
    }
}
