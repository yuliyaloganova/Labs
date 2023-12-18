package ru.ssau.yuliyaloganova.labs.functions;
import ru.ssau.yuliyaloganova.labs.ui.Functions;

@Functions(name = "Сумма atan(x)+atan(x))", priority = 2)
public class SumOfTwoAtgFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return (Math.atan(x)+Math.atan(x));
    }
}
