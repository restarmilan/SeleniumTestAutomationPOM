package com.codecool.rmilan.selenium.pages;

import com.codecool.rmilan.selenium.utils.Constants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @ParameterizedTest
    @MethodSource("com.codecool.rmilan.selenium.utils.TestParams#provideInputsForCheckboxTest")
    void checkMultipleCheckboxButtonText(List<String> inputs, String expected) {
        check.multipleCheckBox(inputs);
        assertEquals(expected, check.getMultipleCheckBoxButtonText());
    }
}