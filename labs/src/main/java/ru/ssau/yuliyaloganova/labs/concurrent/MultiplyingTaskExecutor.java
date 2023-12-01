package ru.ssau.yuliyaloganova.labs.concurrent;

import ru.ssau.yuliyaloganova.labs.functions.LinkedListTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.UnitFunction;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MultiplyingTaskExecutor {
    public static void main(String[] args) throws InterruptedException {
        TabulatedFunction function = new LinkedListTabulatedFunction(new UnitFunction(), 1, 1000, 1000);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            Runnable task = new MultiplyingTask(function);
            executorService.execute(task);
        }

        countDownLatch.await();
        executorService.shutdown();

        System.out.println(function);
    }
}