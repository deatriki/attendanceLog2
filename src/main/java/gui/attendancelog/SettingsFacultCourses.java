package gui.attendancelog;

import java.net.URL;
import java.util.ResourceBundle;

import BD.Course;
import BD.Facult;
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
        labelException.setText("1.Для добавления\nфакультета введите \nв поле название\nи нажмите 'добавить'\n2.Для замены\nвыберите факультет\nи нажмите 'заменить'" +
                "\n3.Для удаления всех\nфакультетов \nнажмите 'очистить'" +
                "\n4.Для введения кол-во\nкурсов введите в\nполе рядом с \nкнопкой 'ок'\nколичество курсов\nи нажмите на кнопку");

        buttonClearFacult.setOnAction(actionEvent -> {
            Facult.clear("facult");
            Facult.createDB();
            boxReload();
        });

        boxFacult.getItems().addAll(Facult.outputDB("facult"));
        boxFacult.setOnAction(actionEvent -> {
            buttonAddFacult.setText("заменить");
        });

        buttonAddFacult.setOnAction(actionEvent -> {
            if(boxFacult.getValue()== null){
                if(textFieldFacult.getText() != "") {
                    try {
                        Facult.writeDB(textFieldFacult.getText());
                        textFieldFacult.setText("");
                        labelException.setText("факультет\nуспешно\nдобавлен");
                    }catch (Exception e){e.printStackTrace();}
                }
            }
            else{
                if(textFieldFacult.getText() != "") {
                    Facult.updateBDWhere(boxFacult.getValue(), textFieldFacult.getText());
                    labelException.setText("факультет:\n"+ boxFacult.getValue()+"\nзаменен на:\n"+textFieldFacult.getText());
                    textFieldFacult.setText("");
                }
            }
            boxReload();
        });

        buttonUndo.setOnAction(actionEvent -> {
            boxReload();
            buttonAddFacult.setText("добавить");
        });

        buttonCoursesOk.setOnAction(actionEvent -> {
            if(textFieldCourses.getText() != ""){
                if(Integer.parseInt(textFieldCourses.getText()) > 0){
                    try {
                        Facult.clear("course");
                        Course.createDB();
                        Course.writeDB(textFieldCourses.getText());
                        labelException.setText("успешно добав-\nлены\nкурсы от 1 до "+textFieldCourses.getText());
                        textFieldCourses.setText("");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    labelException.setText("введите число\nбольше 0");
                }
            }
        });
        buttonBackPage.setOnAction(actionEvent -> {
            Stage stage = (Stage) buttonBackPage.getScene().getWindow();
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
    }

    void boxReload(){
        ObservableList<String> e = FXCollections.observableArrayList();
        boxFacult.setItems(e);
        boxFacult.getItems().addAll(Facult.outputDB("facult"));
    }

}
