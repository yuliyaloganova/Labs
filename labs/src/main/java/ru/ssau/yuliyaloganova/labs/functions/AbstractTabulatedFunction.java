package ru.ssau.yuliyaloganova.labs.functions;

import ru.ssau.yuliyaloganova.labs.exceptions.ArrayIsNotSortedException;
import ru.ssau.yuliyaloganova.labs.exceptions.DifferentLengthOfArraysException;
import java.io.Serializable;

public abstract class AbstractTabulatedFunction implements TabulatedFunction , Serializable {
    protected int count;

    protected abstract int floorIndexOfX(double x);

    protected abstract double extrapolateLeft(double x); //Метод экстраполяции слева

    protected abstract double extrapolateRight(double x); //Метод экстраполяции справа

    protected abstract double interpolate(double x, int floorIndex); //Метод интерполяции с указанием индекса интервала

    //защищённый метод с реализацией интерполяции
    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY) {
        return leftY + (x - leftX) * (rightY - leftY) / (rightX - leftX);
    }

    @Override
    public double apply(double x) {
        if (x < leftBound())
            return extrapolateLeft(x);
        else if (x > rightBound())
            return extrapolateRight(x);
        else {
            int floorIndex = floorIndexOfX(x);
            int index = indexOfX(x);

            if (index != -1)
                return getY(index);

            else
                return interpolate(x, floorIndex);
        }
    }

    void checkLengthIsTheSame(double[] xValues, double[] yValues){
        if (xValues.length != yValues.length) {
            throw new DifferentLengthOfArraysException("Lengths of xValues and yValues are different");
        }
    }
    void checkSorted(double[] xValues){
        for (int i = 1; i < xValues.length; i++) {
            if (xValues[i] <= xValues[i - 1]) throw new ArrayIsNotSortedException("Array is not sorted");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" size = ").append(getCount()).append("\n");

        for (Point point : this) {
            sb.append("[").append(point.x).append("; ").append(point.y).append("]\n");
        }

        return sb.toString();
    }


}