package pages;

import keywords.KeywordContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.Constants;

public class SimpleFormDemoPage extends KeywordContainer {

    @FindBy(xpath = "//input[@id='user-message']")
    WebElement userInput;
    @FindBy(xpath = "//button[text()='Show Message']")
    WebElement button;
    @FindBy(xpath = "//span[@id='display']")
    WebElement showUserInput;
    @FindBy(xpath = "//input[@id='sum1']")
    WebElement value1;
    @FindBy(xpath = "//input[@id='sum2']")
    WebElement value2;
    @FindBy(xpath = "//button[text()='Get Total']")
    WebElement getTotalButton;
    @FindBy(xpath = "//span[@id='displayvalue']")
    WebElement addedValues;


    public SimpleFormDemoPage(WebDriver driver) {
        super(driver);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, Constants.TIMEOUT);
        PageFactory.initElements(factory, this);
    }

    public void singleInputField(String input) {
        navigateTo(Constants.BASE_URL + "/basic-first-form-demo.html");
        setElementInput(userInput, input);
        clickToElement(button);
    }

    public String getUserInputFromSingleInputField() {
        return getElementInnerText(showUserInput);
    }

    public void doubleInputField(String input1, String input2) {
        navigateTo(Constants.BASE_URL + "/basic-first-form-demo.html");
        setElementInput(value1, input1);
        setElementInput(value2, input2);
        clickToElement(getTotalButton);
    }

    public String getAddedValuesFromDoubleInputField() {
        return getElementInnerText(addedValues);
    }
}
