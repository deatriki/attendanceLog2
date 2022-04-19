package gui.attendancelog;

import java.net.URL;
import java.util.ResourceBundle;

import BD.Courses;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ComboBox;


public class MainWindowController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonChooseCourse;

    @FXML
    private Button button1;


    @FXML
    private ComboBox<String> comboBox;



    @FXML
    void initialize() {
        comboBox.getItems().addAll(Courses.outputDB("Courses"));






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