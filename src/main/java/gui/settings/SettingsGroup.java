package gui.settings;

import java.net.URL;
import java.util.ResourceBundle;

import BD.Group;
import gui.ChosenId;
import gui.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.stage.Stage;


public class SettingsGroup {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> box;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonBackPage;

    @FXML
    private Button buttonClear;

    @FXML
    private Button buttonUndo;

    @FXML
    private Label labelException;

    @FXML
    private TextField textField;

    @FXML
    void initialize() {
        boxReload();
        buttonClear.setOnAction(actionEvent -> {
            try {
                Group.clearWhere(ChosenId.getFacult_id(), ChosenId.getCourse_id());
                labelException.setText("all groups removed");
            }
            catch (Exception e){
                labelException.setText("error");
            }
            boxReload();
        });

        buttonAdd.setOnAction(actionEvent -> {
            if(box.getValue()==null){
                if(!textField.getText().equals("")){
                    try {
                        Group.writeDB(ChosenId.getFacult_id(), ChosenId.getCourse_id(), textField.getText());
                        textField.setText("");
                        labelException.setText("Group\n" +
                                "successfully\n" +
                                "added");
                        boxReload();
                    }
                    catch (Exception e){e.printStackTrace();}
                }
            }
            else {
                if(!textField.getText().equals("")){
                    String[] groupAndID = box.getValue().split("-");
                    Group.updateDBWhere(ChosenId.getFacult_id(), ChosenId.getCourse_id(), groupAndID[0], groupAndID[1], textField.getText());

                    labelException.setText("Group:\n"+ box.getValue()+"\nreplaced with:\n"+textField.getText());
                    textField.setText("");
                    boxReload();
                }
            }
        });

        box.setOnAction(actionEvent -> {
            buttonAdd.setText("replace");
        });

        buttonUndo.setOnAction(actionEvent -> {
            boxReload();
            buttonAdd.setText("add");
        });
        buttonBackPage.setOnAction(actionEvent -> {

            Stage stage = (Stage) buttonBackPage.getScene().getWindow();
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
    }
    void boxReload(){
        ObservableList<String> e = FXCollections.observableArrayList();
        box.setItems(e);
        box.getItems().addAll(Group.outputDB("groups", ChosenId.getFacult_id(), ChosenId.getCourse_id()));
    }

}