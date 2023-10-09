package ru.ssau.yuliyaloganova.labs.functions;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class SumArcFunctionTest {

    private static final double delta = 1e-15;
    private final SumArcFunction sumFunction = new SumArcFunction();

    @Test
    public void TestApply() {
        assertEquals(Math.PI / 2, sumFunction.apply(0), delta);
        assertEquals(Math.PI / 2, sumFunction.apply(1), delta);
        assertEquals(Math.PI / 2, sumFunction.apply(-1), delta);

    }
}