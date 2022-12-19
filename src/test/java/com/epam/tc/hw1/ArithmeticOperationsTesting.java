package com.epam.tc.hw1;

import net.sf.saxon.expr.Calculator;
import net.sf.saxon.expr.XPathContext;
import net.sf.saxon.trans.XPathException;
import net.sf.saxon.type.AtomicType;
import net.sf.saxon.value.AtomicValue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract class ArithmeticOperationsTesting {
    protected Calculator calculator;

    @BeforeMethod(groups = {"subAdd", "divMultiplication"})
    public void initializeCalculator() {
        calculator = new Calculator() {
            @Override
            public AtomicValue compute(AtomicValue atomicValue, AtomicValue atomicValue1, XPathContext xPathContext) throws XPathException {
                return null;
            }

            @Override
            public AtomicType getResultType(AtomicType atomicType, AtomicType atomicType1) {
                return null;
            }
        };
    }

    @AfterMethod(groups = {"subAdd", "divMultiplication"})
    public void clearCalculator() {
        calculator = null;
    }
}
