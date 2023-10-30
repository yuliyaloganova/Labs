package ru.ssau.yuliyaloganova.labs.functions.factory;

import ru.ssau.yuliyaloganova.labs.functions.ArrayTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory {
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new ArrayTabulatedFunction(xValues, yValues);
    }
}
