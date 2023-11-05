package ru.ssau.yuliyaloganova.labs.operations;

import ru.ssau.yuliyaloganova.labs.functions.MathFunction;
import ru.ssau.yuliyaloganova.labs.functions.SqrFunction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SteppingDifferentialOperatorTest {
    MathFunction sqrt = new SqrFunction();

    @Test
    void LeftSteppingDifferentialOperatorTest() {
        SteppingDifferentialOperator leftOperation = new LeftSteppingDifferentialOperator(5);
        MathFunction differentialSqrt = leftOperation.derive(sqrt);

        assertEquals(-3.0, differentialSqrt.apply(1), 0.6);
    }

    @Test
    void RightSteppingDifferentialOperatorTest() {
        SteppingDifferentialOperator rightOperation = new RightSteppingDifferentialOperator(5);
        MathFunction differentialSqrt = rightOperation.derive(sqrt);

        assertEquals(7.0, differentialSqrt.apply(1), 0.7);
    }

    @Test
    void MiddleSteppingDifferentialOperatorTest() {
        SteppingDifferentialOperator middleOperation = new MiddleSteppingDifferentialOperator(5);
        MathFunction differentialSqrt = middleOperation.derive(sqrt);

        assertEquals(2.0, differentialSqrt.apply(1), 0.6);

    }

}