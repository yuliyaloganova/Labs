package ru.ssau.yuliyaloganova.labs.functions.factory;

import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.MathFunction;

public interface TabulatedFunctionFactory {
    TabulatedFunction create(double[] xValues, double[] yValues) ;

    TabulatedFunction createWithSecondConstructor(MathFunction function, double xFrom, double xTo, int size);
}
