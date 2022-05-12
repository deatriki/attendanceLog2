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
            Stage stage = (Stage) buttonSettings.getScene().getWindow();
            try{

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("settingsGroup.fxml"));

                Scene secondScene = new Scene(fxmlLoader.load(), 520, 340);

                stage.setTitle("настройки факультета и курсов");
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

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainWindow.fxml"));

                Scene secondScene = new Scene(fxmlLoader.load(), 520, 340);

                stage.setTitle("выберите группу");
                stage.setScene(secondScene);


                stage.show();


            }
            catch (Exception e){
                e.printStackTrace();
            }
        });
        buttonNext.setOnAction(actionEvent -> {
            if(comboBox.getValue()!= null){
                String[] groupNameAndNum = comboBox.getValue().split("-");
                ChosenId.setGroup(ChosenId.getCourse_id()+ChosenId.getCourse_id()+groupNameAndNum[1]);
                Stage stage = (Stage) buttonNext.getScene().getWindow();
                try{

                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("subject.fxml"));

                    Scene secondScene = new Scene(fxmlLoader.load(), 260, 200);

                    stage.setTitle("выберите группу");
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
        comboBox.getItems().addAll(Group.outputDB("groups", ChosenId.getFacult_id(), ChosenId.getCourse_id()));
    }
}
