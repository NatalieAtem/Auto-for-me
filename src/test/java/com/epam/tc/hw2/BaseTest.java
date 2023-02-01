package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    protected WebDriver driver;

    //1. Open web browser by URL
    @BeforeClass
    public void initWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }


    //12. Close Browser
    //10. Close Browser
    @AfterClass
    public void releaseWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}