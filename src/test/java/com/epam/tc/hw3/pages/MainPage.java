package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class MainPage {

    @FindBy(className = "benefit-icon")
    public List<WebElement> listOfImages;

    @FindBy(className = "benefit-txt")
    public List<WebElement> listOfTextUnderImages;

    @FindBy(id = "frame")
    public WebElement frame;

    @FindBy(id = "frame-button")
    public WebElement frameButton;

    @FindBy(xpath = "//*[@class='sidebar-menu left']/li")
    public List<WebElement> leftMenu;

    WaitActions waitActions;

    private HeaderMenu headerMenu;

    @FindBy(xpath = "//*[@class='dropdown uui-profile-menu']")
    private WebElement loginDropdown;

    @FindBy(id = "name")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginSubmit;

    @FindBy(id = "user-name")
    private WebElement loginName;

    @FindBy(xpath = "//ul[contains(@class,'uui-navigation nav ')]/li")
    private List<WebElement> itemsInHeader;

    public static  String ID_FRAME = "frame";
    public static String URL_HOME_PAGE = "https://jdi-testing.github.io/jdi-light/index.html";
    public static String HOME_PAGE = "Home Page";


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitActions = new WaitActions(driver);
        headerMenu = new HeaderMenu(driver);
    }

    public void login(String user, String password)  {
        loginDropdown.click();
        loginInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginSubmit.click();
    }

    public String userLogged() {

        return loginName.getText();
    }

    public List<WebElement> menuList() {
        return itemsInHeader;
    }

    public HeaderMenu headerMenu() {
        return headerMenu;
    }
}
