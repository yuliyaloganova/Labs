package ru.ssau.yuliyaloganova.labs.functions;

public class SumArcFunction implements MathFunction {

    @Override
    public double apply(double x){
        return (Math.asin(x)+Math.acos(x));
    }
}
