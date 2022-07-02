package gui.attendancelog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import BD.Attendance;
import BD.Month;
import BD.Students;
import BD.Subjects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    private ComboBox<String> comboBoxMonth;

    @FXML
    private TableColumn<EndTable, String> day1;

    @FXML
    private TableColumn<EndTable, String> day10;

    @FXML
    private TableColumn<EndTable, String> day11;

    @FXML
    private TableColumn<EndTable, String> day12;

    @FXML
    private TableColumn<EndTable, String> day13;

    @FXML
    private TableColumn<EndTable, String> day14;

    @FXML
    private TableColumn<EndTable, String> day15;

    @FXML
    private TableColumn<EndTable, String> day16;

    @FXML
    private TableColumn<EndTable, String> day17;

    @FXML
    private TableColumn<EndTable, String> day18;

    @FXML
    private TableColumn<EndTable, String> day19;

    @FXML
    private TableColumn<EndTable, String> day2;

    @FXML
    private TableColumn<EndTable, String> day20;

    @FXML
    private TableColumn<EndTable, String> day21;

    @FXML
    private TableColumn<EndTable, String> day22;

    @FXML
    private TableColumn<EndTable, String> day23;

    @FXML
    private TableColumn<EndTable, String> day24;

    @FXML
    private TableColumn<EndTable, String> day25;

    @FXML
    private TableColumn<EndTable, String> day26;

    @FXML
    private TableColumn<EndTable, String> day27;

    @FXML
    private TableColumn<EndTable, String> day28;

    @FXML
    private TableColumn<EndTable, String> day29;

    @FXML
    private TableColumn<EndTable, String> day3;

    @FXML
    private TableColumn<EndTable, String> day30;

    @FXML
    private TableColumn<EndTable, String> day31;

    @FXML
    private TableColumn<EndTable, String> day4;

    @FXML
    private TableColumn<EndTable, String> day5;

    @FXML
    private TableColumn<EndTable, String> day6;

    @FXML
    private TableColumn<EndTable, String> day7;

    @FXML
    private TableColumn<EndTable, String> day8;

    @FXML
    private TableColumn<EndTable, String> day9;

    @FXML
    private TableColumn<EndTable, String> month;

    @FXML
    private TableColumn<EndTable, String> students;

    @FXML
    private TableView<EndTable> table;

    @FXML
    void initialize() {
        comboBoxMonth.setItems(Month.outputDB());
        table.setEditable(true);
        List<String> listStudents = Attendance.outputDB(ChosenId.getGroup(), ChosenId.getSubject());
        ObservableList<EndTable> student = FXCollections.observableArrayList();
        for(String i: listStudents) {
            student.add(new EndTable(i));
        }
        students.setCellValueFactory(new PropertyValueFactory<EndTable,String>("student"));
        List<TableColumn> month = FXCollections.observableArrayList();

        month.add(day1);
        month.add(day2);
        month.add(day3);
        month.add(day4);
        month.add(day5);
        month.add(day6);
        month.add(day7);
        month.add(day8);
        month.add(day9);
        month.add(day10);
        month.add(day11);
        month.add(day12);
        month.add(day13);
        month.add(day14);
        month.add(day15);
        month.add(day16);
        month.add(day17);
        month.add(day18);
        month.add(day19);
        month.add(day20);
        month.add(day21);
        month.add(day22);
        month.add(day23);
        month.add(day24);
        month.add(day25);
        month.add(day26);
        month.add(day27);
        month.add(day28);
        month.add(day29);
        month.add(day30);
        month.add(day31);



        comboBoxMonth.setOnAction(actionEvent -> {
            ObservableList<EndTable> months = FXCollections.observableArrayList();
            months.removeAll();
            for(TableColumn i : month){
                i.setCellFactory(TextFieldTableCell.forTableColumn());
            }


            System.out.println(ChosenId.getSubject());
            System.out.println(ChosenId.getGroup());
            System.out.println(comboBoxMonth.getValue());
            List<List<String>> attendedList = FXCollections.observableArrayList();
            for(int i = 1; i < 32; i++){
                attendedList.add(Attendance.outputDB(ChosenId.getGroup(), ChosenId.getSubject(), i, comboBoxMonth.getValue()));
            }

//лист из листов
//            for (int j = 0; j < listStudents.size(); j++) {
//                String[] array = new String[30];
//                for (int i = 0; i < array.length; i++) {
//                    array[i] = attendedList.get(i).get(j);
//                }
//                months.add(new EndTable(listStudents.get(j),array));
//            }
            if(comboBoxMonth.getValue() == "January" || comboBoxMonth.getValue() == "March"
            || comboBoxMonth.getValue() == "May" || comboBoxMonth.getValue() == "July"
            || comboBoxMonth.getValue() == "August" || comboBoxMonth.getValue() == "October"
            || comboBoxMonth.getValue() == "December") {
                for (int i = 0; i < listStudents.size(); i++) {
                    months.add(new EndTable(listStudents.get(i), attendedList.get(0).get(i), attendedList.get(1).get(i),
                            attendedList.get(2).get(i), attendedList.get(3).get(i), attendedList.get(4).get(i),
                            attendedList.get(5).get(i), attendedList.get(6).get(i), attendedList.get(7).get(i),
                            attendedList.get(8).get(i), attendedList.get(9).get(i), attendedList.get(10).get(i),
                            attendedList.get(11).get(i), attendedList.get(12).get(i), attendedList.get(13).get(i),
                            attendedList.get(14).get(i), attendedList.get(15).get(i), attendedList.get(16).get(i),
                            attendedList.get(17).get(i), attendedList.get(18).get(i), attendedList.get(19).get(i),
                            attendedList.get(20).get(i), attendedList.get(21).get(i), attendedList.get(22).get(i),
                            attendedList.get(23).get(i), attendedList.get(24).get(i), attendedList.get(25).get(i),
                            attendedList.get(26).get(i), attendedList.get(27).get(i), attendedList.get(28).get(i),
                            attendedList.get(29).get(i), attendedList.get(30).get(i)));

                }
            }
            else {
                if (comboBoxMonth.getValue().equals("February")) {
                    for (int i = 0; i < listStudents.size(); i++) {
                        months.add(new EndTable(listStudents.get(i), attendedList.get(0).get(i), attendedList.get(1).get(i),
                                attendedList.get(2).get(i), attendedList.get(3).get(i), attendedList.get(4).get(i),
                                attendedList.get(5).get(i), attendedList.get(6).get(i), attendedList.get(7).get(i),
                                attendedList.get(8).get(i), attendedList.get(9).get(i), attendedList.get(10).get(i),
                                attendedList.get(11).get(i), attendedList.get(12).get(i), attendedList.get(13).get(i),
                                attendedList.get(14).get(i), attendedList.get(15).get(i), attendedList.get(16).get(i),
                                attendedList.get(17).get(i), attendedList.get(18).get(i), attendedList.get(19).get(i),
                                attendedList.get(20).get(i), attendedList.get(21).get(i), attendedList.get(22).get(i),
                                attendedList.get(23).get(i), attendedList.get(24).get(i), attendedList.get(25).get(i),
                                attendedList.get(26).get(i), attendedList.get(27).get(i)));

                    }
                } else {
                    for (int i = 0; i < listStudents.size(); i++) {
                        months.add(new EndTable(listStudents.get(i), attendedList.get(0).get(i), attendedList.get(1).get(i),
                                attendedList.get(2).get(i), attendedList.get(3).get(i), attendedList.get(4).get(i),
                                attendedList.get(5).get(i), attendedList.get(6).get(i), attendedList.get(7).get(i),
                                attendedList.get(8).get(i), attendedList.get(9).get(i), attendedList.get(10).get(i),
                                attendedList.get(11).get(i), attendedList.get(12).get(i), attendedList.get(13).get(i),
                                attendedList.get(14).get(i), attendedList.get(15).get(i), attendedList.get(16).get(i),
                                attendedList.get(17).get(i), attendedList.get(18).get(i), attendedList.get(19).get(i),
                                attendedList.get(20).get(i), attendedList.get(21).get(i), attendedList.get(22).get(i),
                                attendedList.get(23).get(i), attendedList.get(24).get(i), attendedList.get(25).get(i),
                                attendedList.get(26).get(i), attendedList.get(27).get(i), attendedList.get(28).get(i),
                                attendedList.get(29).get(i)));

                    }
                }
            }
            System.out.println("progruzka");
            System.out.println(months);
            System.out.println(listStudents);
            int j = 1;
            for(TableColumn i : month){
                i.setCellValueFactory(new PropertyValueFactory<EndTable, String>("day"+j));
                j++;
            }

            boxReload();
            students.setCellValueFactory(new PropertyValueFactory<EndTable,String>("student"));
            table.setItems(months);
//            table.getItems().addAll(months);
        });

        int dayCount = 0;
        for(TableColumn i : month) {
            dayCount++;
            int finalDayCount = dayCount;
            i.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<EndTable, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<EndTable, String> event) {
                    String day = Integer.toString(finalDayCount);
                    EndTable endTable = event.getRowValue();

                    System.out.println();
                    System.out.println(event.getTablePosition().getRow());
                    System.out.println(event.getNewValue());
//                System.out.println(students.getColumns().get(event.getTablePosition().getRow()));
                    System.out.println(students.getCellObservableValue(event.getTablePosition().getRow()).getValue());  //имя находит
                    if (comboBoxMonth.getValue() != null) {
                        String student = students.getCellObservableValue(event.getTablePosition().getRow()).getValue();
                        Attendance.updateDBWhere(student, ChosenId.getSubject(), ChosenId.getGroup(), event.getNewValue(), day, comboBoxMonth.getValue());
                    }


                    endTable.setDay1(event.getNewValue());

                }
            });

        }

        table.setItems(student);

        buttonSettings.setOnAction(actionEvent -> {
            Stage stage = (Stage) buttonSettings.getScene().getWindow();
            try{

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("settingsAttendance.fxml"));

                Scene secondScene = new Scene(fxmlLoader.load(), 520, 340);

                stage.setTitle("student settings");
                stage.setScene(secondScene);


                stage.show();


            }
            catch (IOException e){
                e.printStackTrace();
            }
        });
        buttonBack.setOnAction(actionEvent -> {
            Stage stage = (Stage) buttonBack.getScene().getWindow();
            try{

                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("subject.fxml"));

                Scene secondScene = new Scene(fxmlLoader.load(), 260, 200);

                stage.setTitle("select subject");
                stage.setScene(secondScene);


                stage.show();


            }
            catch (IOException e){
                e.printStackTrace();
            }
        });
    }
    void boxReload(){
        ObservableList<EndTable> e = FXCollections.observableArrayList();
        table.setItems(e);
        table.refresh();
        table.getItems().addAll(e);
        table.getItems().clear();
    }
}
