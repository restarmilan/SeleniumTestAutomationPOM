package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Constants;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasePageTest {

    private WebDriver driver;
    private BasePage basePage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        basePage = new BasePage(driver);
    }

    @AfterEach
    void cleanUp() {
        driver.quit();
    }

    @Test
    void checkBasePageNavigation() {
        basePage.basePageNavigation();
        assertEquals("https://www.seleniumeasy.com/test/basic-first-form-demo.html", basePage.checkPageUrl());
    }

}