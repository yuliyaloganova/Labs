package ru.ssau.yuliyaloganova.labs.functions;

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

//Класс ZeroFunction устанавливает константу равной 0, UnitFunction - 1
class ZeroFunction extends ConstantFunction {
    public ZeroFunction() {
        super(0); //вызывает конструктор суперкласса со значением 0
    }
}

class UnitFunction extends ConstantFunction {
    public UnitFunction() {
        super(1);//вызывает конструктор суперкласса со значением 1
    }
}