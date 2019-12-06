package com.codecool.rmilan.selenium.pages;

import com.codecool.rmilan.selenium.utils.Constants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioButtonsDemoPageTest {

    private WebDriver driver;
    private RadioButtonsDemoPage radio;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        radio = new RadioButtonsDemoPage(driver);
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/gender_age_radio_buttons.csv", numLinesToSkip = 1)
    void checkRadioButtonPairValues(String gender, String age, String expected) {
        radio.selectRadioButtonPairs(gender, age);
        assertEquals(expected, radio.getRadioButtonPairValues());
    }
}