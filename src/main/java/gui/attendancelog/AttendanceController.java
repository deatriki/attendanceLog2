package gui.attendancelog;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AttendanceController {

    public static ObservableList<EndTable> attendanceDate = FXCollections.observableArrayList(new EndTable("Kirril Good", "-"));

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<EndTable, String> attendance;

    @FXML
    private TableColumn<EndTable, String> student;

    @FXML
    private TableView<EndTable> table;

    @FXML
    void initialize() {
        table.setItems(attendanceDate);
    }

}
