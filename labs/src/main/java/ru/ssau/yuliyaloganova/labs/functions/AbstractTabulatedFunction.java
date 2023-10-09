package ru.ssau.yuliyaloganova.labs.functions;

public abstract class AbstractTabulatedFunction implements TabulatedFunction {
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
}