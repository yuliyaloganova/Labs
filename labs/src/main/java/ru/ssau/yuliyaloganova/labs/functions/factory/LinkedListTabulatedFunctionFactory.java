package ru.ssau.yuliyaloganova.labs.functions.factory;

import ru.ssau.yuliyaloganova.labs.functions.MathFunction;
import ru.ssau.yuliyaloganova.labs.functions.LinkedListTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory {
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }

    @Override
    public TabulatedFunction createWithSecondConstructor(MathFunction function, double xFrom, double xTo, int size) {

        return new LinkedListTabulatedFunction(function, xFrom, xTo, size);

    }
}
