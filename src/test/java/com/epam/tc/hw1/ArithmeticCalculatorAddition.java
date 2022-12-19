package com.epam.tc.hw1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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
    @Test
    public void binaryArithmeticOperationsTest() {
        Assertions.assertEquals(2, 1 + 1);
        Assertions.assertEquals(3, 2 + 1);
        Assertions.assertEquals(5, 2 + 3);
    }

    @Test
    public void precedenceOrderTest() {
        Assertions.assertEquals(1, +1);
        Assertions.assertEquals(-2, -2);
    }
}
