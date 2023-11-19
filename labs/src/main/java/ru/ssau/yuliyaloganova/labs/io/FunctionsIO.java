package ru.ssau.yuliyaloganova.labs.io;

import ru.ssau.yuliyaloganova.labs.functions.Point;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.factory.TabulatedFunctionFactory;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

final class FunctionsIO {
    private FunctionsIO() {
        throw new UnsupportedOperationException();
    }

    public static void writeTabulatedFunction(BufferedWriter writer, TabulatedFunction function) {
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println(function.getCount());

        for (Point point : function) {
            printWriter.printf("%f %f\n", point.x, point.y);
        }
        printWriter.flush();
    }

    public static TabulatedFunction readTabulatedFunction(BufferedReader reader, TabulatedFunctionFactory factory) throws IOException {
        int cnt = Integer.parseInt(reader.readLine());//извлечение целочисленного значения из первой строки
        double[] xValues = new double[cnt];
        double[] yValues = new double[cnt];

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.forLanguageTag("ru"));//объект форматирования дробных чисел

        for (int i = 0; i < cnt; i++) { //пробегаемся cnt раз
            String line = reader.readLine();
            String[] values = line.split(" ");//разбиение строки по пробелу
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

        for (Point point : function) {
            dataOutputStream.writeDouble(point.x);
            dataOutputStream.writeDouble(point.y);
        }

        dataOutputStream.flush();
    }

    public static void serialize(BufferedOutputStream stream, TabulatedFunction function) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
        objectOutputStream.writeObject(function);
        objectOutputStream.flush();
    }
}
