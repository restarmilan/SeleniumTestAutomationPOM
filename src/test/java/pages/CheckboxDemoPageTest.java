package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constants;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckboxDemoPageTest {

    private WebDriver driver;
    private CheckboxDemoPage check;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        check = new CheckboxDemoPage(driver);
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }

    @Test
    void checkIsSimpleCheckboxClicked() {
        check.simpleCheckBox();
        assertTrue(check.checkboxIsClicked());
    }

}