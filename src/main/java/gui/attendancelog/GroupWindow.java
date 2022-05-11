package gui.attendancelog;

import java.net.URL;
import java.util.ResourceBundle;

import BD.Group;
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

public class GroupWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button buttonBack;

    @FXML
    private URL location;

    @FXML
    private Button buttonNext;

    @FXML
    private Button buttonSettings;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    void initialize() {
        boxReload();
        buttonSettings.setOnAction(actionEvent -> {
            try{
                Parent secondWindow = FXMLLoader.load(getClass().getResource("settingsGroup.fxml"));
                Stage secondStage = new Stage();
                Scene secondScene = new Scene(secondWindow, 520, 340);

                secondStage.setTitle("выберите группу");
                secondStage.setScene(secondScene);
                secondStage.initModality(Modality.WINDOW_MODAL);
                secondStage.initOwner(Window.getWindows().get(1));
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
        buttonNext.setOnAction(actionEvent -> {
            if(comboBox.getValue()!= null){
                String[] groupNameAndNum = comboBox.getValue().split("-");
                ChosenId.setGroup(ChosenId.getCourse_id()+ChosenId.getCourse_id()+groupNameAndNum[1]);
                try{

                    Parent secondWindow = FXMLLoader.load(getClass().getResource("subject.fxml"));
                    Stage secondStage = new Stage();
                    Scene secondScene = new Scene(secondWindow, 260, 200);

                    secondStage.setTitle("выберите группу");
                    secondStage.setScene(secondScene);
                    secondStage.initModality(Modality.WINDOW_MODAL);
                    secondStage.initOwner(Window.getWindows().get(1));
                    secondStage.show();


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
        comboBox.getItems().addAll(Group.outputDB("groups", ChosenId.getFacult_id(), ChosenId.getCourse_id()));
    }
}