package ru.ssau.yuliyaloganova.labs.operations;

import ru.ssau.yuliyaloganova.labs.functions.MathFunction;

public interface DifferentialOperator <T extends MathFunction> {
    T derive(T function);
}
