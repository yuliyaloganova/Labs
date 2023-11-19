package ru.ssau.yuliyaloganova.labs.io;


import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.factory.TabulatedFunctionFactory;
import ru.ssau.yuliyaloganova.labs.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.yuliyaloganova.labs.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.yuliyaloganova.labs.operations.TabulatedDifferentialOperator;

import java.io.*;

public class TabulatedFunctionFileInputStream {
    public static void main(String[] args) {
        try (BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream("input/binary function.bin")) ) {
            TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
            TabulatedFunction function = FunctionsIO.readTabulatedFunction(fileInput, factory);
            System.out.println(function);


        } catch (IOException e) {
            e.printStackTrace();
        }

        try{ BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите размер и значения функции: ");
            TabulatedFunctionFactory factory = new LinkedListTabulatedFunctionFactory();
            TabulatedDifferentialOperator operator = new TabulatedDifferentialOperator(factory);
            TabulatedFunction function = FunctionsIO.readTabulatedFunction(inputReader, factory);
            System.out.println(operator.derive(function));
        }

        catch  (IOException e) {
            e.printStackTrace();}

    }

}
