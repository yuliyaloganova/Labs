package ru.ssau.yuliyaloganova.labs.functions;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArrayTabulatedFunctionTest {

    @Test
    public void testConstructorWithArrays() {
        double[] xValues = {1.0, 2.0, 3.0};
        double[] yValues = {4.0, 5.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);
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
        Assert.assertEquals(4.5, function.interpolate(1.5, 1), 0.0);
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

}