package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public abstract class Page {
    private WebDriver driver;
    private HeaderMenu header;
    private ServiceMenu serviceMenu;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.header = new HeaderMenu (driver);
        this.serviceMenu = new ServiceMenu (driver);
    }

    public HeaderMenu getHeader() {
        return header;
    }

    public ServiceMenu getServiceMenu() {
        return serviceMenu;
    }
}
