package ru.ssau.yuliyaloganova.labs.functions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import ru.ssau.yuliyaloganova.labs.exceptions.InterpolationException;
// класс табулированных функций, значения которых хранятся в массиве
public class ArrayTabulatedFunction extends AbstractTabulatedFunction {
    private double[] xValues; // приватное поле значений x
    private double[] yValues; // приватное поле значений y
    private int count; // приватное поле количества элементов

    // конструктор
    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        if (xValues.length < 2 || yValues.length < 2) {
            throw new IllegalArgumentException("length less than minimum");
        } else {
            checkLengthIsTheSame(xValues, yValues);
            checkSorted(xValues);
            this.xValues = Arrays.copyOf(xValues, xValues.length);
            this.yValues = Arrays.copyOf(yValues, yValues.length);
            this.count = xValues.length;
        }
    }
    // конструктор
    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (xFrom > xTo) { // меняем местами, если левая граница интервала больше правой
            double temp = xFrom;
            xFrom = xTo;
            xTo = temp;
        }

        this.count = count;
        this.xValues = new double[count];
        this.yValues = new double[count];

        double step = (xTo - xFrom) / (count - 1);

        for (int i = 0; i < count; i++) {
            double x = xFrom + step * i;
            this.xValues[i] = x;
            this.yValues[i] = source.apply(x);
        }
    }

    public int getCount() { // получаем поле count
        return count;
    }

    @Override
    public double getX(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return xValues[index];
    }
    @Override
    public double getY(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return yValues[index];
    }

    @Override
    public void setY(int index, double value) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        yValues[index] = value;
    }

    @Override
    public double leftBound() {
        return xValues[0];
    } // левая граница

    @Override
    public double rightBound() {
        return xValues[count - 1];
    } //правая граница


    @Override
    public int indexOfX(double x) {
        for (int i = 0; i < count; i++) {
            if (xValues[i] == x) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        for (int i = 0; i < count; i++) {
            if (yValues[i] == y) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected int floorIndexOfX(double x) {
        for (int i = 0; i < count - 1; ++i) {
            if (x < xValues[0]) { // если x меньше первого элемента
                return 0; // то возвращаем 0
            }
            if (x == xValues[i]) { // если мы нашли x,
                return i; // возвращаем его индес
            }
            if (x > xValues[i] && x < xValues[i + 1]) { //если мы находим такой промежуток, в котором x больше предыдущего, но меньше следующего
                return i; // то возвращаем индекс предыдущего
            }
        }
        if (x == xValues[count - 1]) { // смотрим, больше равен ли x последнему элементу
            return count - 1; //  если да, то возвращаем его значение
        }
        return count; // остальные условия не выполнились
    }

    @Override
    public double interpolate(double x, int floorIndex) {
        if (x<floorIndex && x> floorIndex - 1) {
            if (count == 1) {
                return yValues[0];
            } else {
                double x0 = xValues[floorIndex];
                double x1 = xValues[floorIndex + 1];
                double y0 = yValues[floorIndex];
                double y1 = yValues[floorIndex + 1];
                return y0 + (y1 - y0) * (x - x0) / (x1 - x0);
            }
        } else throw new InterpolationException("x is outside the interpolation interval");
    }

    protected double interpolate(double x) {
        int index = searchIndex(x);
        double x1 = xValues[index];
        double x2 = xValues[index + 1];
        double y1 = yValues[index];
        double y2 = yValues[index + 1];
        return y1 + (y2 - y1) / (x2 - x1) * (x - x1);
    }
    private int searchIndex(double x) { // вспомогательная функция поиска икса
        int n = xValues.length;
        if (x < xValues[0]) {
            return 0;
        } else if (x > xValues[n - 1]) {
            return n - 2;
        } else {
            for (int i = 0; i < n - 1; i++) {
                if (x >= xValues[i] && x < xValues[i + 1]) {
                    return i;
                }
            }

            throw new RuntimeException("Failed to find index for x value: " + x);
        }
    }
    @Override
    protected double extrapolateLeft(double x) {
        int index = searchIndex(x);
        double x1 = xValues[index];
        double x2 = xValues[index + 1];
        double y1 = yValues[index];
        double y2 = yValues[index + 1];
        return y1 + (y2 - y1) / (x2 - x1) * (x - x1);
    }

    protected double extrapolateRight(double x) {
        int index = searchIndex(x);
        double x1 = xValues[index];
        double x2 = xValues[index + 1];
        double y1 = yValues[index];
        double y2 = yValues[index + 1];
        return y2 + (y2 - y1) / (x2 - x1) * (x - x2);
    }

    @Override
    public String toString() {//Метод, возвращающий напечатанный массив
        String mass = "";
        for (int i=0; i < count; i++) {
            String x = String.valueOf(xValues[i]);
            String y = String.valueOf(yValues[i]);
            mass += "[ " + x + ", " + y + " ] ";
        }
        return mass;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ArrayTabulatedFunction other = (ArrayTabulatedFunction) o;
        return (Arrays.equals(xValues, other.xValues) && Arrays.equals(yValues, other.yValues));
    }

    @Override
    public int hashCode(){
        int res = Objects.hash(count);
        res = 31 * res + Arrays.hashCode(xValues);
        res = 31 * res + Arrays.hashCode(yValues);
        return res;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return new ArrayTabulatedFunction(xValues.clone(), yValues.clone());
    }

    @Override
    public Iterator<Point> iterator() {
        throw new UnsupportedOperationException("Iterator is not supported");
    }
}