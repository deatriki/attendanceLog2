package gui.settings;

import java.net.URL;
import java.util.ResourceBundle;

import BD.Course;
import BD.Facult;
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

public class SettingsFacultCourses {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxFacult;

    @FXML
    private Button buttonAddFacult;

    @FXML
    private Button buttonBackPage;

    @FXML
    private Button buttonClearFacult;

    @FXML
    private Button buttonCoursesOk;

    @FXML
    private Button buttonUndo;

    @FXML
    private Label labelException;

    @FXML
    private TextField textFieldCourses;

    @FXML
    private TextField textFieldFacult;

    @FXML
    void initialize() {
        labelException.setText("1.To add\nfaculty, enter \nin the name field\nand click 'add'\n2. To replace\nselect the faculty\nand click 'replace'\n" +
                "                 \n3. To remove all\nfaculties \nclick 'clear' \n" +
                "                 \n4. To enter the number of\ncourses, enter in the\nfield next to the \nok button\nthe number of courses\nand press the button");

        buttonClearFacult.setOnAction(actionEvent -> {
            Facult.clear("facult");
            Facult.createDB();
            boxReload();
        });

        boxFacult.getItems().addAll(Facult.outputDB("facult"));
        boxFacult.setOnAction(actionEvent -> {
            buttonAddFacult.setText("replace");
        });

        buttonAddFacult.setOnAction(actionEvent -> {
            if(boxFacult.getValue()== null){
                if(textFieldFacult.getText() != "") {
                    try {
                        Facult.writeDB(textFieldFacult.getText());
                        textFieldFacult.setText("");
                        labelException.setText("faculty\n" +
                                "successfully\n" +
                                "added");
                    }catch (Exception e){e.printStackTrace();}
                }
            }
            else{
                if(textFieldFacult.getText() != "") {
                    Facult.updateBDWhere(boxFacult.getValue(), textFieldFacult.getText());
                    labelException.setText("faculty:\n"+ boxFacult.getValue()+"\nreplaced with:\n"+textFieldFacult.getText());
                    textFieldFacult.setText("");
                }
            }
            boxReload();
        });

        buttonUndo.setOnAction(actionEvent -> {
            boxReload();
            buttonAddFacult.setText("add");
        });

        buttonCoursesOk.setOnAction(actionEvent -> {
            if(textFieldCourses.getText() != ""){
                if(Integer.parseInt(textFieldCourses.getText()) > 0){
                    try {
                        Facult.clear("course");
                        Course.createDB();
                        Course.writeDB(textFieldCourses.getText());
                        labelException.setText("successfully added\n" +
                                "courses from 1 to "+textFieldCourses.getText());
                        textFieldCourses.setText("");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    labelException.setText("enter a number\n" +
                            "more than 0");
                }
            }
        });
        buttonBackPage.setOnAction(actionEvent -> {
            Stage stage = (Stage) buttonBackPage.getScene().getWindow();
            try{

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainWindow.fxml"));

                Scene secondScene = new Scene(fxmlLoader.load(), 520, 340);

                stage.setTitle("attendance log v2");
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
        boxFacult.setItems(e);
        boxFacult.getItems().addAll(Facult.outputDB("facult"));
    }

}
