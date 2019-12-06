package com.codecool.rmilan.selenium.pages;

import com.codecool.rmilan.selenium.utils.Constants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectListDemoPageTest {
    private WebDriver driver;
    private SelectListDemoPage select;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        select = new SelectListDemoPage(driver);
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dayselect.csv", numLinesToSkip = 1)
    void checkSelectedDayFromASingleDropdown(String option, String expected) {
        select.selectADayFromDropdown(option);
        assertEquals(expected, select.getSelectedDay());
    }

}