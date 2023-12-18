package ru.ssau.yuliyaloganova.labs.ui;

import ru.ssau.yuliyaloganova.labs.exceptions.DifferentLengthOfArraysException;
import ru.ssau.yuliyaloganova.labs.exceptions.InconsistentFunctionsException;
import ru.ssau.yuliyaloganova.labs.functions.TabulatedFunction;
import ru.ssau.yuliyaloganova.labs.io.FunctionsIO;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import ru.ssau.yuliyaloganova.labs.operations.TabulatedFunctionOperationService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ru.ssau.yuliyaloganova.labs.ui.UIException.showException;

public class SimpleOperationsController implements Initializable {

    @FXML
    public ChoiceBox<String> opChoice;
    @FXML
    public TableColumn<TablePoint, Double> yColumn;
    @FXML
    public TableColumn<TablePoint, Double> xColumn;
    @FXML
    public TableView<TablePoint> table;
    public Button saveResultButton;
    //public Button integrationButton;
    public AnchorPane anchorPane;

    @FXML
    Parent firstTable;

    @FXML
    Parent secondTable;
    @FXML
    TableController firstTableController;
    @FXML
    TableController secondTableController;
    @FXML
    public Pane pane;

    TabulatedFunction function;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        table.setPlaceholder(new Label(" "));
        saveResultButton.setVisible(false);

        ObservableList<String> list = FXCollections.observableArrayList("+", "-", "*", ":");
        opChoice.getItems().addAll(list);

        xColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        yColumn.setCellValueFactory(new PropertyValueFactory<>("y"));

        opChoice.getSelectionModel().select(0);

    }

    public void doOperation(ActionEvent action) throws IOException {

        TabulatedFunctionOperationService operationService = new TabulatedFunctionOperationService();
        try {

            switch (opChoice.getValue()) {

                case "+":
                    function = operationService.plus(firstTableController.function, secondTableController.function);
                    break;

                case "-":
                    function = operationService.minus(firstTableController.function, secondTableController.function);
                    break;

                case "*":
                    function = operationService.multiply(firstTableController.function, secondTableController.function);
                    break;

                case ":":
                    function = operationService.divide(firstTableController.function, secondTableController.function);
                    break;

            }
            table.getItems().clear();
            for (int i = 0; i < function.getCount(); i++) {
                table.getItems().add(new TablePoint(function.getX(i), function.getY(i)));
            }
        }
        catch (ArithmeticException e){
            showException("Деление на 0... Классика");
        }
        catch (InconsistentFunctionsException e){
            showException("Функции несовместимы!");
        }
        catch (NullPointerException e){
            showException("Заполните таблицы!");
        }

        saveResultButton.setVisible(true);

    }


    public void saveResult(ActionEvent event) throws IOException {

        UIInputOutput.save(function);
    }

}
