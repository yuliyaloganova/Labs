package ru.ssau.yuliyaloganova.labs.ui;

import ru.ssau.yuliyaloganova.labs.functions.factory.ArrayTabulatedFunctionFactory;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Window extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ui/MainWindow.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("7 lab");
        primaryStage.show();
        Settings.getInstance().setFactory(new ArrayTabulatedFunctionFactory());

        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });

    }

}