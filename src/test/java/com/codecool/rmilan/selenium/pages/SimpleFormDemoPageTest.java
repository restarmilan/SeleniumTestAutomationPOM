package com.codecool.rmilan.selenium.pages;

import com.codecool.rmilan.selenium.utils.Constants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    @ParameterizedTest
    @CsvFileSource(resources = "/double_input_fields_data.csv", numLinesToSkip = 1)
    void checkAddedUserInputs(String value1, String value2, String expected) {
        simple.doubleInputField(value1, value2);
        assertEquals(expected, simple.getAddedValuesFromDoubleInputField());
    }

}