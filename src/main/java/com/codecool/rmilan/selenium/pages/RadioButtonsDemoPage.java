package com.codecool.rmilan.selenium.pages;

import com.codecool.rmilan.selenium.keywords.KeywordContainer;
import com.codecool.rmilan.selenium.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class RadioButtonsDemoPage extends KeywordContainer {

    @FindBy(xpath = "//input[@name='gender']")
    List<WebElement> genderGroup;
    @FindBy(xpath = "//input[@name='ageGroup']")
    List<WebElement> ageGroup;
    @FindBy(xpath = "//button[text()='Get values']")
    WebElement radioButtonValues;
    @FindBy(xpath = "//p[@class='groupradiobutton']")
    WebElement selectedValues;

    public RadioButtonsDemoPage(WebDriver driver) {
        super(driver);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, Constants.TIMEOUT);
        PageFactory.initElements(factory, this);
    }

    public void selectRadioButtonPairs(String value1, String value2) {
        navigateTo(Constants.BASE_URL + "/basic-radiobutton-demo.html");
        clickOneFromMUltipleRadioButtons(genderGroup, value1);
        clickOneFromMUltipleRadioButtons(ageGroup, value2);
        clickToElement(radioButtonValues);
    }

    public String getRadioButtonPairValues() {
        return getElementInnerText(selectedValues).replace("\n", " ").replace("\r", " ");
    }
}
