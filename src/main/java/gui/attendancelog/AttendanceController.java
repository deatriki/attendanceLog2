package gui.attendancelog;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AttendanceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonSettings;

    @FXML
    private TableColumn<EndTable, String> day1;

    @FXML
    private TableColumn<?, ?> day10;

    @FXML
    private TableColumn<?, ?> day11;

    @FXML
    private TableColumn<?, ?> day12;

    @FXML
    private TableColumn<?, ?> day13;

    @FXML
    private TableColumn<?, ?> day14;

    @FXML
    private TableColumn<?, ?> day15;

    @FXML
    private TableColumn<?, ?> day16;

    @FXML
    private TableColumn<?, ?> day17;

    @FXML
    private TableColumn<?, ?> day18;

    @FXML
    private TableColumn<?, ?> day19;

    @FXML
    private TableColumn<?, ?> day2;

    @FXML
    private TableColumn<?, ?> day20;

    @FXML
    private TableColumn<?, ?> day21;

    @FXML
    private TableColumn<?, ?> day22;

    @FXML
    private TableColumn<?, ?> day23;

    @FXML
    private TableColumn<?, ?> day24;

    @FXML
    private TableColumn<?, ?> day25;

    @FXML
    private TableColumn<?, ?> day26;

    @FXML
    private TableColumn<?, ?> day27;

    @FXML
    private TableColumn<?, ?> day28;

    @FXML
    private TableColumn<?, ?> day29;

    @FXML
    private TableColumn<?, ?> day3;

    @FXML
    private TableColumn<?, ?> day30;

    @FXML
    private TableColumn<?, ?> day31;

    @FXML
    private TableColumn<?, ?> day4;

    @FXML
    private TableColumn<?, ?> day5;

    @FXML
    private TableColumn<?, ?> day6;

    @FXML
    private TableColumn<?, ?> day7;

    @FXML
    private TableColumn<?, ?> day8;

    @FXML
    private TableColumn<?, ?> day9;

    @FXML
    private TableColumn<?, ?> month;

    @FXML
    private TableColumn<EndTable, String> students;

    @FXML
    private TableView<EndTable> table;

    @FXML
    void initialize() {
        ObservableList<EndTable> student = FXCollections.observableArrayList(
            new EndTable("anton", "-")
        );
        students.setCellValueFactory(new PropertyValueFactory<EndTable,String>("student"));
        table.setItems(student);
    }

}
