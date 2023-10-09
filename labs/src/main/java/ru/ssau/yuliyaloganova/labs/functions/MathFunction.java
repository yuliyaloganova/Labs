package ru.ssau.yuliyaloganova.labs.functions;

public interface MathFunction {
    double apply(double x);

    default CompositeFunction andThen(MathFunction afterFunction){
        return new CompositeFunction(afterFunction, this);
    }
}
