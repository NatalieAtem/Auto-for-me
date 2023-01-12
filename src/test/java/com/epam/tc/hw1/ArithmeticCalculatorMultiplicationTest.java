package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArithmeticCalculatorMultiplicationTest extends BaseTest {

    @DataProvider(name = "data-provider-for-multiple")
    public Object[][] dataSetForSubtraction() {
        return new Object[][]{{1, 2, 2}, {-2, -1, 2}, {-1, -4, 4}, {1, 1, 1}};
    }

    @Test(dataProvider = "data-provider-for-multiple", groups = {"divMultiplication"})
    public void multipleTest(long a, long b, long expectedMultiple) {
        long actualMultiple = calculator.mult(a, b);
        assertThat(actualMultiple).isEqualTo(expectedMultiple);
    }

}

