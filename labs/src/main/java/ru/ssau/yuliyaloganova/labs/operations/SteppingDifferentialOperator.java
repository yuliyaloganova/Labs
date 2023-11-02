package ru.ssau.yuliyaloganova.labs.operations;

import ru.ssau.yuliyaloganova.labs.functions.MathFunction;

public abstract class SteppingDifferentialOperator implements DifferentialOperator <MathFunction> {
    protected double step;
    public SteppingDifferentialOperator(double step) {
        if (step <= 0 || Double.isInfinite(step) || Double.isNaN(step)) {
            throw new IllegalArgumentException("Invalid step value");
        }
        this.step = step;
    }
    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        if (step <= 0 || Double.isInfinite(step) || Double.isNaN(step)) {
            throw new IllegalArgumentException("Invalid step value");
        }
        this.step = step;
    }
}
