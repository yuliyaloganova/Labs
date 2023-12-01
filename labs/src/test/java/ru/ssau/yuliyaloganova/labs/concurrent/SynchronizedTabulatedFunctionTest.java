package ru.ssau.yuliyaloganova.labs.concurrent;

import ru.ssau.yuliyaloganova.labs.functions.ArrayTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.Point;
import java.util.Iterator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import static org.junit.jupiter.api.Assertions.*;

class SynchronizedTabulatedFunctionTest {
    double[] xValue = {1, 3, 5, 7, 9};
    double[] yValue = {2, 4, 6, 8, 10};
    ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValue, yValue);
    SynchronizedTabulatedFunction testList = new SynchronizedTabulatedFunction(function);

    @Test
    void getCountTest() {
        assertEquals(5,testList.getCount());
        assertNotEquals(0, testList.getCount());
    }

    @Test
    void getXTest() {
        assertEquals(3,testList.getX(1));
        assertNotEquals(0, testList.getX(3));
    }

    @Test
    void getYTest() {
        assertEquals(4, testList.getY(1));
        assertNotEquals(0, testList.getY(2));
    }

    @Test
    void setYTest() {
        testList.setY(0, 7);
        assertEquals(7, testList.getY(0));
        assertNotEquals(0, testList.getY(0));
    }

    @Test
    void leftBoundTest() {
        assertEquals(1, testList.leftBound());
        assertNotEquals(0, testList.leftBound());
    }

    @Test
    void rightBoundTest() {
        assertEquals(9, testList.rightBound());
        assertNotEquals(0, testList.rightBound());
    }

    @Test
    void indexOfXTest() {
        assertEquals(1, testList.indexOfX(3));
        assertNotEquals(0, testList.indexOfX(3));
    }

    @Test
    void indexOfYTest() {
        assertEquals(1, testList.indexOfY(4));
        assertNotEquals(0, testList.indexOfY(4));
    }

    @Test
    void arrayTabulatedIteratorExceptionTest() {
        Iterator<Point> iterator = testList.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(xValue[i], point.x);
            assertEquals(yValue[i], point.y);
            ++i;
        }

    }

}