package gui.attendancelog;
import java.net.URL;
import java.util.ResourceBundle;

import BD.Facult;
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
    void initialize(){

            buttonADDInBD.setOnAction(actionEvent -> {
                try {
                    Facult.writeDB(textFieldADDInBD.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });



    }
}

