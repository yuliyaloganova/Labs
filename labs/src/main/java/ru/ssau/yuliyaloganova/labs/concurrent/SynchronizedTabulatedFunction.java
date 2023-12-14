package ru.ssau.yuliyaloganova.labs.concurrent;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
import ru.ssau.yuliyaloganova.labs.operations.TabulatedFunctionOperationService;
import ru.ssau.yuliyaloganova.labs.functions.Point;

public class SynchronizedTabulatedFunction implements TabulatedFunction {
    private final TabulatedFunction delegation;
    public SynchronizedTabulatedFunction(TabulatedFunction delegation) {
        this.delegation = delegation;
    }
    @Override
    public int getCount() {
        synchronized (delegation){
            return delegation.getCount();
        }
    }
    @Override
    public double getX(int index) {
        synchronized (delegation){
            return delegation.getX(index);
        }
    }
    @Override
    public double getY(int index) {
        synchronized (delegation){
            return delegation.getY(index);
        }
    }
    @Override
    public void setY(int index,double value) {
        synchronized (delegation){
            delegation.setY(index,value);
        }
    }
    @Override
    public int indexOfX(double x) {
        synchronized (delegation){
            return delegation.indexOfX(x);
        }
    }
    @Override
    public int indexOfY(double y) {
        synchronized (delegation){
            return delegation.indexOfY(y);
        }
    }
    @Override
    public double rightBound() {
        synchronized (delegation){
            return delegation.rightBound();
        }
    }
    @Override
    public double leftBound() {
        synchronized (delegation){
            return delegation.leftBound();
        }
    }
    @Override
    public Iterator<Point> iterator() {
        synchronized (delegation){
            Point[] copy= TabulatedFunctionOperationService.asPoints(delegation);
            return new Iterator<Point>() {
                int temp = 0;
                @Override
                public boolean hasNext() {
                    return (temp < copy.length);
                }

                @Override
                public Point next() {
                    Point point;
                    if(hasNext()) {
                        point = copy[temp++];
                    }
                    else throw new NoSuchElementException();
                    return point;
                }
            };
        }
    }
    @Override
    public double apply(double x) {
        synchronized (delegation){
            return delegation.apply(x);
        }
    }

    public interface Operation<T> {
        T apply(SynchronizedTabulatedFunction synchFunc);
    }

    public <T> T doSynchronously(Operation<T> operation) {
        synchronized (this) {
            return operation.apply(this);
        }
    }
}
