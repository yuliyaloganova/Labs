package ru.ssau.yuliyaloganova.labs.functions;

public class CompositeFunction implements MathFunction {
    private final MathFunction fFunc;//первая переменная типа MathFunction
    private final MathFunction sFunc;//вторая переменная типа MathFunction

    //конструктор, принимающий арргументы типа MathFunction и инициализирующий поля класса
    public CompositeFunction(MathFunction fFunc, MathFunction sFunc) {
        this.fFunc=fFunc;
        this.sFunc=sFunc;
    }

    @Override
    public double apply(double x) { //реализация метода apply
        double medResult = fFunc.apply(x); //применяем первую функцию к пременной х
        return sFunc.apply(medResult); //потом вторую к результату первой
    }
}
