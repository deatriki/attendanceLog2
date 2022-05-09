package gui.attendancelog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SettingsFacultCourses {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> boxFacult;

    @FXML
    private Button buttonAddFacult;

    @FXML
    private Button buttonBackPage;

    @FXML
    private Button buttonClearFacult;

    @FXML
    private Button buttonCoursesOk;

    @FXML
    private Label labelException;

    @FXML
    private TextField textFieldCourses;

    @FXML
    private TextField textFieldFacult;

    @FXML
    void initialize() {


    }

}
