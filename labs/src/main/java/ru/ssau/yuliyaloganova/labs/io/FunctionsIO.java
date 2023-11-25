package ru.ssau.yuliyaloganova.labs.io;

import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.factory.TabulatedFunctionFactory;

import java.io.*;
import java.text.NumberFormat;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;
import java.io.PrintWriter;

public final class FunctionsIO {
    private FunctionsIO(){
        throw new UnsupportedOperationException();
    }

    public static void writeTabulatedFunction(BufferedWriter writer, TabulatedFunction function){
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println(function.getCount());

        for (int i = 0; i < function.getCount(); i++) {
            double x = function.getX(i);
            double y = function.getY(i);
            printWriter.printf("%f %f%n", x, y);
        }
        printWriter.flush();
    }

    public static TabulatedFunction readTabulatedFunction(BufferedReader reader, TabulatedFunctionFactory factory) throws IOException {
        int cnt = Integer.parseInt(reader.readLine());//извлечение целочисленного значения из первой строки
        double[] xValues = new double[cnt];
        double[] yValues = new double[cnt];

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.forLanguageTag("ru"));//объект форматирования дробных чисел

        for (int i = 0; i < cnt; i++) { //пробегаемся cnt раз
            //String line = reader.readLine();
            String[] values = reader.readLine().split(" ");//разбиение строки по пробелу
            try {
                xValues[i] = numberFormat.parse(values[0]).doubleValue();
                yValues[i] = numberFormat.parse(values[1]).doubleValue();
            } catch (ParseException e) {
                throw new IOException(e);
            }
        }

        return factory.create(xValues, yValues);
    }

    public static void writeTabulatedFunction(BufferedOutputStream outputStream, TabulatedFunction function) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(function.getCount());

        for (int i = 0; i < function.getCount(); i++) {
            double x = function.getX(i);
            double y = function.getY(i);
            dataOutputStream.writeDouble(x);
            dataOutputStream.writeDouble(y);
        }

        dataOutputStream.flush();
    }

    public static TabulatedFunction readTabulatedFunction(BufferedInputStream inputStream, TabulatedFunctionFactory factory) throws IOException {

        DataInputStream in = new DataInputStream(inputStream);
        int length = in.readInt();
        double[] xValue = new double[length];
        double[] yValue = new double[length];
        for (int i = 0; i < length; i++) {
            xValue[i] = in.readDouble();
            yValue[i] = in.readDouble();
        }
        return factory.create(xValue, yValue);
    }

    public static void serialize(BufferedOutputStream stream, TabulatedFunction function) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
        objectOutputStream.writeObject(function);
        objectOutputStream.flush();
    }

    public static  TabulatedFunction deserialize(BufferedInputStream stream) throws IOException,ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream(stream);
        return (TabulatedFunction)objectInputStream.readObject();
    }
}
