package ru.ssau.yuliyaloganova.labs.functions;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import ru.ssau.yuliyaloganova.labs.exceptions.ArrayIsNotSortedException;
import ru.ssau.yuliyaloganova.labs.exceptions.DifferentLengthOfArraysException;
import ru.ssau.yuliyaloganova.labs.exceptions.InterpolationException;

public class ArrayTabulatedFunctionTest {
    double[] xValues = {1.0, 2.0, 3.0};
    double[] yValues = {4.0, 5.0, 6.0};
    ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
    @Test
    public void testConstructorWithArrays() {

        Assert.assertEquals(3, function.getCount());
        Assert.assertEquals(1.0, function.getX(0), 0.0);
        Assert.assertEquals(4.0, function.getY(0), 0.0);
    }

    @Test
    public void testGetX() {
        ArrayTabulatedFunction function = createFunction();
        Assert.assertEquals(2.0, function.getX(1), 0.0);
    }

    @Test
    public void testGetY() {
        ArrayTabulatedFunction function = createFunction();
        Assert.assertEquals(5.0, function.getY(1), 0.0);
    }

    @Test
    public void testSetY() {
        ArrayTabulatedFunction function = createFunction();
        function.setY(1, 10.0);
        Assert.assertEquals(10.0, function.getY(1), 0.0);
    }

    @Test
    public void testIndexOfX() {
        ArrayTabulatedFunction function = createFunction();
        Assert.assertEquals(1, function.indexOfX(2.0));
    }

    @Test
    public void testIndexOfY() {
        ArrayTabulatedFunction function = createFunction();
        Assert.assertEquals(1, function.indexOfY(5.0));
    }

    @Test
    public void testLeftBound() {
        ArrayTabulatedFunction function = createFunction();
        Assert.assertEquals(1.0, function.leftBound(), 0.0);
    }

    @Test
    public void testRightBound() {
        ArrayTabulatedFunction function = createFunction();
        Assert.assertEquals(3.0, function.rightBound(), 0.0);
    }

    @Test
    public void testInterpolate() {
        ArrayTabulatedFunction function = createFunction();
        assertEquals(4.7, function.interpolate(1.7, 2));
        assertNotEquals(0, function.interpolate(1.7, 2));
    }

    @Test
    public void testFloorIndexOfX() {
        ArrayTabulatedFunction function = createFunction();
        Assert.assertEquals(1, function.floorIndexOfX(2.5));
    }

    @Test
    public void testExtrapolateLeft() {
        ArrayTabulatedFunction function = createFunction();
        Assert.assertEquals(3.5, function.extrapolateLeft(0.5), 0.0);
    }

    @Test
    public void testExtrapolateRight() {
        ArrayTabulatedFunction function = createFunction();
        Assert.assertEquals(6.5, function.extrapolateRight(3.5), 0.0);
    }

    @Test
    public void testInterpolateSingle() {
        ArrayTabulatedFunction function = createFunction();
        Assert.assertEquals(5.5, function.interpolate(2.5), 0.0);
    }

    private ArrayTabulatedFunction createFunction() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {4.0, 5.0, 6.0};
        return new ArrayTabulatedFunction(xValues, yValues);
    }

    @Test
    public void toStringTest() {
        ArrayTabulatedFunction f = createFunction();
        Assert.assertEquals("[ 1.0, 4.0 ] [ 2.0, 5.0 ] [ 3.0, 6.0 ] ", f.toString());
    }

    @Test
    public void testEquals(){
        double[] xValues1 = {1.0, 2.0, 3.0};
        double[] yValues1 = {4.0, 5.0, 6.0};
        ArrayTabulatedFunction function1 = new ArrayTabulatedFunction(xValues1, yValues1);

        double[] xValues2 = {1.0, 2.0, 3.0};
        double[] yValues2 = {4.0, 5.0, 6.0};
        ArrayTabulatedFunction function2 = new ArrayTabulatedFunction(xValues2, yValues2);

        double[] xValues3 = {1.0, 2.0, 3.0};
        double[] yValues3 = {6.0, 7.0, 8.0};
        ArrayTabulatedFunction function3 = new ArrayTabulatedFunction(xValues3, yValues3);

        assertTrue(function1.equals(function1)); // объект равен самому себе
        assertTrue(function1.equals(function2)); // два объекта с одинаковыми значениями равны
        assertFalse(function1.equals(function3)); // объекты с разными значениями не равны
        assertFalse(function1.equals(null)); // объект не равен null
        assertFalse(function1.equals("Not an ArrayTabulatedFunction")); // объект не равен объекту другого класса
    }

    @Test
    public void testHashCode() {
        ArrayTabulatedFunction f = createFunction();
        ArrayTabulatedFunction f2 = createFunction();
        Assert.assertEquals(f.hashCode(), f2.hashCode());
    }
    @Test
    public void testClone() throws CloneNotSupportedException {
        ArrayTabulatedFunction func = createFunction();
        ArrayTabulatedFunction func2 = (ArrayTabulatedFunction) func.clone();
        Assert.assertEquals(func, func2);
    }

    @Test
    public void ArrayTwoTestException() {
        boolean exceptionThrown = false;
        double[] xValue2 = {5};
        double[] yValue2 = {2};
        try {
            ArrayTabulatedFunction arrTabulatedFunction2 = new ArrayTabulatedFunction(xValue2, yValue2);
        } catch (IllegalArgumentException exception) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }


    @Test
    public void getXException() {
        boolean exceptionThrown = false;

        try {
            function.getX(10);
        } catch (IndexOutOfBoundsException exception) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void getYException() {
        boolean exceptionThrown = false;

        try {
            function.getY(-10);
        } catch (IndexOutOfBoundsException exception) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void setYException() {
        boolean exceptionThrown = false;

        try {
            function.setY(13, 10);
        } catch (IndexOutOfBoundsException exception) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void indexOfXException() {
        boolean exceptionThrown = false;

        try {
            function.indexOfX(2.21);
        } catch (NoSuchElementException exception) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void floorIndexOfXException() {
        boolean exceptionThrown = false;

        try {
            function.floorIndexOfX(-2);
        } catch (IndexOutOfBoundsException exception) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void ArrayTabulatedFunctionLengthException() {
        double[] xValue2 = {5, 6, 5};
        double[] yValue2 = {2, 6, 7, 95};
        assertThrows(DifferentLengthOfArraysException.class, () -> {
            ArrayTabulatedFunction function2 = new ArrayTabulatedFunction(xValue2, yValue2);
        });
    }

    @Test
    public void ArrayTabulatedFunctionSortedException() {
        double[] xValue5 = {2, 3, 4, 17, 3, 45, 0};
        double[] yValue5 = {2, 34, 5, 56, 7, 6, 5};
        assertThrows(ArrayIsNotSortedException.class, () -> {
            ArrayTabulatedFunction function3 = new ArrayTabulatedFunction(xValue5, yValue5);
        });
    }

    @Test
    public void interpolateTestException() {
        assertThrows(InterpolationException.class, () -> {
            function.interpolate(2.5, 2);
        });
    }

    @Test
    public void IteratorTestException() {
        Iterator<Point> iterator = function.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(xValues[i], point.x);
            assertEquals(yValues[i], point.y);
            ++i;
        }
        i = 0;
        for (Point point : function) {
            assertEquals(xValues[i], point.x);
            assertEquals(yValues[i], point.y);
            ++i;
        }

    }

}