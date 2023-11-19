package ru.ssau.yuliyaloganova.labs.io;

import ru.ssau.yuliyaloganova.labs.functions.Point;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

final class FunctionsIO {
    private FunctionsIO(){
        throw new UnsupportedOperationException();
    }

    public static void writeTabulatedFunction(BufferedWriter writer, TabulatedFunction function){
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println(function.getCount());

        for (Point point : function) {
            printWriter.printf("%f %f\n", point.x, point.y);
        }
        printWriter.flush();
    }
}
