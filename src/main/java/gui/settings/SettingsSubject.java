package gui.settings;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.stage.Stage;


public class SettingsSubject {

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

            Subjects.clearWhere(ChosenId.getGroup());
            labelException.setText("all subject removed");

            boxReload();
        });

        buttonAdd.setOnAction(actionEvent -> {
            if(box.getValue()==null){
                if(!textField.getText().equals("")){
                    try {
                        Subjects.writeDB(ChosenId.getGroup(), textField.getText());
                        textField.setText("");
                        labelException.setText("subject\n" +
                                "successfully\n" +
                                "added");
                        boxReload();
                    }
                    catch (Exception e){e.printStackTrace();}
                }
            }
            else {
                if(!textField.getText().equals("")){

                    Subjects.updateDBWhere(ChosenId.getGroup(), box.getValue(), textField.getText());

                    labelException.setText("subject:\n"+ box.getValue()+"\nreplaced with:\n"+textField.getText());
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

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("subject.fxml"));

                Scene secondScene = new Scene(fxmlLoader.load(), 260, 200);

                stage.setTitle("select subject");
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
        box.getItems().addAll(Subjects.outputDB(ChosenId.getGroup()));
    }

}
