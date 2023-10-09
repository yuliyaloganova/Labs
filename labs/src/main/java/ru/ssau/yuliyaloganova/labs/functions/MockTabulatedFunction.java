package ru.ssau.yuliyaloganova.labs.functions;

// mock-объект для последующего тестирования класса абстрактных табулированных функций
public class MockTabulatedFunction extends AbstractTabulatedFunction {
    private final double x0;
    private final double x1;
    private final double y0;
    private final double y1;

    public MockTabulatedFunction(double x0, double x1, double y0, double y1) {//конструктор
        this.x0 = x0;
        this.x1 = x1;
        this.y0 = y0;
        this.y1 = y1;
    }

    @Override
    public double getX(int index) {
        if (index == 0) {
            return x0;
        } else if (index == 1) {
            return x1;
        } else {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
    }

    @Override
    public double getY(int index) {
        if (index == 0) {
            return y0;
        } else if (index == 1) {
            return y1;
        } else {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
    }

    @Override
    public void setY(int index, double value){}

    @Override
    public int indexOfX(double x) {
        if (x == x0) {
            return 0;
        } else if (x == x1) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int indexOfY(double y) {
        if (y == y0) {
            return 0;
        } else if (y == y1) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public double leftBound() {
        return Math.min(x0, x1);
    }

    @Override
    public double rightBound() {
        return Math.max(x0, x1);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    protected int floorIndexOfX(double x) {
        if (x < x0) {
            return 0;
        } else if (x == x1) {
            return count-1;
        }
        else return count;
    }

    @Override
    protected double extrapolateLeft(double x) {
        return y0;
    }

    @Override
    protected double extrapolateRight(double x) {
        return y1;
    }

    @Override
    public double interpolate(double x, int floorIndex) {
        double k = (y1 - y0) / (x1 - x0);
        return y0 + k * (x - x0);
    }
}
