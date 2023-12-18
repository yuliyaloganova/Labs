package ru.ssau.yuliyaloganova.labs.functions;
import ru.ssau.yuliyaloganova.labs.ui.Functions;

@Functions(name = "Квадратичная функция y=x^2", priority = 1)
public class SqrFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return Math.pow(x, 2);
    }
}