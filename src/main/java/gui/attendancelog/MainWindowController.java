package gui.attendancelog;

import java.net.URL;
import java.util.ResourceBundle;

import BD.Course;
import BD.Facult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonNext;

    @FXML
    private Button buttonSettings;

    @FXML
    private ComboBox<String> comboBoxCourse;

    public ComboBox<String> getComboBoxCourse() {
        return comboBoxCourse;
    }

    public void setComboBoxCourse(ComboBox<String> comboBoxCourse) {
        this.comboBoxCourse = comboBoxCourse;
    }

    public ComboBox<String> getComboBoxFacult() {
        return comboBoxFacult;
    }

    public void setComboBoxFacult(ComboBox<String> comboBoxFacult) {
        this.comboBoxFacult = comboBoxFacult;
    }

    @FXML
    private ComboBox<String> comboBoxFacult;

    @FXML
    void initialize() {
        comboBoxFacult.getItems().addAll(Facult.outputDB("facult"));
        comboBoxCourse.getItems().addAll(Course.outputDB("course"));

        buttonNext.setOnAction(actionEvent -> {
            if(comboBoxFacult.getValue()!= null && comboBoxCourse.getValue() != null){
                ChosenId.setCourse_id(comboBoxCourse.getValue());
                ChosenId.setFacult_id(Facult.indexDB("facult", comboBoxFacult.getValue()));

                Stage stage = (Stage) buttonNext.getScene().getWindow();
                try{

                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("groupWindow.fxml"));

                    Scene secondScene = new Scene(fxmlLoader.load(), 260, 200);

                    stage.setTitle("select a group");
                    stage.setScene(secondScene);


                    stage.show();


                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        buttonSettings.setOnAction(actionEvent -> {
            Stage stage = (Stage) buttonSettings.getScene().getWindow();
            try{

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("settingsFacultCourses.fxml"));

                Scene secondScene = new Scene(fxmlLoader.load(), 520, 340);

                stage.setTitle("settings of faculties and courses");
                stage.setScene(secondScene);


                stage.show();


            }
            catch (Exception e){
                e.printStackTrace();
            }

        });

    }


}






