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

}