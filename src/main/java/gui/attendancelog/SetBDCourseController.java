package gui.attendancelog;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SetBDCourseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonADDInBD;

    @FXML
    private Button buttonClearBD;

    @FXML
    private Button buttonGoBackPage;

    @FXML
    private TextField textFieldADDInBD;

    @FXML
    private TextArea textShowBD;

    @FXML
    void initialize() {
        assert buttonADDInBD != null : "fx:id=\"buttonADDInBD\" was not injected: check your FXML file 'setBDCourse.fxml'.";
        assert buttonClearBD != null : "fx:id=\"buttonClearBD\" was not injected: check your FXML file 'setBDCourse.fxml'.";
        assert buttonGoBackPage != null : "fx:id=\"buttonGoBackPage\" was not injected: check your FXML file 'setBDCourse.fxml'.";
        assert textFieldADDInBD != null : "fx:id=\"textFieldADDInBD\" was not injected: check your FXML file 'setBDCourse.fxml'.";
        assert textShowBD != null : "fx:id=\"textShowBD\" was not injected: check your FXML file 'setBDCourse.fxml'.";

    }

}

