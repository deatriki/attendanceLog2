package gui.attendancelog;

import java.net.URL;
import java.util.ResourceBundle;

import BD.Facult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SettingsFacultCourses {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxFacult;

    @FXML
    private Button buttonAddFacult;

    @FXML
    private Button buttonBackPage;

    @FXML
    private Button buttonClearFacult;

    @FXML
    private Button buttonCoursesOk;

    @FXML
    private Button buttonUndo;

    @FXML
    private Label labelException;

    @FXML
    private TextField textFieldCourses;

    @FXML
    private TextField textFieldFacult;

    @FXML
    void initialize() {

        buttonClearFacult.setOnAction(actionEvent -> {
            Facult.clear("facult");
            Facult.createDB();
            boxReload();
        });

        boxFacult.getItems().addAll(Facult.outputDB("facult"));
        boxFacult.setOnAction(actionEvent -> {
            buttonAddFacult.setText("заменить");
        });

        buttonAddFacult.setOnAction(actionEvent -> {
            if(boxFacult.getValue()== null){
                if(textFieldFacult.getText() != "") {
                    try {
                        Facult.writeDB(textFieldFacult.getText());
                        textFieldFacult.setText("");
                    }catch (Exception e){e.printStackTrace();}
                }
            }
            else{
                if(textFieldFacult.getText() != "") {
                    Facult.updateBDWhere(boxFacult.getValue(), textFieldFacult.getText());
                    textFieldFacult.setText("");
                    boxReload();
                }
            }
            boxReload();
        });

        buttonUndo.setOnAction(actionEvent -> {
            boxReload();
            buttonAddFacult.setText("добавить");
        });
    }

    void boxReload(){
        ObservableList<String> e = FXCollections.observableArrayList();
        boxFacult.setItems(e);
        boxFacult.getItems().addAll(Facult.outputDB("facult"));
    }

}
