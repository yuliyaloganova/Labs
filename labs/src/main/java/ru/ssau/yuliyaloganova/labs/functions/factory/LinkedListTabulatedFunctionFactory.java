package ru.ssau.yuliyaloganova.labs.functions.factory;

import ru.ssau.yuliyaloganova.labs.functions.LinkedListTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory {
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }
}
