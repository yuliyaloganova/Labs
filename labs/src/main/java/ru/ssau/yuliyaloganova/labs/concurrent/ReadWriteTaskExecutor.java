package ru.ssau.yuliyaloganova.labs.concurrent;

import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.LinkedListTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.ConstantFunction;

public class ReadWriteTaskExecutor {
    public static void main(String[] args) {
        TabulatedFunction function = new LinkedListTabulatedFunction(new ConstantFunction(-1),1,1000,1000);
        Thread threadRead = new Thread(new ReadTask(function));
        Thread threadWrite = new Thread(new WriteTask(function,0.5));

        threadRead.start();
        threadWrite.start();

    }
}
