package ru.ssau.yuliyaloganova.labs.functions.factory;

import ru.ssau.yuliyaloganova.labs.functions.LinkedListTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.ArrayTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.MathFunction;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory {
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new ArrayTabulatedFunction(xValues, yValues);
    }

    @Override
    public TabulatedFunction createWithSecondConstructor(MathFunction function, double xFrom, double xTo, int size) {
        return new ArrayTabulatedFunction(function, xFrom, xTo, size);
    }

}
