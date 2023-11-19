package ru.ssau.yuliyaloganova.labs.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.*;


import ru.ssau.yuliyaloganova.labs.operations.TabulatedDifferentialOperator;
import ru.ssau.yuliyaloganova.labs.functions.ArrayTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
public class ArrayTabulatedFunctionSerialization {
    public static void main(String[] args){
        try {
            try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("output/serialized array function.bin"))) {
                double[] xValues = {1, 2, 3};
                double[] yValues = {1.5, 2.5, 3.5};

                TabulatedDifferentialOperator tabulatedDifferentialOperator = new TabulatedDifferentialOperator();

                TabulatedFunction arrayFunc = new ArrayTabulatedFunction(xValues, yValues);
                TabulatedFunction differenArrayFunc1 = tabulatedDifferentialOperator.derive(arrayFunc);
                TabulatedFunction differenArrayFunc2 = tabulatedDifferentialOperator.derive(differenArrayFunc1);

                FunctionsIO.serialize(bufferedOutputStream, arrayFunc);
                FunctionsIO.serialize(bufferedOutputStream, differenArrayFunc1);
                FunctionsIO.serialize(bufferedOutputStream, differenArrayFunc2);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("input/serialized array function.bin"))) {
                System.out.println(FunctionsIO.deserialize(bufferedInputStream));
                System.out.println(FunctionsIO.deserialize(bufferedInputStream));
                System.out.println(FunctionsIO.deserialize(bufferedInputStream));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
