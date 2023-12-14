package ru.ssau.yuliyaloganova.labs.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class UIException {


    static public void showException(String warn) throws IOException {

        FXMLLoader loader = new FXMLLoader(UIException.class.getClassLoader().getResource("ru/ssau/yuliyaloganova/labs/ui/Exception.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 300, 140);
        Stage stage = new Stage();
        ExceptionController exceptionController = loader.getController();
        exceptionController.setWarningMessage(warn);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);

        stage.setScene(scene);

        stage.show();

    }


}