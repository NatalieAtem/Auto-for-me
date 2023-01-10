package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

public class ArithmeticCalculatorSubtraction extends ArithmeticOperationsTesting {
    // вычитание

    @DataProvider(name = "data-provider-for-sub")
    public Object[][] dataSetForSubtraction() {
        return new Object[][][][]{{1, 2, -1}, {-2, -2, 2}, {-1, 0, -1}, {0, 0, 0}};
    }

    @Test(dataProvider = "data-provider-for-sub", groups = {"subAdd"})
    public void subTest(long a, long b, long expectedSub) {
        long actualSub = calculator.sub(a, b);
        assertThat(actualSub).isEqualTo(expectedSub);
    }
    }