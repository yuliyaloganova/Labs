package ru.ssau.yuliyaloganova.labs.functions;
import ru.ssau.yuliyaloganova.labs.ui.Functions;



//класс константных функций
public class ConstantFunction implements MathFunction {
    private final double constant; //приватное поле, которое хранит константу

    //конструктор
    public ConstantFunction(double constant) {
        this.constant = constant;
    }

    //возвращает значение constant
    @Override
    public double apply(double x) {
        return constant;
    }

    //геттер, возвращающий значение константы
    public double getConstant() {
        return constant;
    }
}

