package com.epam.tc.hw1;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArithmeticCalculatorMultiplication extends ArithmeticOperationsTesting {

    // умножение

        @DataProvider(name = "data-provider-for-multiple")
        public Object[][] dataSetForSubtraction() {
            return new Object[][]{{1, 2, 2}, {-2, -1, 0}, {-1, -4, 0}, {1, 1, 1}};
        }

        @Test(dataProvider = "data-provider-for-multiple", groups = {"divMultiplication"})
        public void multipleTest(long a, long b, long expectedMultiple) {
        long actualMultiple = calculator.mult(a, b);
    assertThat(actualMultiple).isEqualTo(expectedMultiple);
        }


    }

