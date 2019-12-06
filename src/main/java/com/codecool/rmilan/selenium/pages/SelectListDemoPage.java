package com.codecool.rmilan.selenium.pages;

import com.codecool.rmilan.selenium.keywords.KeywordContainer;
import com.codecool.rmilan.selenium.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SelectListDemoPage extends KeywordContainer {

    @FindBy(xpath = "//select[@id='select-demo']")
    WebElement dropdown;
    @FindBy(xpath = "//p[@class='selected-value']")
    WebElement selectedDay;

    public SelectListDemoPage(WebDriver driver) {
        super(driver);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, Constants.TIMEOUT);
        PageFactory.initElements(factory, this);
    }

    public void selectADayFromDropdown(String option) {
        navigateTo(Constants.BASE_URL + "/basic-select-dropdown-demo.html");
        selectOptionFromDropdown(dropdown, option);
    }

    public String getSelectedDay() {
        return getElementInnerText(selectedDay);
    }


}
