package gui.attendancelog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonChooseCourse;

    @FXML
    private AnchorPane bg;

    @FXML
    private Button button1;

    @FXML
    private SplitMenuButton coursesMenuButton;

    @FXML
    void initialize() {
//        button1.setOnAction(actionEvent -> {
//            try{
//                Parent secondWindow = FXMLLoader.load(getClass().getResource("setBDCourse.fxml"));
//                Stage secondStage = new Stage();
//                secondStage.setTitle("BD");
//                secondStage.setScene(new Scene(secondWindow, 700, 400));
//                secondStage.show();
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//        });

    }

}