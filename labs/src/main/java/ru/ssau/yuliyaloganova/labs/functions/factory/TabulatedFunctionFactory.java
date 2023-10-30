package ru.ssau.yuliyaloganova.labs.functions.factory;

import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;

public interface TabulatedFunctionFactory {
    TabulatedFunction create(double[] xValues, double[] yValues) ;
}
