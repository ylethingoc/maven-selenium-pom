package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    private JavascriptExecutor js;
    private WebElement element;
    private WebDriverWait explicitWait;
    private Actions action;

    public WebElement findElement(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public void clickOnElement(WebDriver driver, String locator) {
        element = findElement(driver, locator);
        element.click();
    }

    public void clickOnElementByJS(WebDriver driver, String locator) {
        js = (JavascriptExecutor) driver;
        element = findElement(driver, locator);
        js.executeScript("arguments[0].click();", element);
    }

    public void inputIntoTextBox(WebDriver driver, String locator, String value) {
        element = findElement(driver, locator);
        element.sendKeys(value);
    }

    public void elementToBeClickable(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Constants.WAIT_TIME_20_SEC);
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void hover(WebDriver driver, String locator) {
        action = new Actions(driver);
        element = findElement(driver, locator);
        action.moveToElement(element).perform();
    }

    public String getAttribute(WebDriver driver, String locator, String attribute) {
        element = findElement(driver, locator);
        return element.getAttribute(attribute);
    }
}
