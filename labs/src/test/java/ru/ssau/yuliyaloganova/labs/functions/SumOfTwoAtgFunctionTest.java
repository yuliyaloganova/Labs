package ru.ssau.yuliyaloganova.labs.functions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SumOfTwoAtgFunctionTest {
    @Test
    public void testApply() {
        // Создание объекта SumOfTwoAtgFunction
        SumOfTwoAtgFunction sumoftwoatgFunction = new SumOfTwoAtgFunction();

        // Проверка для различных входных параметров
        assertEquals(0.0, sumoftwoatgFunction.apply(0.0), 1e-10);  // atan(0)+atan(0)=0
        assertEquals(Math.PI / 2, sumoftwoatgFunction.apply(1.0), 1e-10);  // atan(1)+atan(1)=pi/2

    }

}