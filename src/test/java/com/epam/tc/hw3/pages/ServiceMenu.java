package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceMenu {
    @FindBy(xpath = "//a[contains(text(), 'Support')]")
    private WebElement support;

    @FindBy(xpath = "//a[contains(text(), 'Different elements')]")
    private WebElement differentElements;

    public ServiceMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickDifferentElements() {
        differentElements.click();
    }

    public void clickSupport() {
        support.click();
    }

    public void clickElements() {

    }
}
