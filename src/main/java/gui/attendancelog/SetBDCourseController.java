package gui.attendancelog;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import BD.Course;
import BD.Facult;
import BD.Lessons;
import BD.Speciality;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class SetBDCourseController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonADDInBD;

    @FXML
    private Button buttonGoBackPage;

    @FXML
    private ComboBox<String> comboBoxCourse;

    @FXML
    private ComboBox<String> comboBoxFacult;

    @FXML
    private ComboBox<String> comboBoxGroup;

    @FXML
    private ComboBox<?> comboBoxGroupID;

    @FXML
    private TextField textFieldADDInBD;

    @FXML
    private Label textShowBD;
    @FXML
    void initialize(){
        comboBoxFacult.getItems().addAll(Facult.outputDB("Facult"));
        comboBoxCourse.getItems().addAll(Course.outputDB("Course"));
        comboBoxFacult.setOnAction(actionEvent -> {
            ObservableList<String> i = FXCollections.observableArrayList();
            comboBoxGroup.setItems(i);

            comboBoxGroup.getItems().addAll(Speciality.outputDB("Speciality", Facult.indexDB("Facult", comboBoxFacult.getValue()), comboBoxCourse.getValue()));
        } );
        comboBoxCourse.setOnAction(actionEvent -> {
            ObservableList<String> i = FXCollections.observableArrayList();
            comboBoxGroup.setItems(i);

            comboBoxGroup.getItems().addAll(Speciality.outputDB("Speciality", Facult.indexDB("Facult", comboBoxFacult.getValue()), comboBoxCourse.getValue()));

        });
        comboBoxGroup.setOnAction(actionEvent ->{
            String temp = comboBoxGroup.getValue();
            String ID = Facult.indexDB("Facult", comboBoxFacult.getValue()) + comboBoxCourse.getValue();
            for(int i = temp.indexOf("-")+1; i<temp.length(); i++){
                ID += temp.charAt(i);
            }
            System.out.println(ID);
//            textShowBD.setText(Lessons.outputDB(ID));
            System.out.println("action");
        });
        buttonADDInBD.setOnAction(actionEvent -> {
            try {
                Lessons.writeDB(comboBoxGroup.getValue(), textFieldADDInBD.getText());
//                textShowBD.setText(Lessons.outputDB(comboBoxGroup.getValue()));
            }
            catch (Exception e) {e.printStackTrace();}
        });
    }
}

