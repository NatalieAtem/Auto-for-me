package com.epam.tc.hw1;

import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

public class ArithmeticCalculatorSubtraction extends ArithmeticOperationsTesting {
    // вычитание

    @DataProvider(name = "data-provider-for-sub")
    public Object[][] dataSetForSubtraction() {
        return new Object[][]{{1, 2, -1}, {-2, -2, 2}, {-1, 0, -1}, {0, 0, 0}};
    }

    @Test(dataProvider = "data-provider-for-sub", groups = {"subAdd"})
    public void subTest(long a, long b, long expectedSub) {
        long actualSub = calculator.sub(a, b);
        assertThat(actualSub).isEqualTo(expectedSub);
    }

    @Test
    public void binaryArithmeticOperationsTest() {
        Assertions.assertEquals(1, 2 - 1);
        Assertions.assertEquals(3, 5 - 2);
        Assertions.assertEquals(2, 4 - 2);
    }

    @Test
    public void unaryArithmeticOperationsTest() {
        Assertions.assertEquals(1, +1);
        Assertions.assertEquals(-2, -2);
    }

}