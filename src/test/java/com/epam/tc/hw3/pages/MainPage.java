package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class MainPage {

    @FindBy(className = "benefit-icon")
    private WebElement Images;

    @FindBy(className = "benefit-txt")
    private WebElement TextUnderImages;

    @FindBy(id = "frame")
    public WebElement frame;

    @FindBy(id = "frame-button")
    public WebElement frameButton;

    @FindBy(xpath = "//*[@class='sidebar-menu left']/li")
    public WebElement leftMenu;

    WaitActions waitActions;

    private HeaderMenu headerMenu;

    @FindBy(xpath = "//*[@class='dropdown uui-profile-menu']/a")
    private WebElement loginDropdown;

    @FindBy(id = "name")
    private WebElement loginInput;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginSubmit;

    @FindBy(id = "user-name")
    private WebElement loginName;

    @FindBy(xpath = "//*[@class='uui-navigation nav navbar-nav m-l8']")
    private List<WebElement> itemsInHeader;

    @FindBy(xpath = "//a[contains(text(), 'To include good practices and ideas from successful EPAM project')]")
    private WebElement benefit1;

    @FindBy(xpath = "//a[contains(text(), 'To be flexible and customizable')]")
    private WebElement benefit2;
    @FindBy(xpath = "//a[contains(text(), 'To be multiplatform')]")
    private WebElement benefit3;
    @FindBy(xpath = "//a[contains(text(), 'Already have good base (about 20 internal and some external projects), wish to get more...')]")
    private WebElement benefit4;

    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    private WebElement leftMenu1;
    @FindBy(xpath = "//a[contains(text(), 'Contact form')]")
    private WebElement leftMenu2;
    @FindBy(xpath = "//a[contains(text(), 'Service')]")
    private WebElement leftMenu3;
    @FindBy(xpath = "//a[contains(text(), 'Metals & Colors')]")
    private WebElement leftMenu4;
    @FindBy(xpath = "//a[contains(text(), 'Elements packs')]")
    private WebElement leftMenu5;
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
    public String[] getTextUnderImage() {
        String[] TextUnderImage = new String[4];
        TextUnderImage[0] = benefit1.getText();
        TextUnderImage[1] = benefit2.getText();
        TextUnderImage[2] = benefit3.getText();
        TextUnderImage[3] = benefit4.getText();
        return TextUnderImage;
    }
    public boolean isTextUnderImagesDisplayed() {
        return TextUnderImages.isDisplayed();
    }

    public boolean isImagesDisplayed() {
        return Images.isDisplayed();
    }

    public String userLogged() {

        return loginName.getText();
    }
    public boolean isFrameDisplayed() {
        return frame.isDisplayed();
    }

    public boolean isLeftMenuDisplayed() {
        return leftMenu.isDisplayed();
    }

    public String[] getTextLeftMenu() {
        String[] TextLeftMenu = new String[5];
        TextLeftMenu[0] = leftMenu1.getText();
        TextLeftMenu[1] = leftMenu2.getText();
        TextLeftMenu[2] = leftMenu3.getText();
        TextLeftMenu[3] = leftMenu4.getText();
        TextLeftMenu[4] = leftMenu5.getText();
        return TextLeftMenu;
    }

    public List<WebElement> menuList() {
        return itemsInHeader;
    }

    public HeaderMenu headerMenu() {
        return headerMenu;
    }
}
