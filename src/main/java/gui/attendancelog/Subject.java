package gui.attendancelog;

import java.net.URL;
import java.util.ResourceBundle;

import BD.Subjects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

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
            try{
                Parent secondWindow = FXMLLoader.load(getClass().getResource("settingsSubject.fxml"));
                Stage secondStage = new Stage();
                Scene secondScene = new Scene(secondWindow, 520, 340);

                secondStage.setTitle("выберите предмет");
                secondStage.setScene(secondScene);
                secondStage.initModality(Modality.WINDOW_MODAL);
                secondStage.initOwner(Window.getWindows().get(2));
                secondStage.show();

            }
            catch (Exception e){
                e.printStackTrace();
            }
        });
        buttonBack.setOnAction(actionEvent -> {
            Stage stage = (Stage) buttonBack.getScene().getWindow();
            stage.close();
        });
    }
    void boxReload(){
        ObservableList<String> e = FXCollections.observableArrayList();
        comboBox.setItems(e);
        comboBox.getItems().addAll();
    }
}
