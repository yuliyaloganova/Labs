package ru.ssau.yuliyaloganova.labs.functions;

import org.junit.Assert;
import org.junit.Test;

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

}