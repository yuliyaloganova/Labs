package ru.ssau.yuliyaloganova.labs.functions;

import ru.ssau.yuliyaloganova.labs.ui.Functions;

@Functions(name = "Нулевая функция y=0", priority = 3)

//Класс ZeroFunction устанавливает константу равной 0, UnitFunction - 1
public class ZeroFunction extends ConstantFunction {
    public ZeroFunction() {
        super(0); //вызывает конструктор суперкласса со значением 0
    }
}
