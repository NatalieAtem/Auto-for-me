package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderMenu {
    WaitActions waitActions;
    private final ServiceMenu serviceMenu;

    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    private WebElement homeMenu;

    @FindBy(xpath = "//a[contains(text(), 'Contact form')]")
    private WebElement contactFormMenu;

    @FindBy(xpath = "//*[@class='dropdown']/a")
    private WebElement serviceSubMenu;

    @FindBy(xpath = "//a[contains(text(), 'Metals & Colors')]")
    private WebElement metalsAndColoursMenu;

    public HeaderMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitActions = new WaitActions(driver);
        serviceMenu = new ServiceMenu(driver);
    }
    public String[] getHeaderItemNames() {
        String[] itemNames = new String[4];
        itemNames[0] = homeMenu.getText();
        itemNames[1] = contactFormMenu.getText();
        itemNames[2] = serviceSubMenu.getText();
        itemNames[3] = metalsAndColoursMenu.getText();
        return itemNames;
    }

    public boolean isHomeMenuDisplayed() {
        return homeMenu.isDisplayed();
    }

    public boolean isContactFormMenuDisplayed() {
        return contactFormMenu.isDisplayed();
    }

    public boolean isServiceSubMenuDisplayed() {
        return serviceSubMenu.isDisplayed();
    }

    public boolean isMetalsAndColoursMenu() {
        return metalsAndColoursMenu.isDisplayed();
    }

    public void clickHomeMenu() {
        homeMenu.click();
    }

    public void clickContactFormMenu() {
        contactFormMenu.click();
    }

    public ServiceMenu clickServiceMenu() {
        serviceSubMenu.click();
        return serviceMenu;
    }

    public void clickMetalsAndColoursMenu() {
        metalsAndColoursMenu.click();
    }
}