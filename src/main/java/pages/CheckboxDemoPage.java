package pages;

import keywords.KeywordContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.Constants;

import java.util.List;

public class CheckboxDemoPage extends KeywordContainer {

    @FindBy(xpath = "//input[@id='isAgeSelected']")
    WebElement singleCheckbox;
    @FindBy(xpath = "//div[@id='txtAge']")
    WebElement checkboxClicked;
    @FindBy(xpath = "//input[@class='cb1-element']")
    List<WebElement> checkBoxes;
    @FindBy(xpath = "//input[@id='check1']")
    WebElement checkboxButton;

    public CheckboxDemoPage(WebDriver driver) {
        super(driver);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, Constants.TIMEOUT);
        PageFactory.initElements(factory, this);
    }

    public void simpleCheckBox() {
        navigateTo(Constants.BASE_URL + "/basic-checkbox-demo.html");
        clickToElement(singleCheckbox);
    }

    public boolean checkboxIsClicked() {
        return elementIsDisplayed(checkboxClicked);
    }
}
