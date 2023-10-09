package ru.ssau.yuliyaloganova.labs.functions;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConstantFunctionTest {
    private static final double delta = 1e-15;
    private final ConstantFunction constFunction = new ConstantFunction(9);
    private final ZeroFunction zeroFunction = new ZeroFunction();
    private final UnitFunction unitFunction = new UnitFunction();


    @Test
    public void TestApply(){
        assertEquals(9, constFunction.apply(0), delta);
        assertEquals(9, constFunction.apply(-9), delta);
        assertEquals(9, constFunction.apply(27), delta);
        assertEquals(0, zeroFunction.apply(-9), delta);
        assertEquals(1, unitFunction.apply(27), delta);
    }


}