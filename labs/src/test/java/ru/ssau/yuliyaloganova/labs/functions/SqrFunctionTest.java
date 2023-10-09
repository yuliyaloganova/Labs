package ru.ssau.yuliyaloganova.labs.functions;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class SqrFunctionTest {

    private static final double delta = 1e-15;
    private final SqrFunction sqrFunction = new SqrFunction();

    @Test
    public void TestApply() {
        assertEquals(0, sqrFunction.apply(0), delta);
        assertEquals(81, sqrFunction.apply(-9), delta);
        assertEquals(4, sqrFunction.apply(2), delta);
        assertEquals(16, sqrFunction.apply(-4), delta);
        assertEquals(225, sqrFunction.apply(15), delta);
    }
}