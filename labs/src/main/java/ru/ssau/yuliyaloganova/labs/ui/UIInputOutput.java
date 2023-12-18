package ru.ssau.yuliyaloganova.labs.ui;


import ru.ssau.yuliyaloganova.labs.functions.ArrayTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.LinkedListTabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
import ru.ssau.yuliyaloganova.labs.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.yuliyaloganova.labs.io.FunctionsIO;
import javafx.scene.control.Tab;
import javafx.stage.FileChooser;

import java.io.*;

public class UIInputOutput {

    static public void save(TabulatedFunction function) throws IOException {

        FileChooser fileChooser = new FileChooser();
        /*fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Bin files", "*.bin"), new FileChooser.ExtensionFilter("XML files", "*.xml"))*/;
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Bin files", "*.bin"));
        /*if (function.getClass() == ArrayTabulatedFunction.class)
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files", "*.json"));*/
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {


            FileOutputStream outputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedInputStream = new BufferedOutputStream(outputStream);
            FunctionsIO.serialize(bufferedInputStream, function);


        }

    }

    static public TabulatedFunction load() throws IOException, ClassNotFoundException {

        FileChooser fileChooser = new FileChooser();
        /*fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Bin files", "*.bin"), new FileChooser.ExtensionFilter("XML files", "*.xml"), new FileChooser.ExtensionFilter("JSON files", "*.json"));*/
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Bin files", "*.bin"));
        File file = fileChooser.showOpenDialog(null);

        TabulatedFunction function = null;

        if (file != null) {


            FileInputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            function = FunctionsIO.deserialize(bufferedInputStream);


        }

        return function;

    }

}
