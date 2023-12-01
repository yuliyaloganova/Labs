package ru.ssau.yuliyaloganova.labs.concurrent;

import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;

public class ReadTask implements Runnable {
    private final TabulatedFunction tabulatedFunction;

    public ReadTask(TabulatedFunction tabulatedFunction) {
        this.tabulatedFunction = tabulatedFunction;

    }
    @Override
    public void run() {
        for (int i = 0; i < tabulatedFunction.getCount(); i++) {
            String str = String.format("i = %d, x = %f, y = %f", i, tabulatedFunction.getX(i), tabulatedFunction.getY(i));
            System.out.println(str);
        }
    }
}
