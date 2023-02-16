package com.epam.tc.hw3;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HeaderMenu;
import com.epam.tc.hw3.pages.MainPage;
import com.epam.tc.hw3.pages.ServiceMenu;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;
    protected HeaderMenu headerMenu;
    protected ServiceMenu serviceMenu;
    protected DifferentElementsPage differentElementsPage;
    public static WebDriver webDriver;
    static WebDriverWait webDriverWait;
    public static List<String> leftMenuItems = List
            .of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
    public static List<String> LIST_ITEMS_HEADER = List
            .of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    //1. Open web browser by URL
    @BeforeClass
    public void initWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        mainPage = new MainPage(driver);
        headerMenu = new HeaderMenu(driver);
        serviceMenu = new ServiceMenu(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
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