package ru.ssau.yuliyaloganova.labs.io;

import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.factory.ArrayTabulatedFunctionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class TabulatedFunctionFileReader {
    public static void main(String[] args) {
        try {
            //файловые символьные потоки чтения
            try (BufferedReader arrayReader = new BufferedReader(new FileReader("C:/Users/Вячеслав/IdeaProjects/Labs/labs/input/function.txt"));
                 BufferedReader linkedReader = new BufferedReader(new FileReader("C:/Users/Вячеслав/IdeaProjects/Labs/labs/input/function.txt"))) {
                //получение объектов функций
                TabulatedFunction arrayTabulatedFunction = FunctionsIO.readTabulatedFunction(arrayReader, new ArrayTabulatedFunctionFactory());
                TabulatedFunction linkedListTabulatedFunction = FunctionsIO.readTabulatedFunction(linkedReader, new ru.ssau.yuliyaloganova.labs.functions.factory.LinkedListTabulatedFunctionFactory());

                System.out.println("Array:");
                System.out.println(arrayTabulatedFunction.toString());
                System.out.println("Linked List:");
                System.out.println(linkedListTabulatedFunction.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}