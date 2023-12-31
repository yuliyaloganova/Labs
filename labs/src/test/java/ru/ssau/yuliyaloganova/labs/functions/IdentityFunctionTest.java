package ru.ssau.yuliyaloganova.labs.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentityFunctionTest {
    @Test
    public void testApply() {
        IdentityFunction f = new IdentityFunction();
        assertEquals(0.0, f.apply(0.0), 0.0);
        assertEquals(1.0, f.apply(1.0), 0.0);
        assertEquals(-1.0, f.apply(-1.0), 0.0);
    }

    @Test
    public void testToString() {
        IdentityFunction func = new IdentityFunction();
        String expected = "This is the IdentityFunction class";
        assertEquals(expected, func.toString());
    }

    @Test
    public void testEquals() {
        IdentityFunction func = new IdentityFunction();
        IdentityFunction func2 = new IdentityFunction();
        ConstantFunction func3 = new ConstantFunction(7);
        assertTrue(func.equals(func2));
        assertFalse(func.equals(func3));
    }

    @Test
    public void testHashCode() {
        IdentityFunction identityFunction1 = new IdentityFunction();
        IdentityFunction identityFunction2 = new IdentityFunction();

        // Проверяем, что хэш-коды равны
        assertEquals(identityFunction1.hashCode(), identityFunction2.hashCode());
    }

    @Test
    public void testClone() throws CloneNotSupportedException {
        IdentityFunction identityFunction1 = new IdentityFunction();

        // Создаем клон объекта
        IdentityFunction identityFunction2 = (IdentityFunction) identityFunction1.clone();

        // Проверяем, что клон и оригинальный объект не являются одним и тем же объектом
        assertNotSame(identityFunction1, identityFunction2);

        // Проверяем, что клон и оригинальный объект равны
        assertEquals(identityFunction1, identityFunction2);
    }
}