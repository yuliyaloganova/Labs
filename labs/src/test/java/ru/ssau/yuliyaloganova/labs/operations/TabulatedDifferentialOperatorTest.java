package ru.ssau.yuliyaloganova.labs.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ru.ssau.yuliyaloganova.labs.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.yuliyaloganova.labs.functions.ArrayTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;


class TabulatedDifferentialOperatorTest {
    double[] xValue = {1, 2, 3, 8};
    double[] yValue = {6, 7, 9, 15};

    @Test
    void testsetFactory() {
        LinkedListTabulatedFunctionFactory fact = new LinkedListTabulatedFunctionFactory();
        TabulatedDifferentialOperator operation = new TabulatedDifferentialOperator();
        operation.setFactory(fact);

        assertSame(operation.getFactory().getClass(), fact.getClass());

    }

    @Test
    void testderive() {
        LinkedListTabulatedFunctionFactory fact = new LinkedListTabulatedFunctionFactory();
        TabulatedDifferentialOperator operation = new TabulatedDifferentialOperator(fact);
        ArrayTabulatedFunction func = new ArrayTabulatedFunction(xValue, yValue);
        TabulatedFunction differential_func = operation.derive(func);
        assertEquals(1, differential_func.getY(0));
        assertEquals(2, differential_func.getY(1));
        assertEquals(1.2, differential_func.getY(2));
        assertEquals(1.2, differential_func.getY(3));
    }

    @Test
    void deriveSynchTest() {
        LinkedListTabulatedFunctionFactory fact = new LinkedListTabulatedFunctionFactory();
        TabulatedDifferentialOperator operation = new TabulatedDifferentialOperator(fact);
        ArrayTabulatedFunction func = new ArrayTabulatedFunction(xValue, yValue);
        TabulatedFunction difFunc = operation.deriveSynchronously(func);
        assertEquals(1, difFunc.getY(0));
        assertEquals(2, difFunc.getY(1));
        assertEquals(1.2, difFunc.getY(2));
        assertEquals(1.2, difFunc.getY(3));
    }


}