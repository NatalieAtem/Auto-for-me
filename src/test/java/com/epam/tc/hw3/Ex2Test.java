package com.epam.tc.hw3;

import com.epam.tc.hw3.pages.ElementsPage;
import com.epam.tc.hw3.pages.MainPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.epam.tc.hw3.pages.MainPage.HOME_PAGE;
import static com.epam.tc.hw3.pages.MainPage.URL_HOME_PAGE;


public class Ex2Test extends AbstractTest {
    private static List<String> logs = List
            .of("Colors: value changed to Blue",
                    "metal: value changed to Silver",
                    "Wind: condition changed to true",
                    "Water: condition changed to true");

    public Ex2Test() throws IOException {
    }

    @Test
    public void exercise() {

        //1. Open test site by URL
        webDriver.get(URL_HOME_PAGE);
        MainPage mainPage = new MainPage(webDriver);

        //2. Assert Browser title "Home Page"
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(HOME_PAGE);

        //3. Perform login
        mainPage.login(user, password);

        //4. Assert Username is logged
        Assertions.assertThat(mainPage.userLogged()).isEqualTo(user);

        //5. Open through the header menu Service -> Different Elements Page
        mainPage.headerMenu()
                .clickServiceMenu()
                .clickElements();

        //6. Select checkboxes
        ElementsPage difElPage = new ElementsPage(webDriver);
        difElPage.checkBoxWater.click();
        difElPage.checkBoxWind.click();

        //7. Select radio
        difElPage.radioButtonSilver.click();

        //8. Select in dropdown
        difElPage.dropdownBlue.click();

        //9. Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value.
        Assertions.assertThat(difElPage.checkBoxWater.isSelected()).isTrue();
        Assertions.assertThat(difElPage.checkBoxWind.isSelected()).isTrue();
        Assertions.assertThat(difElPage.radioButtonSilver.isSelected()).isTrue();
        Assertions.assertThat(difElPage.dropdownBlue.isSelected()).isTrue();
        for (int i = 0; i < logs.size(); i++) {
            Assertions.assertThat(difElPage.logs.get(i).getText()).contains(logs.get(i));
        }
    }

}
