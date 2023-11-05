package ru.ssau.yuliyaloganova.labs.operations;

import org.junit.jupiter.api.Assertions;
import ru.ssau.yuliyaloganova.labs.functions.ArrayTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.LinkedListTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.Point;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
import org.junit.jupiter.api.Test;
import ru.ssau.yuliyaloganova.labs.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.yuliyaloganova.labs.functions.factory.TabulatedFunctionFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
public class TabulatedFunctionOperationServiceTest {
    double[] xValue = {1, 1.5, 2, 2.5, 3};
    double[] yValue1 = {2, 3, 4, 5, 6};
    double[] yValue2 = {7, 9, 11, 13, 15};
    ArrayTabulatedFunction func1 = new ArrayTabulatedFunction(xValue, yValue1);
    ArrayTabulatedFunction func2 = new ArrayTabulatedFunction(xValue,yValue2);
    LinkedListTabulatedFunction func3 = new LinkedListTabulatedFunction(xValue, yValue1);
    LinkedListTabulatedFunction func4 = new LinkedListTabulatedFunction(xValue,yValue2);
    TabulatedFunctionOperationService tabulatedFunctionOperationService = new TabulatedFunctionOperationService();

    TabulatedFunctionFactory factory1 = new LinkedListTabulatedFunctionFactory();
    TabulatedFunctionOperationService operation1 = new TabulatedFunctionOperationService(factory1);
    TabulatedFunctionOperationService operation2 = new TabulatedFunctionOperationService();
    @Test
    public void testAsPoints() {
        Point[] array = TabulatedFunctionOperationService.asPoints(func1);

        int i = 0;
        for (Point point : array) {
            Assertions.assertEquals(point.x, xValue[i]);
            Assertions.assertEquals(point.y, yValue1[i]);
            ++i;
        }
    }
    @Test
    void plusTest() {

        TabulatedFunction result1 = operation1.plus(func1, func2);
        for (int i = 0; i < result1.getCount(); i++) {
            Assertions.assertEquals(yValue1[i] + yValue2[i], result1.getY(i));
        }

        TabulatedFunction result2 = operation2.plus(func3, func4);
        for (int i = 0; i < result2.getCount(); i++) {
            Assertions.assertEquals(yValue1[i] + yValue2[i], result2.getY(i));
        }

        TabulatedFunction result3 = operation2.plus(func1, func3);
        for (int i = 0; i < result3.getCount(); i++) {
            Assertions.assertEquals(yValue1[i] + yValue2[i], result3.getY(i));
        }
    }

    @Test
    void minusTest() {
        TabulatedFunction result1 = operation1.minus(func1, func2);
        for (int i = 0; i < result1.getCount(); i++) {
            Assertions.assertEquals(yValue1[i] - yValue2[i], result1.getY(i));
        }

        TabulatedFunction result2 = operation2.minus(func4, func3);
        for (int i = 0; i < result2.getCount(); i++) {
            Assertions.assertEquals(yValue1[i] - yValue2[i], result2.getY(i));
        }

        TabulatedFunction result3 = operation2.minus(func1, func3);
        for (int i = 0; i < result3.getCount(); i++) {
            Assertions.assertEquals(yValue1[i] - yValue2[i], result3.getY(i));
        }
    }
    @Test
    void testmultiply() {

        TabulatedFunction result1 = operation1.multiply(func1, func2);
        for (int i = 0; i < result1.getCount(); i++) {
            Assertions.assertEquals(yValue1[i] * yValue2[i], result1.getY(i));
        }

        TabulatedFunction result2 = operation2.multiply(func3, func4);
        for (int i = 0; i < result2.getCount(); i++) {
            Assertions.assertEquals(yValue1[i] * yValue2[i], result2.getY(i));
        }

        TabulatedFunction result3 = operation2.multiply(func1, func3);
        for (int i = 0; i < result3.getCount(); i++) {
            Assertions.assertEquals(yValue1[i] * yValue2[i], result3.getY(i));
        }
    }
    @Test
    void testdivide() {
        TabulatedFunction result1 = operation1.divide(func1, func2);
        for (int i = 0; i < result1.getCount(); i++) {
            Assertions.assertEquals(yValue1[i] / yValue2[i], result1.getY(i));
        }

        TabulatedFunction result2 = operation2.divide(func4, func3);
        for (int i = 0; i < result2.getCount(); i++) {
            Assertions.assertEquals(yValue1[i] / yValue2[i], result2.getY(i));
        }

        TabulatedFunction result3 = operation2.divide(func1, func3);
        for (int i = 0; i < result3.getCount(); i++) {
            Assertions.assertEquals(yValue1[i] /yValue2[i], result3.getY(i));
        }
    }
}