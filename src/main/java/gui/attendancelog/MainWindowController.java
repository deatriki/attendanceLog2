package gui.attendancelog;

import java.net.URL;
import java.util.ResourceBundle;

import BD.Course;
import BD.Facult;

import BD.Speciality;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.util.List;
import javafx.scene.control.Button;
import java.util.ArrayList;

import javafx.scene.control.ComboBox;


public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonShowTable;

    @FXML
    private Button button1;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private ComboBox<String> comboBoxCourse;

    @FXML
    private ComboBox<String> comboBoxGroup;

    @FXML
    private ComboBox<String> comboBoxLesson;

    @FXML
    void initialize() {
        comboBox.getItems().addAll(Facult.outputDB("Facult"));
        comboBoxCourse.getItems().addAll(Course.outputDB("Course"));
        comboBox.setOnAction(actionEvent -> {
            ObservableList<String> i = FXCollections.observableArrayList();
            comboBoxGroup.setItems(i);

            comboBoxGroup.getItems().addAll(Speciality.outputDB("Speciality", Facult.indexDB("Facult", comboBox.getValue()), comboBoxCourse.getValue()));
        } );
        comboBoxCourse.setOnAction(actionEvent -> {
            ObservableList<String> i = FXCollections.observableArrayList();
            comboBoxGroup.setItems(i);

            comboBoxGroup.getItems().addAll(Speciality.outputDB("Speciality", Facult.indexDB("Facult", comboBox.getValue()), comboBoxCourse.getValue()));

        });






//        button1.setOnAction(actionEvent -> {
//            try{
//                Parent secondWindow = FXMLLoader.load(getClass().getResource("setBDCourse.fxml"));
//                Stage secondStage = new Stage();
//                secondStage.setTitle("BD");
//                secondStage.setScene(new Scene(secondWindow, 700, 400));
//                secondStage.show();
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//        });


    }



}