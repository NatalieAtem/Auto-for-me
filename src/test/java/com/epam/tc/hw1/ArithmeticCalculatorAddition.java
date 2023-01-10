package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArithmeticCalculatorAddition extends ArithmeticOperationsTesting {

    // сложение

    @DataProvider(name = "data-provider-for-addition")
    public Object[][] dataSetForAddition() {
        return new Object[][]{{1, 2, 3}, {-1, -2, 0}, {1, 1, -2}, {0, 0, 0}};
    }

    @Test(dataProvider = "data-provider-for-addition", groups = {"subAdd"})
    public void sumTest(long a, long b, long expectedAddition) {
        long actualAddition = calculator.sum(a, b);
        assertThat(actualAddition).isEqualTo(expectedAddition);
    }
}