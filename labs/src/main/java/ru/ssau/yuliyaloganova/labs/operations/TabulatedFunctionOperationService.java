package ru.ssau.yuliyaloganova.labs.operations;

import ru.ssau.yuliyaloganova.labs.functions.Point;
import ru.ssau.yuliyaloganova.labs.exceptions.InconsistentFunctionsException;
import ru.ssau.yuliyaloganova.labs.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.yuliyaloganova.labs.functions.factory.TabulatedFunctionFactory;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;

public class TabulatedFunctionOperationService {

    protected TabulatedFunctionFactory factory;

    public TabulatedFunctionOperationService(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }
    public TabulatedFunctionOperationService() {
        this.factory = new ArrayTabulatedFunctionFactory();//поле factory инициализируется объектом класса ArrayTabulatedFunctionFactory
    }

    public TabulatedFunctionFactory getFactory() {//геттер
        return this.factory;
    }

    public void setFactory(TabulatedFunctionFactory factory) {//сеттер
        this.factory = factory;
    }

    public static Point[] asPoints(TabulatedFunction tabulatedFunction) {
        int i = 0;
        int size = tabulatedFunction.getCount();
        Point[] points = new Point[size];//создаем массив точек `points` размером, соответствующим количеству точек в функции `TabulatedFunction`
        //проходим по всем точкам функции и записываем каждую точку в массив `points` с индексом `i`
        for (Point num : tabulatedFunction) {
            points[i] = num;
            i++;
        }
        return points;//возвращаем массив точек
    }

    private interface BiOperation {
        double apply(double u, double v);
    }

    private TabulatedFunction doOperation(TabulatedFunction a, TabulatedFunction b, BiOperation operation){
        if (a.getCount() != b.getCount()) throw new InconsistentFunctionsException();
        else {
            Point[] arraysA = asPoints(a);
            Point[] arraysB = asPoints(b);

            double[] xValue = new double[a.getCount()];
            double[] yValue = new double[b.getCount()];

            for (int i = 0; i < a.getCount(); i++) {
                if (arraysA[i].x == arraysB[i].x) xValue[i] = arraysA[i].x;
                else throw new InconsistentFunctionsException();
                yValue[i] = operation.apply(arraysA[i].y, arraysB[i].y);
            }
            return factory.create(xValue, yValue);
        }
    }
    public TabulatedFunction plus(TabulatedFunction firstFunction, TabulatedFunction secondFunction) {
        BiOperation operation = Double::sum;
        return doOperation(firstFunction, secondFunction, operation);
    }

    public TabulatedFunction minus(TabulatedFunction firstFunction, TabulatedFunction secondFunction) {
        BiOperation operation = (u, v) -> u - v;
        return doOperation(firstFunction, secondFunction, operation);
    }

    public TabulatedFunction multiply(TabulatedFunction firstFunction, TabulatedFunction secondFunction) {
        BiOperation operation = (u, v) -> u * v;
        return doOperation(firstFunction, secondFunction, operation);
    }

    public TabulatedFunction divide(TabulatedFunction firstFunction, TabulatedFunction secondFunction) {
        BiOperation operation = (u, v) -> {
            if (v != 0) {
                return u / v;
            } else {
                throw new ArithmeticException("Деление на 0");
            }
        };
        return doOperation(firstFunction, secondFunction, operation);
    }

}
