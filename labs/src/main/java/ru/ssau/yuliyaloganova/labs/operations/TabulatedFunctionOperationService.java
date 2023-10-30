package ru.ssau.yuliyaloganova.labs.operations;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.Point;

public class TabulatedFunctionOperationService {
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
}
