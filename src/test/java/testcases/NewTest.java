package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
    private WebDriver driver;

    @Test
    public void testEasy() {
        driver.get("https://developer.spotify.com/console/");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Spotify for Developers"));
    }

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}