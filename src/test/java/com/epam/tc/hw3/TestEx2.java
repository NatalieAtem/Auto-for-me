package com.epam.tc.hw3;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class TestEx2 extends BaseTest {

    private static List<String> logs = List
            .of("Colors: value changed to Yellow",
                    "metal: value changed to Selen",
                    "Wind: condition changed to true",
                    "Water: condition changed to true");

    @Test
    public void verifyDifferentElementsPage() {

        assertTitle();
        assertLogin();
        navigateToDifferentElementsPage();
        assertCheckBox();
        assertRadioBox();
        assertDropDown();
        assertLogRow();
    }
    //1. Open test site by URL_HOME_PAGE
    //2. Assert Browser title

    public void assertTitle() {
        assertThat(driver.getTitle()).isEqualTo("Home Page");

    }

    //3. Perform login
    //4. Assert Username in the left-top side of screen that user is logged in

    public void assertLogin() {
        mainPage.login("Roman", "Jdi1234");
        String actualUserName = mainPage.userLogged();
        assertThat(actualUserName).isEqualTo("ROMAN IOVLEV");

    }

    //5. Open through the header menu Service -> Different Elements Page
    public void navigateToDifferentElementsPage() {
        headerMenu.clickServiceMenu().clickDifferentElements();
    }



    //6. Select checkboxes, Elements are checked

    public void assertCheckBox() {
        differentElementsPage.selectCheckBoxWater();
        assertThat(differentElementsPage.isCheckboxSelectedWater()).isTrue();
        differentElementsPage.selectCheckBoxWind();
        assertThat(differentElementsPage.isCheckboxSelectedWind()).isTrue();

    }


    //7. Select radio, Element is checked
    public void assertRadioBox() {
        differentElementsPage.selectRadioBox();
        assertThat(differentElementsPage.isRadioBoxSelected()).isTrue();

    }


    //8. Select in dropdown Yellow, Element is selected
    public void assertDropDown() {
        differentElementsPage.selectDropDownYellow();
        assertThat(differentElementsPage.isDropDownYellowSelected()).isTrue();
    }


    //9. Assert that for each checkbox there is an individual log row
    //and value is corresponded to the status of checkbox
    //9. Assert that for radio button there is a log row and value is corresponded to the status of radio button
    //9. Assert that for dropdown there is a log row and value is corresponded to the selected value.
    public void assertLogRow() {
        differentElementsPage.getLastLog();
        assertThat(differentElementsPage.getLastLog());

        differentElementsPage.getLastLogText();
        assertThat(differentElementsPage.getLastLogText());
    }
}