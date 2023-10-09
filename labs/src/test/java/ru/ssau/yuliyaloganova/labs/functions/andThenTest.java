package ru.ssau.yuliyaloganova.labs.functions;

import org.junit.Test;
import static org.junit.Assert.*;


public class andThenTest {
    private static final double delta = 1e-15;

    public void TestApply(){
        MathFunction f = x -> x * 3;
        MathFunction g = x -> x + 2;
        MathFunction h = x -> Math.pow(x, 4);

        MathFunction compFunc1 = f.andThen(g).andThen(h);
        assertEquals(7209, compFunc1.apply(7), delta);

        MathFunction compFunc2 = g.andThen(h).andThen(f);
        assertEquals(20738, compFunc2.apply(4), delta);

        MathFunction compFunc3 = h.andThen(f).andThen(g);
        assertEquals(20736, compFunc3.apply(2), delta);
    }

}