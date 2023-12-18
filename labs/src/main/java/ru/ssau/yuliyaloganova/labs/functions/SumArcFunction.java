package ru.ssau.yuliyaloganova.labs.functions;
import ru.ssau.yuliyaloganova.labs.ui.Functions;

@Functions(name = "Сумма asin(x)+acos(x)", priority = 4)
public class SumArcFunction implements MathFunction {

    @Override
    public double apply(double x){
        return (Math.asin(x)+Math.acos(x));
    }
}
