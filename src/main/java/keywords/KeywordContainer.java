package keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeywordContainer {

    protected WebDriver driver;

    public KeywordContainer(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void clickToElement(WebElement element) {
        element.click();
    }

    public void setElementInput(WebElement element, String input) {
        element.sendKeys(input);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public boolean elementIsLocated(WebElement element) {
        return element.isDisplayed();
    }

    public String getElementInnerText(WebElement element) {
        return element.getText();
    }
}
