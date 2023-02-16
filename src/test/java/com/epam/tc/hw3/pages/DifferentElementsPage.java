package com.epam.tc.hw3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends Page {

    //Checkboxes
    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Water')]")
    private WebElement checkboxWater;

    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Wind')]")
    private WebElement checkboxWind;

    //RadioButtons
    @FindBy(className = "label-radio")
    private List<WebElement> checkRadioBox;

    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Selen')]")
    private WebElement radioBtnSelen;

    //DropDowns
    @FindBy(css = ".colors>select>option")
    private List<WebElement> dropDown;

    @FindBy(className = "colors")
    private WebElement dropDownColors;

    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement dropDownYellow;

    //Log
    @FindBy(css = ".logs :first-child")
    public WebElement lastLog;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public void selectCheckBoxWater() {
        checkboxWater.click();
    }

    public void selectCheckBoxWind() {
        checkboxWind.click();
    }

    public boolean isCheckboxSelectedWater() {
        WebElement input = checkboxWater.findElement(By.tagName("input"));
        return input.isSelected();

    }

    public boolean isCheckboxSelectedWind() {
        WebElement input = checkboxWind.findElement(By.tagName("input"));
        return input.isSelected();
    }

    public void selectRadioBox() {
        radioBtnSelen.click();
    }

    public boolean isRadioBoxSelected() {
        WebElement input = radioBtnSelen.findElement(By.tagName("input"));
        return input.isSelected();
    }

    public void selectDropDownYellow() {
        dropDownColors.click();
    }

    public boolean isDropDownYellowSelected() {
        WebElement input = dropDownColors.findElement(By.tagName("input"));
        return input.isSelected();
    }


    //Checkboxes
    public List<WebElement> getAllCheckboxes() {
        return checkboxes;
    }

    public WebElement getCheckboxWind() {
        return checkboxWind;
    }

    public WebElement getCheckboxWater() {
        return checkboxWater;
    }

    public void clickWebElement(WebElement element) {
        element.click();
    }

    //RadioButtons

    public WebElement getRadioBtnSelen() {
        return radioBtnSelen;
    }

    public WebElement getDropDownYellow() {
        return dropDownYellow;
    }

    //DropDowns

    public void chooseFromClosedDropdown(WebElement dropDownElement) {
        dropDownColors.click();
        dropDownElement.click();
    }
    //Logs

    public WebElement getLastLog() {
        return lastLog;
    }

    public String getLastLogText() {
        return lastLog.getText();
    }
}
