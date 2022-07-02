package gui.attendancelog;

import java.net.URL;
import java.util.ResourceBundle;

import BD.Attendance;
import BD.Subjects;
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

public class SettingsAttendanceController {

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

            Attendance.clearWhere(ChosenId.getGroup());
            labelException.setText("all students removed");
            boxReload();
        });

        buttonAdd.setOnAction(actionEvent -> {
            if(box.getValue()==null){
                if(!textField.getText().equals("")){
                    try {
                        for(int i = 1; i<32; i++) {
                            Attendance.writeDB(textField.getText(), ChosenId.getGroup(), ChosenId.getSubject(), "January", Integer.toString(i));
                        }
                        for(int i = 1; i<29; i++) {
                            Attendance.writeDB(textField.getText(), ChosenId.getGroup(), ChosenId.getSubject(), "February", Integer.toString(i));
                        }
                        for(int i = 1; i<32; i++) {
                            Attendance.writeDB(textField.getText(), ChosenId.getGroup(), ChosenId.getSubject(), "March", Integer.toString(i));
                        }
                        for(int i = 1; i<31; i++) {
                            Attendance.writeDB(textField.getText(), ChosenId.getGroup(), ChosenId.getSubject(), "April", Integer.toString(i));
                        }
                        for(int i = 1; i<32; i++) {
                            Attendance.writeDB(textField.getText(), ChosenId.getGroup(), ChosenId.getSubject(), "May", Integer.toString(i));
                        }
                        for(int i = 1; i<31; i++) {
                            Attendance.writeDB(textField.getText(), ChosenId.getGroup(), ChosenId.getSubject(), "June", Integer.toString(i));
                        }
                        for(int i = 1; i<32; i++) {
                            Attendance.writeDB(textField.getText(), ChosenId.getGroup(), ChosenId.getSubject(), "July", Integer.toString(i));
                        }
                        for(int i = 1; i<32; i++) {
                            Attendance.writeDB(textField.getText(), ChosenId.getGroup(), ChosenId.getSubject(), "August", Integer.toString(i));
                        }
                        for(int i = 1; i<31; i++) {
                            Attendance.writeDB(textField.getText(), ChosenId.getGroup(), ChosenId.getSubject(), "September", Integer.toString(i));
                        }
                        for(int i = 1; i<32; i++) {
                            Attendance.writeDB(textField.getText(), ChosenId.getGroup(), ChosenId.getSubject(), "October", Integer.toString(i));
                        }
                        for(int i = 1; i<31; i++) {
                            Attendance.writeDB(textField.getText(), ChosenId.getGroup(), ChosenId.getSubject(), "November", Integer.toString(i));
                        }
                        for(int i = 1; i<32; i++) {
                            Attendance.writeDB(textField.getText(), ChosenId.getGroup(), ChosenId.getSubject(), "December", Integer.toString(i));
                        }
                        textField.setText("");
                        labelException.setText("student\n" +
                                "successfully\n" +
                                "added");
                        boxReload();
                    }
                    catch (Exception e){e.printStackTrace();}
                }
            }
            else {
                if(!textField.getText().equals("")){

                    Attendance.updateDBWhere(box.getValue(), ChosenId.getSubject(), ChosenId.getGroup(), textField.getText());

                    labelException.setText("student:\n"+ box.getValue()+"\nreplaced with:\n"+textField.getText());
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

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Attendance.fxml"));

                Scene secondScene = new Scene(fxmlLoader.load(), 1050, 600);

                stage.setTitle("attendance table");
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
        box.getItems().addAll(Attendance.outputDB(ChosenId.getGroup(), ChosenId.getSubject()));
    }

}