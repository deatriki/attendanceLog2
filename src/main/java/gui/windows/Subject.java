package gui.windows;

import java.net.URL;
import java.util.ResourceBundle;

import BD.Subjects;
import gui.ChosenId;
import gui.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class Subject {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonNext;

    @FXML
    private Button buttonSettings;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    void initialize() {
        boxReload();
        comboBox.setItems(Subjects.outputDB(ChosenId.getGroup()));
        buttonSettings.setOnAction(actionEvent -> {
            Stage stage = (Stage) buttonSettings.getScene().getWindow();
            try{

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("settingsSubject.fxml"));

                Scene secondScene = new Scene(fxmlLoader.load(), 520, 340);

                stage.setTitle("subject settings");
                stage.setScene(secondScene);


                stage.show();


            }
            catch (Exception e){
                e.printStackTrace();
            }

        });
        buttonBack.setOnAction(actionEvent -> {
            Stage stage = (Stage) buttonBack.getScene().getWindow();
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
        });

        buttonNext.setOnAction(actionEvent -> {
            if(comboBox.getValue()!= null){
                ChosenId.setSubject(comboBox.getValue());
                Stage stage = (Stage) buttonNext.getScene().getWindow();
                try{

                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Attendance.fxml"));

                    Scene secondScene = new Scene(fxmlLoader.load(), 1050, 600);

                    stage.setTitle("attendance table");
                    stage.setScene(secondScene);


                    stage.show();


                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    void boxReload(){
        ObservableList<String> e = FXCollections.observableArrayList();
        comboBox.setItems(e);
        comboBox.getItems().addAll();
    }
}
