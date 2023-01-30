package com.epam.tc.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.epam.tc.hw3.utils.Config.getUserNameFromProperties;
import static com.epam.tc.hw3.utils.Config.getUserPasswordFromProperties;

public class AbstractTest {

    public static WebDriver webDriver;
    static WebDriverWait webDriverWait;
    public static List<String> leftMenuItems = List
            .of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
    public static List<String> LIST_ITEMS_HEADER = List
            .of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    public String user = getUserNameFromProperties();
    public String password = getUserPasswordFromProperties();

    public AbstractTest() throws IOException {
    }

    @BeforeTest
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public static void browserDriverSetup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        webDriver.quit();
        webDriver = null;
    }
}
