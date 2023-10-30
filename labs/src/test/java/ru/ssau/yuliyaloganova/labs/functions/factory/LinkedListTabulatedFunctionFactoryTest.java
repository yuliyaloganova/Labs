package ru.ssau.yuliyaloganova.labs.functions.factory;


import ru.ssau.yuliyaloganova.labs.functions.LinkedListTabulatedFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LinkedListTabulatedFunctionFactoryTest {
    double[] xValue = {1, 1.5, 2, 2.5, 3};
    double[] yValue = {2, 3, 4, 5, 6};
    LinkedListTabulatedFunction testList = new LinkedListTabulatedFunction(xValue, yValue);

    @Test
    void createTest() {
        LinkedListTabulatedFunctionFactory listFactory = new LinkedListTabulatedFunctionFactory();
        double[] xValueFactory = {1, 2, 3, 4};
        double[] yValueFactory = {5, 6, 7, 8};
        boolean flag = testList.getClass() == (listFactory.create(xValueFactory, yValueFactory)).getClass();
        assertTrue(flag);

    }

}