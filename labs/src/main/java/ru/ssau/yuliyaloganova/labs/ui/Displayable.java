package ru.ssau.yuliyaloganova.labs.ui;

import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;

public interface Displayable {
    void functionPresentation(TabulatedFunction function);

    void addPoint(double x, double y);

    void removePoint(double x);

    TabulatedFunction getFunc();

}