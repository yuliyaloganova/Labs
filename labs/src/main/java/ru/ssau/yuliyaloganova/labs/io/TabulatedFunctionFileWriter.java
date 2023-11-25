package ru.ssau.yuliyaloganova.labs.io;

import ru.ssau.yuliyaloganova.labs.functions.ArrayTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.LinkedListTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TabulatedFunctionFileWriter {
    public static void main(String[] args) {
        try {
            try (BufferedWriter arrayWriter = new BufferedWriter(new FileWriter("output/array function.txt"));
                 BufferedWriter linkedListWriter = new BufferedWriter(new FileWriter("output/linked list function.txt"))) {

                double[] xValue = {0, 1, 2, 3};
                double[] yValue = {0, 1, 4, 9};
                TabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xValue, yValue);
                TabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(xValue,yValue);

                FunctionsIO.writeTabulatedFunction(arrayWriter,arrayTabulatedFunction);
                FunctionsIO.writeTabulatedFunction(linkedListWriter,linkedListTabulatedFunction);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
