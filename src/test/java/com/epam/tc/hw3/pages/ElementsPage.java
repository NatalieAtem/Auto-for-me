package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsPage {

    @FindBy(xpath = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']")
    public WebElement checkBoxWater;

    @FindBy(xpath = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']")
    public WebElement checkBoxWind;

    @FindBy(xpath = "//label[text()[contains(., ' Silver')]]/*[@type='radio']")
    public WebElement radioButtonSilver;

    @FindBy(xpath = "//*[text()='Blue']")
    public WebElement dropdownBlue;

    @FindBy(css = ".panel-body-list.logs > li")
    public List<WebElement> logs;

    WaitActions waitActions;

    public ElementsPage(WebDriver driver1) {
        PageFactory.initElements(driver1, this);
        waitActions = new WaitActions(driver1);
    }
}
