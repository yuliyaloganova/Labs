package ru.ssau.yuliyaloganova.labs.operations;

import ru.ssau.yuliyaloganova.labs.functions.MathFunction;
public class MiddleSteppingDifferentialOperator extends SteppingDifferentialOperator {
    public MiddleSteppingDifferentialOperator(double step) {
        super(step);
    }

    @Override
    public MathFunction derive(MathFunction function) {
        return new MathFunction() {
            public double apply(double x) {
                return (function.apply(x + step) - function.apply(x - step)) / (2 * step);
            }
        };
    }
}
