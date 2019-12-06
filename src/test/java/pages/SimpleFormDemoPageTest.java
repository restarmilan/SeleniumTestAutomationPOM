package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constants;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleFormDemoPageTest {

    private WebDriver driver;
    private SimpleFormDemoPage simple;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        simple = new SimpleFormDemoPage(driver);
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/simple_input_message.csv", numLinesToSkip = 1)
    void checkSimpleInputField(String input, String expected) {
        simple.singleInputField(input);
        assertEquals(expected, simple.getUserInputFromSingleInputField());
    }

}