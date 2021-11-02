package pages;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;

import static common.TestBase.getObjectRepos;

public class SettingsPage extends AbstractPage {
    WebDriver driver;

    private String firstName = getObjectRepos("firstNameTextBox");
    private String lastName = getObjectRepos("lastNameTextBox");

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String[] getRelatedInfo() {
        this.firstName = getAttribute(driver, firstName, "value");
        this.lastName = getAttribute(driver, lastName, "value");
        return new String[]{this.firstName, this.lastName};
    }
}
