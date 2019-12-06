package com.codecool.rmilan.selenium.pages;

import com.codecool.rmilan.selenium.keywords.KeywordContainer;
import com.codecool.rmilan.selenium.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BasePage extends KeywordContainer {

    @FindBy(xpath = "//*[(text()='All Examples')]")
    WebElement menuListTop;
    @FindBy(linkText = "Input Forms")
    WebElement inputForms;
    @FindBy(linkText = "Simple Form Demo")
    WebElement simpleFormDemoSelector;


    public BasePage(WebDriver driver) {
        super(driver);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, Constants.TIMEOUT);
        PageFactory.initElements(factory, this);
    }

    public void basePageNavigation() {
        navigateTo(Constants.BASE_URL);
        clickToElement(menuListTop);
        clickToElement(inputForms);
        clickToElement(simpleFormDemoSelector);
    }

    public String checkPageUrl() {
        return getPageUrl();
    }


}
