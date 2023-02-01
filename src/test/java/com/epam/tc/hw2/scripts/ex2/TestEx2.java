package com.epam.tc.hw2.scripts.ex2;

import com.epam.tc.hw2.BaseTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class TestEx2 extends BaseTest {
    @Test
    public void verifyDifferentElementsPage() {

        assertTitle();
        assertLogin();
        navigateToDifferentElementsPage();
        assertCheckBox();
        assertRadioBox();
        assertDropDown();
        assertLogger();
    }
    //1. Open test site by URL_HOME_PAGE
    //2. Assert Browser title

    public void assertTitle() {
        SoftAssertions softTitle = new SoftAssertions();
        softTitle.assertThat(driver.getTitle()).isEqualTo("Home Page");
        softTitle.assertAll();
    }

    //3. Perform login
    //4. Assert Username in the left-top side of screen that user is logged in

    public void assertLogin() {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id(("login-button"))).click();
        By userName = By.id("user-name");
        WebElement userNameElement = driver.findElement(userName);
        assertThat(userNameElement.getText()).isEqualTo("ROMAN IOVLEV");

    }

    //5. Open through the header menu Service -> Different Elements Page

    public void navigateToDifferentElementsPage() {
        WebElement serviceElement = driver.findElement(By.partialLinkText("SERVICE"));
        serviceElement.click();
        WebElement menuItemDifferentElements = driver.findElement(By.partialLinkText("DIFFERENT ELEMENTS"));
        menuItemDifferentElements.click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(dr -> ((JavascriptExecutor) dr).executeScript("return document.readyState").equals("complete"));
        SoftAssertions softDifferentElements = new SoftAssertions();
        softDifferentElements.assertThat(driver.getTitle()).isEqualTo("Different Elements");
        softDifferentElements.assertAll();
    }

    //6. Select checkboxes, Elements are checked

    public void assertCheckBox() {
        By waterCheckBox = new By.ByXPath("//label[text()[contains(., ' Water')]]/*[@type='checkbox']");
        By windCheckBox = new By.ByXPath("//label[text()[contains(., ' Wind')]]/*[@type='checkbox']");
        WebElement waterCheckBoxElement = driver.findElement(waterCheckBox);
        WebElement windCheckBoxElement = driver.findElement(windCheckBox);
        waterCheckBoxElement.click();
        windCheckBoxElement.click();
        SoftAssertions softCheckBox = new SoftAssertions();
        softCheckBox.assertThat(waterCheckBoxElement.isSelected()).isTrue();
        softCheckBox.assertThat(windCheckBoxElement.isSelected()).isTrue();
        softCheckBox.assertAll();
    }

    //7. Select radio, Element is checked

    public void assertRadioBox() {
        By radioSelen = new By.ByXPath("//label[text()[contains(., ' Selen')]]/*[@type='radio']");
        WebElement radioSelenElement = driver.findElement(radioSelen);
        driver.findElement(radioSelen).click();
        SoftAssertions softRadio = new SoftAssertions();
        softRadio.assertThat(radioSelenElement.isSelected()).isTrue();
        softRadio.assertAll();
    }

    //8. Select in dropdown, Element is selected

    public void assertDropDown() {
        By dropDownColor = new By.ByXPath(".//*[@class='colors']//*[@class='uui-form-element']");
        driver.findElement(dropDownColor).click();
        Select dropDownColors = new Select(driver.findElement(dropDownColor));
        dropDownColors.selectByVisibleText("Yellow");
        SoftAssertions softDropDown = new SoftAssertions();
        softDropDown.assertThat(dropDownColors.getFirstSelectedOption().getText()).isEqualTo("Yellow");
        softDropDown.assertAll();
    }

    //9. Assert that for each checkbox there is an individual log row
    //and value is corresponded to the status of checkbox
    //9. Assert that for radio button there is a log row and value is corresponded to the status of radio button
    //9. Assert that for dropdown there is a log row and value is corresponded to the selected value.

    public void assertLogger() {
        String waterLogPath = "//*[contains(text(),'Water: condition changed to true')]";
        String windLogPath = "//*[contains(text(),'Wind: condition changed to true')]";
        String selenLogPath = "//*[contains(text(),'metal: value changed to  Selen')]";
        String yellowLogPath = "//*[contains(text(),'Colors: value changed to Yellow')]";
        WebElement waterLog = driver.findElement(new By.ByXPath(waterLogPath));
        WebElement windLog = driver.findElement(new By.ByXPath(windLogPath));
        WebElement selenLog = driver.findElement(new By.ByXPath(selenLogPath));
        WebElement yellowLog = driver.findElement(new By.ByXPath(yellowLogPath));
        SoftAssertions softLog = new SoftAssertions();
        softLog.assertThat(waterLog.isDisplayed()).isTrue();
        softLog.assertThat(windLog.isDisplayed()).isTrue();
        softLog.assertThat(selenLog.isDisplayed()).isTrue();
        softLog.assertThat(yellowLog.isDisplayed()).isTrue();
        softLog.assertAll();
    }
}
