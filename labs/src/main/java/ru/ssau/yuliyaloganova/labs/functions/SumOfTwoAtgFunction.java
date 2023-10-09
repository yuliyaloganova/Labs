package ru.ssau.yuliyaloganova.labs.functions;

public class SumOfTwoAtgFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return (Math.atan(x)+Math.atan(x));
    }
}
