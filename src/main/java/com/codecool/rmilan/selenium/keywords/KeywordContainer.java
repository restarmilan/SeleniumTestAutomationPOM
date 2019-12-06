package com.codecool.rmilan.selenium.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    public boolean elementIsDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public String getElementInnerText(WebElement element) {
        return element.getText();
    }

    public void clickOnMultipleCheckbox(List<WebElement> elements, List<String> inputs, String value) {
        for (int i = 0; i < inputs.size(); i++) {
            if (inputs.get(i).equals(value)) {
                elements.get(i).click();
            }
        }
    }

    public String getElementAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public void selectOptionFromDropdown(WebElement element, String option) {
        Select daySelect = new Select(element);
        daySelect.selectByValue(option);
    }
}
