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
    @Test
    public void testAsPoints() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {2.0, 4.0, 6.0};
        TabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);//создаем табулированную функцию

        Point[] expectedPoints = {//ожидаемый массив точек, каждая точка соответствует значениям `x` и `y` функции
                new Point(1.0, 2.0),
                new Point(2.0, 4.0),
                new Point(3.0, 6.0)
        };

        Point[] actualPoints = TabulatedFunctionOperationService.asPoints(function);//полученный массив точек

        assertArrayEquals(expectedPoints, actualPoints);
    }

    TabulatedFunctionFactory factory1 = new LinkedListTabulatedFunctionFactory();
    TabulatedFunctionOperationService operation1 = new TabulatedFunctionOperationService(factory1);
    TabulatedFunctionOperationService operation2 = new TabulatedFunctionOperationService();

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
}