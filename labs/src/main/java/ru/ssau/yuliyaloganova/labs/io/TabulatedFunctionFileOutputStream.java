package ru.ssau.yuliyaloganova.labs.io;

import ru.ssau.yuliyaloganova.labs.functions.ArrayTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.LinkedListTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;



public class TabulatedFunctionFileOutputStream {
    public static void main(String[] args) {
        try (BufferedOutputStream arrayFileOutput = new BufferedOutputStream(new FileOutputStream("output/array function.bin"));
             BufferedOutputStream linkedListFileOutput = new BufferedOutputStream(new FileOutputStream("output/linked list function.bin"))) {
            double[] xValue = {1, 3, 5, 7};
            double[] yValue = {2, 4, 6, 8};
            TabulatedFunction arrayFunction = new ArrayTabulatedFunction(xValue, yValue);
            TabulatedFunction linkedListFunction = new LinkedListTabulatedFunction(xValue, yValue);

            FunctionsIO.writeTabulatedFunction(arrayFileOutput, arrayFunction);
            FunctionsIO.writeTabulatedFunction(linkedListFileOutput, linkedListFunction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}