package gui.attendancelog;

import java.net.URL;
import java.util.ResourceBundle;

import BD.Facult;
import BD.Group;
import BD.Subjects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

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
            Facult.clear("subject");
            Subjects.createDB();
            labelException.setText("все предметы удалены");
            boxReload();
        });

        buttonAdd.setOnAction(actionEvent -> {
            if(box.getValue()==null){
                if(!textField.getText().equals("")){
                    try {
                        Subjects.writeDB(ChosenId.getGroup(), textField.getText());
                        textField.setText("");
                        labelException.setText("предмет\nуспешно\nдобавлен");
                        boxReload();
                    }
                    catch (Exception e){e.printStackTrace();}
                }
            }
            else {
                if(!textField.getText().equals("")){

                    Subjects.updateDBWhere(ChosenId.getGroup(), box.getValue(), textField.getText());

                    labelException.setText("предмет:\n"+ box.getValue()+"\nзаменена на:\n"+textField.getText());
                    textField.setText("");
                    boxReload();
                }
            }
        });

        box.setOnAction(actionEvent -> {
            buttonAdd.setText("заменить");
        });

        buttonUndo.setOnAction(actionEvent -> {
            boxReload();
            buttonAdd.setText("добавить");
        });
        buttonBackPage.setOnAction(actionEvent -> {

            Stage stage = (Stage) buttonBackPage.getScene().getWindow();
            stage.close();
        });
    }
    void boxReload(){
        ObservableList<String> e = FXCollections.observableArrayList();
        box.setItems(e);
        box.getItems().addAll(Subjects.outputDB(ChosenId.getGroup()));
    }

}
