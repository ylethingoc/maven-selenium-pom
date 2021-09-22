package pages;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;

import static common.TestBase.getObjectRepos;

public class SettingsPage extends AbstractPage {
    WebDriver driver;

    private String name = getObjectRepos("nameTextBox");
    private String username = getObjectRepos("usernameTextBox");
    private String email = getObjectRepos("emailTextBox");

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String[] getRelatedInfo() {
        this.name = getAttribute(driver, name, "value");
        this.username = getAttribute(driver, username, "value");
        this.email = getAttribute(driver, email, "value");
        return new String[]{this.name, this.username, this.email};
    }
}
