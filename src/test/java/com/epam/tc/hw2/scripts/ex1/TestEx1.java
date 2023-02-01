package com.epam.tc.hw2.scripts.ex1;

import com.epam.tc.hw2.BaseTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestEx1 extends BaseTest {
    @Test
    public void verifyMainPage() {
        assertTitle();
        assertLogin();
        assertHeader();
        assertImages();
        assertTextUnderImage();
        assertIframe();
        assertSideMenu();
    }

    //1. Open test site by URL_HOME_PAGE
    //2. Assert Browser title

    public void assertTitle() {
        SoftAssertions softTitle = new SoftAssertions();
        softTitle.assertThat(driver.getTitle()).isEqualTo("Home Page");
        softTitle.assertAll();
    }

    //3. Perform login
    //4. Assert Username is logged


    public void assertLogin() {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id(("login-button"))).click();
        By userName = By.id("user-name");
        WebElement userNameElement = driver.findElement(userName);
        assertThat(userNameElement.getText()).isEqualTo("ROMAN IOVLEV");

    }

    //5. Assert that there are 4 items on the header section are displayed, and they have proper texts

    public void assertHeader() {
        String sideMenuPath = "ul.uui-navigation.nav.navbar-nav.m-l8 > li";
        List<WebElement> header = driver.findElements(By.cssSelector(sideMenuPath));
        int headerMenuItemsSize = header.size();
        SoftAssertions softHeaderSize = new SoftAssertions();
        softHeaderSize.assertThat(headerMenuItemsSize).isEqualTo(4);
        softHeaderSize.assertAll();
        WebElement homeElement = driver.findElement(By.partialLinkText("HOME"));
        WebElement contactFormElement = driver.findElement(By.partialLinkText("CONTACT FORM"));
        WebElement serviceElement = driver.findElement(By.partialLinkText("SERVICE"));
        WebElement metalsColorsElement = driver.findElement(By.partialLinkText("METALS & COLORS"));
        SoftAssertions softHeader = new SoftAssertions();
        softHeader.assertThat(homeElement.isDisplayed()).isTrue();
        softHeader.assertThat(contactFormElement.isDisplayed()).isTrue();
        softHeader.assertThat(serviceElement.isDisplayed()).isTrue();
        softHeader.assertThat(metalsColorsElement.isDisplayed()).isTrue();
        softHeader.assertAll();
    }


    //6. Assert that there are 4 images on the Index Page, and they are displayed

    public void assertImages() {
        List<WebElement> listOfTheImages = driver.findElements(By.className("benefit-icon"));
        int numberOfImages = listOfTheImages.size();
        SoftAssertions softNumberImages = new SoftAssertions();
        softNumberImages.assertThat(numberOfImages).isEqualTo(4);
        softNumberImages.assertAll();
        WebElement iconPractise = driver.findElement(By.cssSelector(".icon-practise"));
        WebElement iconCustom = driver.findElement(By.cssSelector(".icon-custom"));
        WebElement iconMulti = driver.findElement(By.cssSelector(".icon-multi"));
        WebElement iconBase = driver.findElement(By.cssSelector(".icon-base"));
        SoftAssertions softImages = new SoftAssertions();
        softImages.assertThat(iconPractise.isDisplayed()).isTrue();
        softImages.assertThat(iconCustom.isDisplayed()).isTrue();
        softImages.assertThat(iconMulti.isDisplayed()).isTrue();
        softImages.assertThat(iconBase.isDisplayed()).isTrue();
        softImages.assertAll();
    }

    //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text

    public void assertTextUnderImage() {
        List<String> expectedText = new ArrayList<>();
        expectedText.add("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project");
        expectedText.add("To be flexible and\n"
                + "customizable");
        expectedText.add("To be multiplatform");
        expectedText.add("Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…");
        List<String> actualText = new ArrayList<>();
        List<WebElement> listOfTheText = driver.findElements(By.className("benefit-txt"));
        for (WebElement i : listOfTheText) {
            actualText.add(i.getText());
        }
        SoftAssertions softText = new SoftAssertions();
        softText.assertThat(actualText).isEqualTo(expectedText);
        softText.assertThat(listOfTheText.size()).isEqualTo(4);
        softText.assertAll();
    }

    //8. Assert that there is the iframe with Frame Button exist
    //9. Switch to the iframe and check that there is Frame Button in the iframe
    //10. Switch to original window back

    public void assertIframe() {
        driver.switchTo().frame("frame");
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        assertThat(frameButton.isDisplayed()).isTrue();
        driver.switchTo().defaultContent();
    }

    //11. Assert that there are 5 items in theLeft Section are displayed, and they have proper text

    public void assertSideMenu() {
        List<String> expectedMenu = new ArrayList<>();
        expectedMenu.add("Home");
        expectedMenu.add("Contact form");
        expectedMenu.add("Service");
        expectedMenu.add("Metals & Colors");
        expectedMenu.add("Elements packs");
        List<String> actualMenu = new ArrayList<>();
        By sideMenu = new By.ByCssSelector("ul[class='sidebar-menu left']>li");
        List<WebElement> sideMenuItems = driver.findElements(sideMenu);
        for (WebElement i : sideMenuItems) {
            actualMenu.add(i.getText());
        }
        SoftAssertions softLeftMenu = new SoftAssertions();
        softLeftMenu.assertThat(actualMenu.size()).isEqualTo(5);
        softLeftMenu.assertThat(actualMenu).isEqualTo(expectedMenu);
        softLeftMenu.assertAll();
    }
}
