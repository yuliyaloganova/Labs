package ru.ssau.yuliyaloganova.labs.concurrent;

import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
public class MultiplyingTask implements Runnable {
    private TabulatedFunction function;

    public MultiplyingTask(TabulatedFunction tabulatedFunction) {
        this.function = tabulatedFunction;
    }

    @Override
    public void run() {
        for (int i = 0; i < function.getCount(); i++) {
            synchronized (function) {
                function.setY(i, function.getY(i) * 2);
            }
            String thread = Thread.currentThread().getName();
            System.out.println("thread " + thread + "has completed the task.");
        }
    }
}