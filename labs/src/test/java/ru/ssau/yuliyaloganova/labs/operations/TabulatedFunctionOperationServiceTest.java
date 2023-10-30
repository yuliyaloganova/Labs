package ru.ssau.yuliyaloganova.labs.operations;

import static org.junit.jupiter.api.Assertions.*;
import ru.ssau.yuliyaloganova.labs.functions.ArrayTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.Point;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
import ru.ssau.yuliyaloganova.labs.operations.TabulatedFunctionOperationService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
class TabulatedFunctionOperationServiceTest {
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
}