package ru.ssau.yuliyaloganova.labs.functions;
import ru.ssau.yuliyaloganova.labs.ui.Functions;

@Functions(name = "Единичная функция y=1", priority = 0)

public class UnitFunction extends ConstantFunction {
    public UnitFunction() {
        super(1);//вызывает конструктор суперкласса со значением 1
    }
}
