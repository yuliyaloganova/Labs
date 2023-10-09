package ru.ssau.yuliyaloganova.labs.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompositeFunctionTest {
    @Test
    public void testCompositeFunction() {
        // Создаем сложные функции
        MathFunction f = new SumArcFunction();
        MathFunction g = new SumOfTwoAtgFunction();

        // Создаем сложную функцию h(x) = g(f(x))
        CompositeFunction h = new CompositeFunction(f,g);

        // Тестируем применение сложной функции
        assertEquals(2.0077, h.apply(1.0), 0.0001);
        // h(1)=2atan(asin(1)+acos(1))

    }

}